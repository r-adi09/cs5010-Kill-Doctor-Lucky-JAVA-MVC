import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import world.Target;

/**
 * Class for testing Target Class.
 */
public class TargetTest {
  private Target target;

  /**
   * setting up a target object.
   */
  @Before
  public void setUp() {
    target = new Target(50, "Doctor Lucky", "Armory");
  }

  /**
   * method of return type Target, which takes target health, target health,
   * target room name and returns a new target object.
   * 
   * @param targetHealth target health.
   * @param targetName   target name.
   * @param roomName     target room name.
   * @return target object.
   */
  protected Target target(int targetHealth, String targetName, String roomName) {
    return new Target(targetHealth, targetName, roomName);
  }

  /**
   * test target health.
   */
  @Test
  public void testTargetHealth() {
    assertEquals(target.getTargetHealth(), 50);
  }

  /**
   * test target name.
   */
  @Test
  public void testTargetName() {
    assertEquals(target.getTargetName(), "Doctor Lucky");
  }

  /**
   * test to string method.
   */
  @Test
  public void testTargetToString() {
    assertEquals(target.toString(), "Target Doctor Lucky has health 50");
  }
}
