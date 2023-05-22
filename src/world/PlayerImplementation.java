package world;

import java.util.ArrayList;
import java.util.List;

/**
 * A PlayerImplementaion class initializing Player information like playerName,
 * playerRoomName, playerItemsLimit, playerType and playerItems.
 *
 */
public class PlayerImplementation implements Player {
  private final String playerName;
  private String playerRoomName;
  private final int playerItemsLimit;
  private final PlayerType playerType;
  private List<String> playerItems;
  private int xaxis;
  private int yaxis;

  /**
   * Initializing fields.
   * 
   * @param playerName       player name
   * @param playerType       player type
   * @param playerItemsLimit player items limit
   * @param playerRoomName   player room name
   */
  public PlayerImplementation(String playerName, PlayerType playerType, int playerItemsLimit,
      String playerRoomName) throws IllegalArgumentException {
    if (playerName == null || playerName.trim().isEmpty() || "".equals(playerName.trim())) {
      throw new IllegalArgumentException("Invalid player name");
    }
    if (playerRoomName == null || playerRoomName.trim().isEmpty()
        || "".equals(playerRoomName.trim())) {
      throw new IllegalArgumentException("Invalid room name");
    }
    if (playerItemsLimit < 0) {
      throw new IllegalArgumentException("Invalid players item limit");
    }
    if (playerType == null) {
      throw new IllegalArgumentException("Invalid player type");
    }
    this.playerName = playerName;
    this.playerType = playerType;
    this.playerItemsLimit = playerItemsLimit;
    this.playerRoomName = playerRoomName;
    this.playerItems = new ArrayList<>();
  }

  @Override
  public void setPlayerRoomName(String playerRoomName) throws IllegalArgumentException {
    if (playerRoomName == null || playerRoomName.trim().isEmpty()
        || "".equals(playerRoomName.trim())) {
      throw new IllegalArgumentException("Invalid player room name");
    }
    this.playerRoomName = playerRoomName;
  }

  @Override
  public String getPlayerName() {
    return playerName;
  }

  @Override
  public String getPlayerRoomName() {
    return playerRoomName;
  }

  @Override
  public int getPlayerItemsLimit() {
    return playerItemsLimit;
  }

  @Override
  public List<String> getPlayerItems() {
    List<String> playerItemsCopy = new ArrayList<>(playerItems);
    return playerItemsCopy;
  }

  @Override
  public PlayerType getPlayerType() {
    return playerType;
  }

  @Override
  public void pickItem(String itemName) {
    if (itemName == null || itemName.trim().isEmpty() || "".equals(itemName.trim())) {
      throw new IllegalArgumentException("Invalid item name");
    }
    playerItems.add(itemName);
  }

  @Override
  public void removeItem(String itemName) {
    if (itemName == null || itemName.trim().isEmpty() || "".equals(itemName.trim())) {
      throw new IllegalArgumentException("Invalid item name");
    }
    playerItems.remove(itemName);
  }

  @Override
  public int getpositionX() {
    return xaxis;
  }

  @Override
  public int getpositionY() {
    return yaxis;
  }

  @Override
  public void updateX(int x) {
    this.xaxis = x;
  }

  @Override
  public void updateY(int y) {
    this.yaxis = y;
  }

}
