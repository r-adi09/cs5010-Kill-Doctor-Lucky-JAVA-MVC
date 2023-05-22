package world.control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import world.ConcreteWorld;
import world.RandomImplementaion;
import world.World;
import world.control.commands.AddComputerPlayer;
import world.control.commands.AddHumanPlayer;
import world.control.commands.MovePet;
import world.control.commands.PickItem;
import world.control.commands.WorldCommand;
import world.view.KillDoctorLuckyView;
import world.view.KillDoctorLuckyViewImpl;

/**
 * 
 * Implements World controller to interact with the model.
 *
 */
public class WorldCommandControl implements Features, WorldController {

  private KillDoctorLuckyView view;
  private World model;

  private final int turns;
  private String file;

  /**
   * Controller constructor which implements all the fields of the class.
   * 
   * @param model world model object.
   * @param turns total number turns.
   * @param file  file of string represention.
   */
  public WorldCommandControl(World model, int turns, String file) {
    if (model == null) {
      throw new IllegalArgumentException("Invalid model");
    }
    if (turns < 0) {
      throw new IllegalArgumentException("Invalid turns");
    }
    if (file == null || file.trim().isEmpty() || "".equals(file.trim())) {
      throw new IllegalArgumentException("Invalid file");
    }
    this.model = model;
    this.turns = turns;
    this.file = file;
  }

  @Override
  public void playGame(KillDoctorLuckyView view) throws IllegalArgumentException {
    if (view == null) {
      throw new IllegalArgumentException("Invalid view");
    }
    this.view = view;
    view.makeWelcomePanelVisible();
    view.setFeatures(this);
  }

  @Override
  public void startNewGame() throws IllegalArgumentException {
    Readable fr = null;
    try {
      fr = new FileReader(this.file);
    } catch (FileNotFoundException e) {
      view.showErrorMessageBox("File not Found");
    }
    view.startNewGame();
    model = new ConcreteWorld(fr, new RandomImplementaion(), turns);
    KillDoctorLuckyView gameview = new KillDoctorLuckyViewImpl(model);
    WorldController gamecontroller = new WorldCommandControl(model, turns, this.file);
    gamecontroller.playGame(gameview);
  }

  @Override
  public void startNewMapGame(String map) {
    if (map == null || map.trim().isEmpty() || "".equals(map.trim())) {
      throw new IllegalArgumentException("Invalid file");
    }
    Readable fr = null;
    try {
      fr = new FileReader(map);
    } catch (FileNotFoundException e) {
      view.showErrorMessageBox("File not Found");
    }
    WorldController gamecontroller;
    try {
      model = new ConcreteWorld(fr, new RandomImplementaion(), turns);
      KillDoctorLuckyView gameview = new KillDoctorLuckyViewImpl(model);
      view.startNewGame();
      gamecontroller = new WorldCommandControl(model, turns, map);
      gamecontroller.playGame(gameview);
    } catch (InputMismatchException e) {
      view.showErrorMessageBox("File format is wrong");
      gamecontroller = new WorldCommandControl(model, turns, this.file);
      gamecontroller.playGame(this.view);
    }
  }

  @Override
  public void addHumanPlayer(String playerName, String playerRoomName, String playerItemsLimit) {
    if (playerName == null || playerName.trim().isEmpty() || "".equals(playerName.trim())) {
      view.showErrorMessageBox("player name cannot be null");
      throw new IllegalArgumentException("Invalid player name");
    }
    if (playerRoomName == null || playerRoomName.trim().isEmpty()
        || "".equals(playerRoomName.trim())) {
      throw new IllegalArgumentException("Invalid room name");
    }
    if (playerItemsLimit == null || playerItemsLimit.trim().isEmpty()
        || "".equals(playerItemsLimit.trim())) {
      throw new IllegalArgumentException("Invalid items");
    }
    int items = Integer.parseInt(playerItemsLimit);
    WorldCommand obj = new AddHumanPlayer(playerName, playerRoomName, items);
    try {
      obj.go(model);
      view.showMessageBox("Human player added to the game");
    } catch (IllegalArgumentException e) {
      view.showErrorMessageBox("Player details invalid");
    } catch (IllegalStateException e) {
      view.showErrorMessageBox("Players limit exceeded");
    }
  }

