package world;

/**
 * World of Doctor lucky's mansion with rooms, items and target moving around
 * the room.
 */
public interface World extends ReadOnlyWorld {

  /**
   * Gets the complete information of a space.
   * 
   * @param roomName name of the room.
   * @return list of items in a room and its neighbors
   * @throws IllegalArgumentException if room is not found
   */
  String getSpaceInformation(String roomName) throws IllegalArgumentException;

  /**
   * Generates an image of world map.
   */
  void createWorldGraphicalRep();

  /**
   * Adding Human player to the world.
   * 
   * @param playerName       player name.
   * @param playerItemsLimit player item limit.
   * @param playerRoomName   player room name.
   */
  void addHumanPlayer(String playerName, int playerItemsLimit, String playerRoomName);

  /**
   * Adding computer player to the world.
   */
  void addComputerPlayer();

  /**
   * Move Player to another room.
   * 
   * @param x position x;
   * @param y position y;
   */
  void movePlayer(int x, int y);

  /**
   * Picks an item from the room.
   * 
   * @param itemName item name.
   */
  void playerPickItems(String itemName);

  /**
   * The current player look around the space that they are currently in.Player
   * would know where they were (the name of the space), who was in the room with
   * the player (the other players), what items were laying around the space, as
   * well as information about other spaces that you could see from there.Player
   * would be able to see into neighboring spaces to be able to identify what
   * space it was as well as what players and items were in the neighboring space.
   * 
   * 
   * @return neighbors.
   */
  String playerLookAround();

  /**
   * Checking if player is computer.
   * 
   * @return boolean.
   */
  boolean checkComputerPlayer();

  /**
   * Computer Plays the game.
   * 
   * @return computer play.
   */
  String playComputerPlayer();

  /**
   * Move Pet to another room.
   * 
   * @param roomName room name.
   */
  void movePet(String roomName);

  /**
   * Attacking the target. If an attack is seen by another player (human or
   * computer), it is automatically stopped and no damage is done. Unseen attacks
   * are always successful in which case the appropriate number of hit points
   * (determined by the item used in the attempt) is removed from the target
   * character.
   * 
   * @param itemName item name
   * @return attack information, if it is successfull or not.
   */
  String attackTarget(String itemName);

  /**
   * Checks if the current player is having any items. To attack a target player
   * chooses an item if he at least one item with him, else he pokes the target.
   * 
   * @return true if player has atleast one item.
   */
  Boolean checkIfPlayerHasItems();

  /**
   * Attacks target by poking him in the eye, as the player does not have any
   * items.
   * 
   * @return string with information after attacking target.
   */
  String attackTargetWithoutItems();

  /**
   * game ends when: A player successfully kills the target character in which
   * case they win the game. The maximum number of turns is reached in which case
   * the target character escapes and runs away to live another day and nobody
   * wins.
   * 
   * @return false is game is not over or true if game is over.
   */
  Boolean isGameOver();

  /**
   * gets the winner if target is dead or no winner if target is alive and turns
   * are over.
   * 
   * @return player name if he kills the target.
   */
  String getWinner();

  /**
   * Starts a new game.
   */
  void startNewGame();

  /**
   * checks if the action calls is used to get player description.
   * 
   * @param y location in y axis.
   * @param x location in x axis.
   * @return true if location clicked is players location.
   * @throws IllegalArgumentException if invalid location.
   */
  boolean checkPlayerInfo(int y, int x) throws IllegalArgumentException;
}
