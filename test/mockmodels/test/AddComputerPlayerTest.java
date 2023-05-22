package mockmodels.test;

import static org.junit.Assert.assertEquals;

import mockmodels.WorldMockModelComputer;
import org.junit.Before;
import org.junit.Test;
import world.World;
import world.control.commands.AddComputerPlayer;
import world.control.commands.WorldCommand;

/**
 * A test class to test AddComputer command controller.
 *
 */
public class AddComputerPlayerTest {

  private World model;
  private StringBuilder log;
  private WorldCommand world;

  /**
   * sets up the value model, log and out fields.
   */
  @Before
  public void setUp() {
    log = new StringBuilder();
    model = new WorldMockModelComputer(log, 1234321);
  }

  /**
   * testing add computer for mock model.
   */
  @Test
  public void testAddComputerPlayerTest() {
    world = new AddComputerPlayer();
    world.go(model);
    StringBuilder sb = new StringBuilder();
    sb.append("addComputerPlayer method invoked" + "\n");
    sb.append(String.format("UniqueCode is 1234321"));
    assertEquals(sb.toString(), log.toString()); // output from model received correctly
  }

}
