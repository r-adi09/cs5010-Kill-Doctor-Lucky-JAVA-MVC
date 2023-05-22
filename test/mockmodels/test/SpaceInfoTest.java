package mockmodels.test;

import static org.junit.Assert.assertEquals;

import mockmodels.WorldMockModelHuman;
import org.junit.Before;
import org.junit.Test;
import world.World;
import world.control.commands.SpaceInfo;
import world.control.commands.WorldCommand;

/**
 * A test class to test SpaceInfo command controller.
 *
 */
public class SpaceInfoTest {
  private World model;
  private StringBuilder log;
  private StringBuffer out;
  private WorldCommand world;

  /**
   * initializes log, model and out fields.
   */
  @Before
  public void setUp() {
    log = new StringBuilder();
    model = new WorldMockModelHuman(log, 1234321);
    out = new StringBuffer();
  }

  /**
   * test space info for mock model.
   */
  @Test
  public void testSpaceInfoTest() {
    String in = "Kitchen";
    world = new SpaceInfo(in, out);
    world.go(model);
    StringBuilder sb = new StringBuilder();
    sb.append("getSpaceInformation method invoked with input Kitchen");
    assertEquals(sb.toString(), log.toString()); // output from model received correctly
    assertEquals("UniqueCode is 1234321\n", out.toString());
  }
}
