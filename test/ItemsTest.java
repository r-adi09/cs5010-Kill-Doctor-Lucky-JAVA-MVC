import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import world.Items;

/**
 * Class for testing Items Class.
 */
public class ItemsTest {
  private Items item;

  /**
   * setting up a items object.
   */
  @Before
  public void setUp() {
    item = new Items(6, 2, "Trowel");
  }

  /**
   * method of return type Items, which takes room index, damage health, item name
   * and returns a new Items object.
   * 
   * @param roomIndexbroom index.
   * @param damageHealth   item damage power
   * @param itemName       item name.
   * @return items object
   */
  protected Items item(int roomIndex, int damageHealth, String itemName) {
    return new Items(roomIndex, damageHealth, itemName);
  }

  /**
   * tests the items damage power.
   */
  @Test
  public void testItemDamagePower() {
    assertEquals(item.getDamageHealth(), 2);
  }

  /**
   * tests the item name.
   */
  @Test
  public void testItemName() {
    assertEquals(item.getItemName(), "Trowel");
  }

  /**
   * test if item damage power is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDamagePower() {
    item(6, -12, "Trowel");
  }

  /**
   * tests equals method.
   */
  @Test
  public void testItemEquals() {
    assertTrue(item.equals(item));
    assertTrue(item.equals(item(6, 2, "Trowel")));
    assertTrue((item(6, 2, "Trowel")).equals(item(6, 2, "Trowel")));
    assertFalse(item.equals(null));
    assertFalse(item.equals(new Object()));
  }

  /**
   * test hash code.
   */
  @Test
  public void testItemHashCode() {
    assertEquals(item.hashCode(), item(6, 2, "Trowel").hashCode());
  }

  /**
   * test toString for items.
   */
  @Test
  public void testItemToString() {
    assertEquals(item.toString(), "Item Trowel is in room index 6 and has damage power 2");
  }
}
