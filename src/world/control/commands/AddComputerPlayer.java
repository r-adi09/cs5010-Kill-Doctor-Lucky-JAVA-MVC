package world.control.commands;

import world.World;

/**
 * AddComputer command to add a computer player.
 *
 */
public class AddComputerPlayer implements WorldCommand {
  /**
   * Initializing constructor for addcomputer fields.
   * 
   */
  public AddComputerPlayer() {

  }

  @Override
  public void go(World m) throws IllegalArgumentException {
    if (m == null) {
      throw new IllegalArgumentException("Invalid Object");
    }
    m.addComputerPlayer();
  }

}