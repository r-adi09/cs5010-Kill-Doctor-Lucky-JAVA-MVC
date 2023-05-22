package world;

import java.util.List;

/**
 * Room with name, upper row, upper column, lower row and lower column data.
 */
public interface RoomInterface {

  /**
   * Gets the room name.
   * 
   * @return the room name
   */
  String getRoomName();

  /**
   * Gets the upper left row of the room.
   * 
   * @return upper row number
   */
  int getUpperLeftRow();

  /**
   * Gets the Lower right row of the room.
   * 
   * @return lower row number
   */
  int getLowerRightRow();

  /**
   * Gets the upper left column of the room.
   * 
   * @return upper column number
   */
  int getUpperLeftColumn();

  /**
   * Gets the lower right column of the room.
   * 
   * @return lower column number
   */
  int getLowerRightColumn();

  /**
   * Gets list of room items.
   * 
   * @return room items list
   */
  List<String> getRoomItems();

  /**
   * add item in room.
   * 
   * @param itemName item name
   */
  void addItem(String itemName);

  /**
   * remove item from room.
   * 
   * @param itemName item name
   */
  void removeItem(String itemName);
}
