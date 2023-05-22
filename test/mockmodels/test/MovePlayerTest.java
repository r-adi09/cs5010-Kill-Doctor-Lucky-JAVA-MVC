package mockmodels.test;

import static org.junit.Assert.assertEquals;

import mockmodels.WorldMockModelHuman;
import org.junit.Before;
import org.junit.Test;
import world.World;
import world.control.commands.MovePlayer;
import world.control.commands.WorldCommand;

/**
 * A test class to test MovePlayer command controller.
 *
 */
public class MovePlayerTest {

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
   * test move player for mock model.
   */
  @Test
  public void testMovePlayer() {
    world = new MovePlayer(20, 19);
    world.go(model);
    StringBuilder sb = new StringBuilder();
    sb.append("movePlayer method invoked with input Kitchen");
    sb.append("UniqueCode is 1234321");
    assertEquals(sb.toString(), log.toString()); // output from model received correctly
  }

}