  @Override
  public void addComputerPlayer() {
    WorldCommand obj = new AddComputerPlayer();
    try {
      obj.go(model);
      view.showMessageBox("Computer player added to the game");
    } catch (IllegalStateException e) {
      view.showErrorMessageBox("Players limit exceeded");
    }
  }

  @Override
  public void startGame() {
    if (model.getPlayers().length() == 2) {
      view.showErrorMessageBox("Atleast one player needs to be added to play game");
    } else {
      view.startGame();
      checkComputerPlayer();
    }
  }

  private void checkComputerPlayer() {
    checkIfGameOver();
    while (model.checkComputerPlayer()) {
      view.showTurnMessageBox(model.playComputerPlayer());
      checkIfGameOver();
    }
  }

  private void checkIfGameOver() {
    if (model.isGameOver()) {
      view.showTurnMessageBox(model.getWinner());
      view.quitGame();
    }
  }

  @Override
  public void addPlayers() {
    view.addPlayers();
  }

  @Override
  public void lookAround() {
    view.showTurnMessageBox(model.playerLookAround());
    checkComputerPlayer();
    checkIfGameOver();
  }

  @Override
  public void pickItem(String itemName) {
    if (itemName == null || itemName.trim().isEmpty() || "".equals(itemName.trim())) {
      throw new IllegalArgumentException("invalid item name");
    }
    WorldCommand obj = new PickItem(itemName);
    try {
      obj.go(model);
      view.showTurnMessageBox("Item picked by player");
      checkComputerPlayer();
      checkIfGameOver();
    } catch (IllegalStateException e) {
      view.showErrorMessageBox("room does not contain any items");
    } catch (IllegalArgumentException e) {
      view.showErrorMessageBox("Can't pick item, as it extends player's item limit");
    }
  }

  @Override
  public void attackTarget(String itemName) {
    if (itemName == null || itemName.trim().isEmpty() || "".equals(itemName.trim())) {
      throw new IllegalArgumentException("invalid item name");
    }
    try {
      model.attackTarget(itemName);
      view.showTurnMessageBox("Attack Target successful");
    } catch (IllegalArgumentException e) {
      view.showTurnMessageBox("Attack Target unsuccessful, as target is not in same room");
    } catch (IllegalStateException e) {
      view.showTurnMessageBox(
          "Attack Target unsuccessful, as player can se be seen by other players");
    }
    checkComputerPlayer();
    checkIfGameOver();
  }

  @Override
  public void playerItems() {
    try {
      model.attackTargetWithoutItems();
      view.showTurnMessageBox("Attack Target successful");
    } catch (IllegalArgumentException e) {
      view.showTurnMessageBox("Attack Target unsuccessful, as target is not in same room");
    } catch (IllegalStateException e) {
      view.showTurnMessageBox(
          "Attack Target unsuccessful, as player can se be seen by other players");
    }
    checkComputerPlayer();
    checkIfGameOver();
  }

  @Override
  public void movePet(String roomName) {
    if (roomName == null || roomName.trim().isEmpty() || "".equals(roomName.trim())) {
      throw new IllegalArgumentException("invalid room name");
    }
    WorldCommand obj = new MovePet(roomName);
    obj.go(model);
    view.showTurnMessageBox("Pet moved to another room");
    checkComputerPlayer();
    checkIfGameOver();
  }

  @Override
  public void quitGame() {
    view.quitGame();
  }

  @Override
  public void movePlayer(int i, int j) {
    try {
      if (model.checkPlayerInfo(i, j)) {
        view.showMessageBox(model.getPlayerDescription());
      } else {
        model.movePlayer(i, j);
        view.showTurnMessageBox("Moved Player to another room");
        checkComputerPlayer();
        checkIfGameOver();
      }
    } catch (IllegalArgumentException e) {
      view.showTurnMessageBox("Cannot Move Player to non neighbor space");
    } catch (IllegalStateException e) {
      view.showTurnMessageBox("Cannot move player to  invalid space");
    }
  }

}
