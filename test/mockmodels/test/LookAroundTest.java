package mockmodels.test;

import static org.junit.Assert.assertEquals;

import mockmodels.WorldMockModelHuman;
import org.junit.Before;
import org.junit.Test;
import world.World;
import world.control.commands.LookAround;
import world.control.commands.WorldCommand;

/**
 * A test class to test LookAround command controller.
 *
 */
public class LookAroundTest {

  private World model;
  private StringBuilder log;
  private StringBuffer out;
  private WorldCommand world;

  /**
   * sets up log,model and out fields.
   */
  @Before
  public void setUp() {
    log = new StringBuilder();
    model = new WorldMockModelHuman(log, 1234321);
    out = new StringBuffer();
  }

  /**
   * test look around for mock model.
   */
  @Test
  public void testLookAroundTestt() {
    world = new LookAround();
    world.go(model);
    StringBuilder sb = new StringBuilder();
    sb.append("playerLookAround method invoked");
    assertEquals(sb.toString(), log.toString());
    assertEquals("UniqueCode is 1234321\n", out.toString());
    // output from model received correctly
  }

}
