package world;

import java.awt.image.BufferedImage;

/**
 * An model which has all the information to get necessary information for view.
 */
public interface ReadOnlyWorld {

  /**
   * Get the player information.
   * 
   * @return string player information.
   */
  String getPlayerDescription();

  /**
   * The user is provided with some limited information about where they are in
   * the world, location of target and checks if pet is in the same room at the
   * start of their turn.
   * 
   * @return information about player location, target location and pet is in
   *         current room.
   */
  String getPlayerClues();

  /**
   * gets total rooms in the world.
   * 
   * @return total rooms.
   */
  String[] getRooms();

  /**
   * Gets the target index.
   * 
   * @return indexOfRoom Room index of target.
   */
  String getPlayerNameTurn();

  /**
   * gets the total items in a room.
   * 
   * @return room items.
   */
  String[] getRoomItems();

  /**
   * gets total items of a player.
   * 
   * @return player items.
   */
  String[] getPlayerItems();

  /**
   * get the total players in the world.
   * 
   * @return players.
   */
  String getPlayers();

  /**
   * gets the updated world image to show in the game, which includes players and
   * targets.
   * 
   * @return world map image.
   */
  BufferedImage getWorldMap();
}
