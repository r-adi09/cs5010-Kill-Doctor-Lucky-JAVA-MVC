package mockmodels.test;

import static org.junit.Assert.assertEquals;

import mockmodels.WorldMockModelHuman;
import org.junit.Before;
import org.junit.Test;
import world.World;
import world.control.commands.AddHumanPlayer;
import world.control.commands.WorldCommand;

/**
 * A test class to test AddHumanPlayer command controller.
 *
 */
public class AddHumanPlayerTest {

  private World model;
  private StringBuilder log;
  private WorldCommand world;

  /**
   * sets up log,model and out fields.
   */
  @Before
  public void setUp() {
    log = new StringBuilder();
    model = new WorldMockModelHuman(log, 1234321);
  }

  /**
   * testing add human mock.
   */
  @Test
  public void testAddHumanPlayerTest() {
    String playerName = "sahith";
    int playerItemsLimit = 0;
    String playerRoomName = "Kitchen";
    world = new AddHumanPlayer(playerName, playerRoomName, playerItemsLimit);
    world.go(model);
    StringBuilder sb = new StringBuilder();
    sb.append("addHumanPlayer method invoked with player name, " + playerName + "player item limit"
        + playerItemsLimit + "player room name" + playerRoomName + "\n");
    sb.append(String.format("UniqueCode is 1234321"));
    assertEquals(sb.toString(), log.toString()); // output from model received correctly
  }

}
