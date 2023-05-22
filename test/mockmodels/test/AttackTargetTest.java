package mockmodels.test;

import static org.junit.Assert.assertEquals;

import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;
import mockmodels.WorldMockModelAttackWithoutWepon;
import mockmodels.WorldMockModelHuman;
import org.junit.Before;
import org.junit.Test;
import world.World;
import world.control.commands.AttackTarget;
import world.control.commands.WorldCommand;

/**
 * A test class to test MovePet command controller.
 *
 */
public class AttackTargetTest {

  private World model;
  private World modelWithoutWepon;
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
    modelWithoutWepon = new WorldMockModelAttackWithoutWepon(log, 1234321);
    out = new StringBuffer();
  }

  /**
   * test attack target with item for mock model.
   */
  @Test
  public void testAttackTarget() {
    Reader in = new StringReader("Crepe Pan");
    Scanner sc = new Scanner(in);
    world = new AttackTarget(sc, out);
    world.go(model);
    StringBuilder sb = new StringBuilder();
    sb.append("checkIfPlayerHasItems method invoked\n"
        + "attackTarget method invoked with input Crepe Pan");
    assertEquals(sb.toString(), log.toString()); // output from model received correctly
  }

  /**
   * test attack target without item for mock model.
   */
  @Test
  public void testAttackTargetWithoutItem() {
    Reader in = new StringReader("Crepe Pan");
    Scanner sc = new Scanner(in);
    world = new AttackTarget(sc, out);
    world.go(modelWithoutWepon);
    StringBuilder sb = new StringBuilder();
    sb.append(
        "checkIfPlayerHasItems method invoked\n" + "attackTargetWithoutItems method invoked\n");
    assertEquals(sb.toString(), log.toString()); // output from model received correctly
  }

}