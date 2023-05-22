package mockmodels.test;

import static org.junit.Assert.assertEquals;

import mockmodels.WorldMockModelHuman;
import org.junit.Before;
import org.junit.Test;
import world.World;
import world.control.commands.WorldCommand;
import world.control.commands.WorldGraphicalRep;

/**
 * A test class to test WorldGraphicalRep command controller.
 *
 */
public class WorldGraphicalRepTest {

  private World model;
  private StringBuilder log;
  private StringBuffer out;
  private WorldCommand world;

  /**
   * sets up log, model and out fields.
   */
  @Before
  public void setUp() {
    log = new StringBuilder();
    model = new WorldMockModelHuman(log, 1234321);
    out = new StringBuffer();
  }

  /**
   * test if graphical mage is created.
   */
  @Test
  public void testGetGraphicalRep() {
    world = new WorldGraphicalRep(out);
    world.go(model);
    StringBuilder sb = new StringBuilder();
    sb.append("Create world graphical representation method invoked" + "\n");
    sb.append("UniqueCode is 1234321");
    assertEquals(sb.toString(), log.toString()); // output from model received correctly
  }

}
