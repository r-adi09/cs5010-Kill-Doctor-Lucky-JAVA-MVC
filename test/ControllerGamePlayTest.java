import static org.junit.Assert.assertEquals;

import mockmodels.MockViewKillDoctorLucky;
import mockmodels.WorldMockModelHuman;
import org.junit.Before;
import org.junit.Test;
import world.control.WorldCommandControl;

/**
 * Test to check working of various actions in the game.
 */
public class ControllerGamePlayTest {

  private StringBuilder sbuilder;
  private WorldMockModelHuman model;
  private WorldCommandControl controller;
  private MockViewKillDoctorLucky view;

  /**
   * This is a setup() method which initializes a mock model, mock view and a
   * controller object for testing.
   */
  @Before
  public void setUp() {
    sbuilder = new StringBuilder();
    model = new WorldMockModelHuman(sbuilder, 5400);
    view = new MockViewKillDoctorLucky(sbuilder, 5500);
    controller = new WorldCommandControl(model, 5, "res/mansion.txt");
  }

  @Test
  public void startNewGameTest() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());
    controller.startNewGame();
    assertEquals(
        "makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n" + "setFeatures invoked\n"
            + "Unique Code: 5500\n" + "startNewGame invoked\n" + "Unique Code: 5500\n" + "",
        sbuilder.toString());

  }

  @Test
  public void startNewMapGame() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());
    controller.startNewMapGame("res/mansion.txt");
    assertEquals(
        "makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n" + "setFeatures invoked\n"
            + "Unique Code: 5500\n" + "startNewGame invoked\n" + "Unique Code: 5500\n" + "",
        sbuilder.toString());

  }

  @Test
  public void addHumanplayer() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());
    controller.addHumanPlayer("Shelby", "Kitchen", "1");
    assertEquals(
        "makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n" + "setFeatures invoked\n"
            + "Unique Code: 5500\n" + "addHumanPlayer method invoked with player name, Shelbyplayer"
            + " item limit1player room nameKitchen\n"
            + "UniqueCode is 5400showMessageBox invoked with inputHuman player added to the game\n"
            + "Unique Code: 5500\n" + "",
        sbuilder.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void addHumanplayerInvalid() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());
    controller.addHumanPlayer(null, null, "1");
  }

  @Test
  public void addComputerPlayer() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());
    controller.addComputerPlayer();
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "addComputerPlayer method invoked\n"
        + "UniqueCode is 5400showMessageBox invoked with inputComputer player added to the game\n"
        + "Unique Code: 5500\n" + "", sbuilder.toString());

  }

  /**
   * Game cannot be started without adding players.
   */
  public void startGameTestInvalid() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());
    controller.startGame();
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());

  }

  @Test
  public void lookAroundTest() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());
    controller.addHumanPlayer("Shelby", "Kitchen", "1");
    controller.lookAround();
    assertEquals(
        "makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n" + "setFeatures invoked\n"
            + "Unique Code: 5500\n" + "addHumanPlayer method invoked with player name,"
            + " Shelbyplayer item limit1player room nameKitchen\n"
            + "UniqueCode is 5400showMessageBox invoked with inputHuman player added to the game\n"
            + "Unique Code: 5500\n" + "playerLookAround method invokedshowTurnMessageBox invoked\n"
            + "Unique Code: 5500\n" + "isGameNotOver method invoked\n"
            + "getWinner method invoked\n" + "showTurnMessageBox invoked\n" + "Unique Code: 5500\n"
            + "quitGame invoked\n" + "Unique Code: 5500\n" + "checkComputerPlayer method invoked\n"
            + "isGameNotOver method invoked\n" + "getWinner method invoked\n"
            + "showTurnMessageBox invoked\n" + "Unique Code: 5500\n" + "quitGame invoked\n"
            + "Unique Code: 5500\n" + "",
        sbuilder.toString());

  }

  @Test
  public void pickItemTest() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());
    controller.addHumanPlayer("Shelby", "Kitchen", "1");
    controller.pickItem("Crepe Pan");
    assertEquals(
        "makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n" + "setFeatures invoked\n"
            + "Unique Code: 5500\n" + "addHumanPlayer method invoked with player name,"
            + " Shelbyplayer item limit1player room nameKitchen\n"
            + "UniqueCode is 5400showMessageBox invoked with inputHuman player added to the game\n"
            + "Unique Code: 5500\n" + "playerPickItems method invoked with input Crepe"
            + " PanUniqueCode is 5400showTurnMessageBox invoked\n" + "Unique Code: 5500\n"
            + "isGameNotOver method invoked\n" + "getWinner method invoked\n"
            + "showTurnMessageBox invoked\n" + "Unique Code: 5500\n" + "quitGame invoked\n"
            + "Unique Code: 5500\n" + "checkComputerPlayer method invoked\n"
            + "isGameNotOver method invoked\n" + "getWinner method invoked\n"
            + "showTurnMessageBox invoked\n" + "Unique Code: 5500\n" + "quitGame invoked\n"
            + "Unique Code: 5500\n" + "",
        sbuilder.toString());

  }

  @Test(expected = IllegalArgumentException.class)
  public void pickItemTestInvalid() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());
    controller.addHumanPlayer("Shelby", "Kitchen", "1");
    controller.pickItem(null);
  }

  @Test
  public void attackTargetTest() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());
    controller.addHumanPlayer("Shelby", "Armory", "1");
    controller.attackTarget("Revolver");
    assertEquals(
        "makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n" + "setFeatures invoked\n"
            + "Unique Code: 5500\n" + "addHumanPlayer method invoked with player name,"
            + " Shelbyplayer item limit1player room nameArmory\n"
            + "UniqueCode is 5400showMessageBox invoked with inputHuman player added to the game\n"
            + "Unique Code: 5500\n"
            + "attackTarget method invoked with input RevolvershowTurnMessageBox invoked\n"
            + "Unique Code: 5500\n" + "isGameNotOver method invoked\n"
            + "getWinner method invoked\n" + "showTurnMessageBox invoked\n" + "Unique Code: 5500\n"
            + "quitGame invoked\n" + "Unique Code: 5500\n" + "checkComputerPlayer method invoked\n"
            + "isGameNotOver method invoked\n" + "getWinner method invoked\n"
            + "showTurnMessageBox invoked\n" + "Unique Code: 5500\n" + "quitGame invoked\n"
            + "Unique Code: 5500\n",
        sbuilder.toString());

  }

  @Test(expected = IllegalArgumentException.class)
  public void attackTargettestInvalid() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());
    controller.addHumanPlayer("Shelby", "Kitchen", "1");
    controller.attackTarget(null);
  }

  @Test
  public void movepetTest() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());
    controller.movePet("Kitchen");
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n"
        + "movePet method invoked with input KitchenUniqueCode is 5400showTurnMessageBox invoked\n"
        + "Unique Code: 5500\n" + "isGameNotOver method invoked\n" + "getWinner method invoked\n"
        + "showTurnMessageBox invoked\n" + "Unique Code: 5500\n" + "quitGame invoked\n"
        + "Unique Code: 5500\n" + "checkComputerPlayer method invoked\n"
        + "isGameNotOver method invoked\n" + "getWinner method invoked\n"
        + "showTurnMessageBox invoked\n" + "Unique Code: 5500\n" + "quitGame invoked\n"
        + "Unique Code: 5500\n" + "", sbuilder.toString());

  }

  @Test(expected = IllegalArgumentException.class)
  public void movepetInvalid() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());
    controller.addHumanPlayer("Shelby", "Kitchen", "1");
    controller.movePet(null);
  }

  @Test
  public void quitGameTest() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());
    controller.addHumanPlayer("Shelby", "Armory", "1");
    controller.attackTarget("Revolver");
    controller.quitGame();
    assertEquals(
        "makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n" + "setFeatures invoked\n"
            + "Unique Code: 5500\n" + "addHumanPlayer method invoked with player name, Shelbyplayer"
            + " item limit1player room nameArmory\n"
            + "UniqueCode is 5400showMessageBox invoked with inputHuman player added to the game\n"
            + "Unique Code: 5500\n"
            + "attackTarget method invoked with input RevolvershowTurnMessageBox invoked\n"
            + "Unique Code: 5500\n" + "isGameNotOver method invoked\n"
            + "getWinner method invoked\n" + "showTurnMessageBox invoked\n" + "Unique Code: 5500\n"
            + "quitGame invoked\n" + "Unique Code: 5500\n" + "checkComputerPlayer method invoked\n"
            + "isGameNotOver method invoked\n" + "getWinner method invoked\n"
            + "showTurnMessageBox invoked\n" + "Unique Code: 5500\n" + "quitGame invoked\n"
            + "Unique Code: 5500\n" + "quitGame invoked\n" + "Unique Code: 5500\n" + "",
        sbuilder.toString());

  }

  @Test
  public void movePlayerTest() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());

    controller.addHumanPlayer("Shelby", "Armory", "1");
    controller.movePlayer(19, 23);
    assertEquals(
        "makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n" + "setFeatures invoked\n"
            + "Unique Code: 5500\n" + "addHumanPlayer method invoked with player name, Shelbyplayer"
            + " item limit1player room nameArmory\n"
            + "UniqueCode is 5400showMessageBox invoked with inputHuman player added to the game\n"
            + "Unique Code: 5500\n" + "checkplayerinfo method invokedmovePlayer method invoked with"
            + " input 1923UniqueCode is 5400showTurnMessageBox invoked\n" + "Unique Code: 5500\n"
            + "isGameNotOver method invoked\n" + "getWinner method invoked\n"
            + "showTurnMessageBox invoked\n" + "Unique Code: 5500\n" + "quitGame invoked\n"
            + "Unique Code: 5500\n" + "checkComputerPlayer method invoked\n"
            + "isGameNotOver method invoked\n" + "getWinner method invoked\n"
            + "showTurnMessageBox invoked\n" + "Unique Code: 5500\n" + "quitGame invoked\n"
            + "Unique Code: 5500\n" + "",
        sbuilder.toString());

  }

  @Test
  public void movePlayerInvalid() {
    controller.playGame(view);
    assertEquals("makeWelcomePanelVisible invoked\n" + "Unique Code: 5500\n"
        + "setFeatures invoked\n" + "Unique Code: 5500\n" + "", sbuilder.toString());
    controller.addHumanPlayer("Shelby", "Kitchen", "1");
    controller.movePlayer(-1, -4);
  }
}