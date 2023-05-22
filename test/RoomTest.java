import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import world.Room;

/**
 * Class for testing Room Class.
 */
public class RoomTest {
  private Room room;

  /**
   * setting up a room object.
   */
  @Before
  public void setUp() {
    room = new Room("Kitchen", 16, 3, 21, 10);
  }

  /**
   * method of return type Room, which takes room name, rows, columns and returns
   * a new Room object.
   * 
   * @param roomName room name.
   * @param row1     row 1.
   * @param column1  column 1.
   * @param row2     row 2.
   * @param column2  column 2.
   * @return Room object.
   */
  protected Room room(String roomName, int row1, int column1, int row2, int column2) {
    return new Room(roomName, row1, column1, row2, column2);
  }

  /**
   * test if room parameters are invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRoomParameters() {
    room("Kitchen", 10, 20, -10, 30);
  }

  /**
   * test name of the room.
   */
  @Test
  public void testRoomName() {
    assertEquals(room.getRoomName(), "Kitchen");
  }

  /**
   * test upper left row value.
   */
  @Test
  public void testRoomUpperRow() {
    assertEquals(room.getUpperLeftRow(), 16);
  }

  /**
   * test upper left column value.
   */
  @Test
  public void testRoomUpperColumn() {
    assertEquals(room.getUpperLeftColumn(), 3);
  }

  /**
   * test lower right row value.
   */
  @Test
  public void testRoomLowerRow() {
    assertEquals(room.getLowerRightRow(), 21);
  }

  /**
   * test lower right column value.
   */
  @Test
  public void testRoomLowerColumn() {
    assertEquals(room.getLowerRightColumn(), 10);
  }

  /**
   * test equals method.
   */
  @Test
  public void testRoomEquals() {
    assertTrue(room.equals(room));
    assertTrue(room.equals(room("Kitchen", 16, 3, 21, 10)));
    assertTrue((room("Kitchen", 16, 3, 21, 10)).equals(room("Kitchen", 16, 3, 21, 10)));
    assertFalse(room.equals(null));
    assertFalse(room.equals(new Object()));
  }

  /**
   * tests hash code.
   */
  @Test
  public void testRoomHashCode() {
    assertEquals(room.hashCode(), room("Kitchen", 16, 3, 21, 10).hashCode());
  }

  /**
   * test toString method.
   */
  @Test
  public void testRoomToString() {
    assertEquals(room.toString(), "Kitchen has upper corners[16,3] and lower corners[21,10]");
  }
}
