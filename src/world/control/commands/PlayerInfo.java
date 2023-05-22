package world.control.commands;

import world.World;

/**
 * PlayerInfo command to get a player information.
 *
 */
public class PlayerInfo implements WorldCommand {

  /**
   * Constructor to initialize fields of PlayerInfo class.
   * 
   */
  public PlayerInfo() {
  }

  @Override
  public void go(World m) throws IllegalArgumentException, IllegalArgumentException {
    if (m == null) {
      throw new IllegalArgumentException("Invalid Object");
    }
    m.getPlayerDescription();
  }

}
