package world.control.commands;

import world.World;

/**
 * LookAround command to look around.
 *
 */
public class LookAround implements WorldCommand {

  /**
   * Constructor to initialize fields of LookAround class.
   * 
   */
  public LookAround() {
  }

  @Override
  public void go(World m) throws IllegalStateException, IllegalArgumentException {
    m.playerLookAround();
  }
}
