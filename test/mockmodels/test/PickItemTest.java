package mockmodels.test;

import static org.junit.Assert.assertEquals;

import mockmodels.WorldMockModelHuman;
import org.junit.Before;
import org.junit.Test;
import world.World;
import world.control.commands.PickItem;
import world.control.commands.WorldCommand;

/**
 * A test class to test PickItem command controller.
 *
 */
public class PickItemTest {

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
   * test pick item for mock model.
   */
  @Test
  public void testPickItemTest() {
    world = new PickItem("Crepe Pan");
    world.go(model);
    StringBuilder sb = new StringBuilder();
    sb.append("playerPickItems method invoked with input Crepe Pan");
    sb.append("UniqueCode is 1234321");
    assertEquals(sb.toString(), log.toString()); // output from model received correctly
  }

}
