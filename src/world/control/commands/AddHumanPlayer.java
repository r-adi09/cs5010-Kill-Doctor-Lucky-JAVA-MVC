package world.control.commands;

import world.World;

/**
 * AddHumanPlayer command to add a Human player.
 *
 */
public class AddHumanPlayer implements WorldCommand {
  private final String playerName;
  private final int playerItemsLimit;
  private final String playerRoomName;

  /**
   * Adds a human player in the game.
   * 
   * @param playerName       player name
   * @param playerItemsLimit items limit
   * @param playerRoomName   room name
   */
  public AddHumanPlayer(String playerName, String playerRoomName, int playerItemsLimit) {
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
    this.playerName = playerName;
    this.playerItemsLimit = playerItemsLimit;
    this.playerRoomName = playerRoomName;
  }

  @Override
  public void go(World m) throws IllegalArgumentException {
    if (m == null) {
      throw new IllegalArgumentException("Invalid Object");
    }
    try {
      m.addHumanPlayer(playerName, playerItemsLimit, playerRoomName);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid player parameters");
    }
  }

}
