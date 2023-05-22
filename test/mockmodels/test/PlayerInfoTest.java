package mockmodels.test;

import static org.junit.Assert.assertEquals;

import mockmodels.WorldMockModelHuman;
import org.junit.Before;
import org.junit.Test;
import world.World;
import world.control.commands.PlayerInfo;
import world.control.commands.WorldCommand;

/**
 * A test class to test PlayerInfo command controller.
 *
 */
public class PlayerInfoTest {

  private World model;
  private StringBuilder log;
  private StringBuffer out;
  private WorldCommand world;

  /**
   * initializes up log, model and out fields.
   */
  @Before
  public void setUp() {
    log = new StringBuilder();
    model = new WorldMockModelHuman(log, 1234321);
    out = new StringBuffer();
  }

  /**
   * test player info for mock model.
   */
  @Test
  public void testPlayerInfoTest() {
    world = new PlayerInfo();
    world.go(model);
    StringBuilder sb = new StringBuilder();
    sb.append("getPlayerDescription method invoked with input sahith");
    assertEquals(sb.toString(), log.toString()); // output from model received correctly
    assertEquals("UniqueCode is 1234321\n", out.toString());
  }

}
