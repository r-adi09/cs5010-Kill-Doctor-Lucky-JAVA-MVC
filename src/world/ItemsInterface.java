package world;

/**
 * ItemsInterface with index of item, damage power of item and item's name.
 */
public interface ItemsInterface {

  /**
   * Gets the index of the room in which item is present in the world.
   * 
   * @return room index.
   */
  int getRoomIndex();

  /**
   * Gets the damage power of the item.
   * 
   * @return damage power.
   */
  int getDamageHealth();

  /**
   * Gets the item name.
   * 
   * @return item name.
   */
  String getItemName();
}
