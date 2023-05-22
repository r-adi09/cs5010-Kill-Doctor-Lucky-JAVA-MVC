package world.control.commands;

import world.World;

/**
 * MovePet command to move pet to a room.
 *
 */
public class MovePet implements WorldCommand {

  private final String roomName;

  /**
   * Constructor to initialize fields of MovePet class.
   * 
   * @param roomName room name.
   */
  public MovePet(String roomName) {
    if (roomName == null) {
      throw new IllegalArgumentException("Invalid Appendable Parameter");
    }
    this.roomName = roomName;
  }

  @Override
  public void go(World m) throws IllegalStateException, IllegalArgumentException {
    if (m == null) {
      throw new IllegalArgumentException("Invalid Object");
    }
    m.movePet(roomName);
  }
}
