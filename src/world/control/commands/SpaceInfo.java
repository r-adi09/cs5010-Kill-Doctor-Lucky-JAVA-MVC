package world.control.commands;

import java.io.IOException;
import world.World;

/**
 * Space command to get a space information.
 *
 */
public class SpaceInfo implements WorldCommand {

  private final String roomName;
  private final Appendable out;

  /**
   * Constructor to initialize fields of WorldCommand class.
   * 
   * @param roomName room name
   * @param out      Appendable
   */
  public SpaceInfo(String roomName, Appendable out) {
    if (roomName == null || roomName.trim().isEmpty() || "".equals(roomName.trim())) {
      throw new IllegalArgumentException("Invalid room name");
    }
    if (out == null) {
      throw new IllegalArgumentException("Invalid Appendable Parameter");
    }
    this.roomName = roomName;
    this.out = out;
  }

  @Override
  public void go(World m) throws IllegalArgumentException, IllegalArgumentException {
    if (m == null) {
      throw new IllegalArgumentException("Invalid Object");
    }

    try {
      out.append(m.getSpaceInformation(roomName) + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Append failed", e);
    }

  }

}
