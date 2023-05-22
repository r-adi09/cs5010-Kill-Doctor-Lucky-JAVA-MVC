package world;

import java.util.Objects;

/**
 * Item class to initialize roomIndex of item, item damage power and item name.
 */
public class Items implements ItemsInterface {
  private final int roomIndex;
  private final int damageHealth;
  private final String itemName;

  /**
   * This method is providing short-hand way of creating instances of a new Item
   * object.
   * 
   * @param roomIndex    initial index of the room
   * @param damageHealth initial damage power of wepon
   * @param itemName     initial item name
   */
  public Items(int roomIndex, int damageHealth, String itemName) throws IllegalArgumentException {
    if (itemName == null || itemName.trim().isEmpty() || "".equals(itemName.trim())) {
      throw new IllegalArgumentException("Invalid item Name");
    }
    if (damageHealth < 0 || roomIndex < 0) {
      throw new IllegalArgumentException("Invalid Item parameters");
    }
    if (roomIndex < 0) {
      throw new IllegalArgumentException("Invalid room index");
    }
    this.roomIndex = roomIndex;
    this.damageHealth = damageHealth;
    this.itemName = itemName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(damageHealth, itemName, roomIndex);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Items)) {
      return false;
    }
    Items other = (Items) obj;
    return damageHealth == other.damageHealth && Objects.equals(itemName, other.itemName)
        && roomIndex == other.roomIndex;
  }

  @Override
  public int getRoomIndex() {
    return roomIndex;
  }

  @Override
  public int getDamageHealth() {
    return damageHealth;
  }

  @Override
  public String getItemName() {
    return itemName;
  }

  @Override
  public String toString() {
    return String.format("Item %s is in room index %d and has damage power %d", this.getItemName(),
        this.getRoomIndex(), this.getDamageHealth());
  }

}
