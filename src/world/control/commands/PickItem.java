package world.control.commands;

import world.World;

/**
 * PickItem command to pick an item in a room.
 *
 */
public class PickItem implements WorldCommand {

  private final String itemName;

  /**
   * Constructor to initialize fields of PickItem class.
   * 
   * @param itemName item name.
   */
  public PickItem(String itemName) {
    if (itemName == null) {
      throw new IllegalArgumentException("Invalid item Parameter");
    }
    this.itemName = itemName;
  }

  @Override
  public void go(World m) throws IllegalStateException, IllegalArgumentException {
    if (m == null) {
      throw new IllegalArgumentException("Invalid Object");
    }
    m.playerPickItems(itemName);
  }
}
