package mockmodels;

import java.awt.image.BufferedImage;
import world.World;

/**
 * A Mock model for Human Player which isolates the controller.This model class
 * merely logs the inputs provided to it, and returns a unique number provided
 * to it at creation.It tests whether the inputs provided to the controller were
 * correctly transmitted to the model, and the results from the model were
 * correctly transmitted to the Appendable object by the controller.
 */
public class WorldMockModelAttackWithoutWepon implements World {
  private StringBuilder log;
  private final int uniqueCode;

  /**
   * Constructor to initialize WorldMockModelHuman class fields.
   * 
   * @param log        log of string builder
   * @param uniqueCode unique code of integer type
   */
  public WorldMockModelAttackWithoutWepon(StringBuilder log, int uniqueCode) {
    this.log = log;
    this.uniqueCode = uniqueCode;
  }

  @Override
  public String getSpaceInformation(String roomName) throws IllegalArgumentException {
    log.append("getSpaceInformation method invoked with input " + roomName);
    return String.format("UniqueCode is " + uniqueCode);
  }

  @Override
  public void createWorldGraphicalRep() {
    log.append("Create world graphical representation method invoked" + "\n");
    log.append(String.format("UniqueCode is " + uniqueCode));
  }

  @Override
  public void addHumanPlayer(String playerName, int playerItemsLimit, String playerRoomName) {
    log.append("addHumanPlayer method invoked with player name, " + playerName + "player item limit"
        + playerItemsLimit + "player room name" + playerRoomName + "\n");
    log.append(String.format("UniqueCode is " + uniqueCode));
  }

  @Override
  public void addComputerPlayer() {
    log.append("addComputerPlayer method invoked" + "\n");
    log.append(String.format("UniqueCode is " + uniqueCode));
  }

  @Override
  public void movePlayer(int x, int y) {
    log.append("movePlayer method invoked with input " + x + y);
    log.append(String.format("UniqueCode is " + uniqueCode));
  }

  @Override
  public void playerPickItems(String itemName) {
    log.append("playerPickItems method invoked with input " + itemName);
    log.append(String.format("UniqueCode is " + uniqueCode));
  }

  @Override
  public String playerLookAround() {
    log.append("playerLookAround method invoked");
    return String.format("UniqueCode is " + uniqueCode);
  }

  @Override
  public boolean checkComputerPlayer() {
    log.append("checkComputerPlayer method invoked" + "\n");
    return false;
  }

  @Override
  public void movePet(String roomName) {
    log.append("movePet method invoked with input " + roomName);
    log.append(String.format("UniqueCode is " + uniqueCode));
  }

  @Override
  public String attackTarget(String itemName) {
    log.append("attackTarget method invoked with input " + itemName);
    return String.format("UniqueCode is " + uniqueCode);
  }

  @Override
  public String getPlayerClues() {
    log.append("getPlayerClues method invoked");
    return String.format("UniqueCode is " + uniqueCode);
  }

  @Override
  public String playComputerPlayer() {
    log.append("playComputerPlayer method invoked" + "\n");
    return String.format("UniqueCode is " + uniqueCode);
  }

  @Override
  public Boolean checkIfPlayerHasItems() {
    log.append("checkIfPlayerHasItems method invoked" + "\n");
    return false;
  }

  @Override
  public String attackTargetWithoutItems() {
    log.append("attackTargetWithoutItems method invoked" + "\n");
    return String.format("UniqueCode is " + uniqueCode);
  }

  @Override
  public String getPlayerNameTurn() {
    log.append("getPlayerNameTurn method invoked" + "\n");
    return String.format("UniqueCode is " + uniqueCode);
  }

  @Override
  public Boolean isGameOver() {
    log.append("isGameNotOver method invoked" + "\n");
    return true;
  }

  @Override
  public String getWinner() {
    log.append("getWinner method invoked" + "\n");
    return String.format("UniqueCode is " + uniqueCode);
  }

  @Override
  public String[] getRooms() {
    log.append("getRooms method invoked" + "\n");
    String[] arr = { Integer.toString(uniqueCode) };
    return arr;
  }

  @Override
  public String[] getRoomItems() {
    log.append("getRoomItemss method invoked" + "\n");
    String[] arr = { Integer.toString(uniqueCode) };
    return arr;
  }

  @Override
  public String[] getPlayerItems() {
    log.append("getPlayerItems method invoked" + "\n");
    String[] arr = { Integer.toString(uniqueCode) };
    return arr;
  }

  @Override
  public String getPlayers() {
    log.append("getPlayers method invoked" + "\n");
    return String.format("UniqueCode is " + uniqueCode);
  }

  @Override
  public BufferedImage getWorldMap() {
    log.append("BufferedImage method invoked" + "\n");
    return null;
  }

  @Override
  public void startNewGame() {
    log.append("startNewGame method invoked");
    log.append(String.format("UniqueCode is " + uniqueCode));
  }

  @Override
  public String getPlayerDescription() {
    log.append("get player description method invoked");
    return String.format("UniqueCode is " + uniqueCode);
  }

  @Override
  public boolean checkPlayerInfo(int y, int x) throws IllegalArgumentException {
    log.append("checkplayerinfo method invoked");
    return false;
  }
}
