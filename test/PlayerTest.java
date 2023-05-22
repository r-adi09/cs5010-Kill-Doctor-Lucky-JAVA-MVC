import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import world.Player;
import world.PlayerImplementation;
import world.PlayerType;

/**
 * 
 * Test class for Player interface.
 *
 */
public class PlayerTest {
  private Player player;

  /**
   * setting up a player object.
   */
  @Before
  public void setUp() {
    player = new PlayerImplementation("sahith", PlayerType.HUMAN, 2, "Kitchen");
  }

  /**
   * method of return type Player, which takes player name, player type, player
   * items limit, player room name and returns a new PlayerImplementation object.
   * 
   * @param playerName player name.
   * @param playerType player type.
   * @param itemsLimit player items limit
   * @param roomName   player room name
   * @return player object.
   */
  protected Player player(String playerName, PlayerType playerType, int itemsLimit,
      String roomName) {
    return new PlayerImplementation(playerName, playerType, itemsLimit, roomName);
  }

  /**
   * test if player room is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRoomName() {
    player("Sahith", PlayerType.HUMAN, 3, null);
  }

  /**
   * test if player items limit is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayerItemLimit() {
    player("Sahith", PlayerType.HUMAN, -3, null);
  }

  /**
   * test if player name is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayerName() {
    player(null, PlayerType.HUMAN, -3, "Kitchen");
  }

  /**
   * test if player type is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayerType() {
    player("sahith", null, -3, "Kitchen");
  }

  /**
   * test player name.
   */
  @Test
  public void testPlayerName() {
    assertEquals(player.getPlayerName(), "sahith");
  }

  /**
   * test player type.
   */
  @Test
  public void testPlayerType() {
    assertEquals(player.getPlayerType(), PlayerType.HUMAN);
  }

  /**
   * test player item limit.
   */
  @Test
  public void testPlayerItemLimit() {
    assertEquals(player.getPlayerItemsLimit(), 2);
  }

  /**
   * test player room name.
   */
  @Test
  public void testPlayerRoomName() {
    assertEquals(player.getPlayerRoomName(), "Kitchen");
  }

}
