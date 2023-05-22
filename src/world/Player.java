package world;

import java.util.List;

/**
 * A Player interface with name, room name, items limit, player items and player
 * type.
 */
public interface Player {
  /**
   * Gets the player name.
   * 
   * @return the player name
   */
  String getPlayerName();

  /**
   * Gets the player location in the world, i.e, in which room the player is in.
   * 
   * @return player's room name
   */
  String getPlayerRoomName();

  /**
   * Gets the items limit of a player.
   * 
   * @return player's items limit
   */
  int getPlayerItemsLimit();

  /**
   * Gets the List of player items.
   * 
   * @return player item list
   */
  List<String> getPlayerItems();

  /**
   * Gets the type of a player.
   * 
   * @return player type
   */
  PlayerType getPlayerType();

  /**
   * Setting the room name.
   * 
   * @param playerRoomName updated room name for player
   */
  void setPlayerRoomName(String playerRoomName);

  /**
   * Player Picks item.
   * 
   * @param itemName item name
   */
  void pickItem(String itemName);

  /**
   * Item is removed when player attempts to attack a target.
   * 
   * @param itemName item name.
   */
  void removeItem(String itemName);

  /**
   * Gets the location of player in x axis.
   * 
   * @return x axis.
   */
  int getpositionX();

  /**
   * Gets the location of player in y axis.
   * 
   * @return y axis.
   */
  int getpositionY();

  /**
   * Updating player location for x axis.
   * 
   * @param x axis.
   */
  void updateX(int x);

  /**
   * Updating player location for y axis.
   * 
   * @param y axis.
   */
  void updateY(int y);
}
