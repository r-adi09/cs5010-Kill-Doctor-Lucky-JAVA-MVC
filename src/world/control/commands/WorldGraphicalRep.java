package world.control.commands;

import java.io.IOException;
import world.World;

/**
 * MovePlayer command to print graphical image of world.
 *
 */
public class WorldGraphicalRep implements WorldCommand {

  private final Appendable out;

  /**
   * Constructor to initialize WorldGraphicalRep class fields.
   * 
   * @param out appendable
   */
  public WorldGraphicalRep(Appendable out) {
    if (out == null) {
      throw new IllegalArgumentException("Invalid Appendable Parameter");
    }
    this.out = out;
  }

  @Override
  public void go(World m) throws IllegalArgumentException {
    if (m == null) {
      throw new IllegalArgumentException("Invalid Object");
    }
    m.createWorldGraphicalRep();
    try {
      out.append("Image in created in res folder" + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Append failed", e);
    }
  }

}
