package world.control;

/**
 * Features interface used by view to connect to the controller.
 */
public interface Features {
  /**
   * This method is used to add human player to the game. It takes the following
   * input parameters.
   * 
   * @param playerName       string player name.
   * @param playerRoomName   string room name.
   * @param playerItemsLimit string playersLimit.
   */
  void addHumanPlayer(String playerName, String playerRoomName, String playerItemsLimit);

  /**
   * This method is used to add computer player to the game.
   */
  void addComputerPlayer();

  /**
   * This method is used to start the game.
   */
  void startGame();

  /**
   * This method is used to add players to the game.
   */
  void addPlayers();

  /**
   * This method is used to enable look around for a player.
   */
  void lookAround();

  /**
   * This method is used to enable player to pick an item from the world.
   * 
   * @param itemName string item name as input parameter.
   */
  void pickItem(String itemName);

  /**
   * This method is used to enable attack target.
   * 
   * @param itemName string item name as input parameter.
   */
  void attackTarget(String itemName);

  /**
   * This method is used to enable move pet method.
   * 
   * @param roomName input room name
   */
  void movePet(String roomName);

  /**
   * This method returns the items carried by a player.
   */
  void playerItems();

  /**
   * This method is used to enable quit game functionality.
   */
  void quitGame();

  /**
   * This method is used to enable move player. It takes in player coordinates as
   * input parameters.
   * 
   * @param i x coordinate.
   * @param j y coordinate.
   */
  void movePlayer(int i, int j);

  /**
   * This method is used to enable the start new game from beginning
   * functionality.
   * 
   * @throws IllegalArgumentException if the model or view obejct is null.
   */
  void startNewGame() throws IllegalArgumentException;

  /**
   * This method is used to start game with new world specification.
   * 
   * @param map newly added file path.
   */
  void startNewMapGame(String map);
}