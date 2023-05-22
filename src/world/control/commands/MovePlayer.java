package world.control.commands;

import world.World;

/**
 * MovePlayer command to move a player to a neighbor room.
 *
 */
public class MovePlayer implements WorldCommand {

  private final int ipos;
  private final int jpos;

  /**
   * Constructor to initialize fields of MovePlayer class.
   * 
   * @param ipos x position.
   * @param jpos y position.
   */
  public MovePlayer(int ipos, int jpos) {
    this.ipos = ipos;
    this.jpos = jpos;
  }

  @Override
  public void go(World m) throws IllegalStateException, IllegalArgumentException {
    if (m == null) {
      throw new IllegalArgumentException("Invalid Object");
    }
    try {
      m.movePlayer(ipos, jpos);
    } catch (IllegalStateException e) {
      throw new IllegalStateException("Cannot move player");
    } catch (IllegalArgumentException e) {
      throw new IllegalStateException("Cannot move player");
    }
  }
}
