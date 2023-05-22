package world;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A Room class initializing room information like upper row, upper column,
 * lower row, lower column and room name.
 *
 */
public class Room implements RoomInterface {

  private final String roomName;
  private final int upperLeftRow;
  private final int upperLeftColumn;
  private final int lowerRightRow;
  private final int lowerRightColumn;
  private List<String> roomItems;

  /**
   * This method is providing short-hand way of creating instances of a new Room
   * object.
   * 
   * @param roomName         the initial room name
   * @param upperLeftRow     the initial upper row
   * @param upperLeftColumn  the initial upper column
   * @param lowerRightRow    the initial lower row
   * @param lowerRightColumn the initial lower column
   * @throws IllegalArgumentException illegal argument for invalid rows and
   *                                  columns
   */
  public Room(String roomName, int upperLeftRow, int upperLeftColumn, int lowerRightRow,
      int lowerRightColumn) throws IllegalArgumentException {
    if (roomName == null || roomName.trim().isEmpty() || "".equals(roomName.trim())) {
      throw new IllegalArgumentException("Invalid Room Name");
    }
    if (upperLeftRow < 0 || lowerRightRow < 0 || upperLeftColumn < 0 || lowerRightColumn < 0
        || upperLeftRow > lowerRightRow || upperLeftColumn > lowerRightColumn) {
      throw new IllegalArgumentException("Invalid room parameters");
    }
    this.roomName = roomName;
    this.upperLeftRow = upperLeftRow;
    this.lowerRightRow = lowerRightRow;
    this.upperLeftColumn = upperLeftColumn;
    this.lowerRightColumn = lowerRightColumn;
    this.roomItems = new ArrayList<>();
  }

  @Override
  public String getRoomName() {
    return roomName;
  }

  @Override
  public int getUpperLeftRow() {
    return upperLeftRow;
  }

  @Override
  public int getLowerRightRow() {
    return lowerRightRow;
  }

  @Override
  public int getUpperLeftColumn() {
    return upperLeftColumn;
  }

  @Override
  public int getLowerRightColumn() {
    return lowerRightColumn;
  }

  @Override
  public List<String> getRoomItems() {
    List<String> roomItemsCopy = new ArrayList<>(roomItems);
    return roomItemsCopy;
  }

  @Override
  public void addItem(String itemName) {
    if (itemName == null) {
      throw new IllegalArgumentException("item cannot be null");
    }
    roomItems.add(itemName);
  }

  @Override
  public void removeItem(String itemName) {
    if (itemName == null) {
      throw new IllegalArgumentException("item cannot be null");
    }
    roomItems.remove(itemName);
  }

  @Override
  public String toString() {
    return String.format("%s has upper corners[%d,%d] and lower corners[%d,%d]", this.getRoomName(),
        this.getUpperLeftRow(), this.getUpperLeftColumn(), this.getLowerRightRow(),
        this.getLowerRightColumn());
  }

  @Override
  public int hashCode() {
    return Objects.hash(upperLeftColumn, lowerRightColumn, roomName, upperLeftRow, lowerRightRow);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Room)) {
      return false;
    }
    Room other = (Room) obj;
    return upperLeftColumn == other.upperLeftColumn && lowerRightColumn == other.lowerRightColumn
        && Objects.equals(roomName, other.roomName) && upperLeftRow == other.upperLeftRow
        && lowerRightRow == other.lowerRightRow;
  }
}
