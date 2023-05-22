import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import org.junit.Before;
import org.junit.Test;
import world.ConcreteWorld;
import world.RandomImplementaion;
import world.World;

/**
 * Class for testing World Class.
 */
public class ConcreteWorldTest {

  private World world;
  private File exampleRunFile;
  private StringBuilder out;

  /**
   * Setting up file value and world object before calling test class.
   */
  @Before
  public void setUp() {
    exampleRunFile = new File("res/ExampleRun.txt");
    out = new StringBuilder();
    out.append("36 30 Doctor Lucky's Mansion\n");
    out.append("4 Doctor Lucky\n");
    out.append("Fortune the Cat\n");
    out.append("21\n");
    out.append("22 19 23 26 Armory\n");
    out.append("16 21 21 28 Billiard Room\n");
    out.append("28  0 35  5 Carriage House\n");
    out.append("12 11 21 20 Dining Hall\n");
    out.append("22 13 25 18 Drawing Room\n");
    out.append("26 13 27 18 Foyer\n");
    out.append("28 26 35 29 Green House\n");
    out.append("30 20 35 25 Hedge Maze\n");
    out.append("16  3 21 10 Kitchen\n");
    out.append(" 0  3  5  8 Lancaster Room\n");
    out.append(" 4 23  9 28 Library\n");
    out.append(" 2  9  7 14 Lilac Room\n");
    out.append(" 2 15  7 22 Master Suite\n");
    out.append(" 0 23  3 28 Nursery\n");
    out.append("10  5 15 10 Parlor\n");
    out.append("28 12 35 19 Piazza\n");
    out.append(" 6  3  9  8 Servants' Quarters\n");
    out.append(" 8 11 11 20 Tennessee Room\n");
    out.append("10 21 15 26 Trophy Room\n");
    out.append("22  5 23 12 Wine Cellar\n");
    out.append("30  6 35 11 Winter Garden\n");
    out.append("20\n");
    out.append("8 3 Crepe Pan\n");
    out.append("4 2 Letter Opener\n");
    out.append("12 2 Shoe Horn\n");
    out.append("8 3 Sharp Knife\n");
    out.append("0 3 Revolver\n");
    out.append("15 3 Civil War Cannon\n");
    out.append("2 4 Chain Saw\n");
    out.append("16 2 Broom Stick\n");
    out.append("1 2 Billiard Cue\n");
    out.append("19 2 Rat Poison\n");
    out.append("6 2 Trowel\n");
    out.append("2 4 Big Red Hammer\n");
    out.append("6 2 Pinking Shears\n");
    out.append("18 3 Duck Decoy\n");
    out.append("13 2 Bad Cream\n");
    out.append("18 2 Monkey Hand\n");
    out.append("11 2 Tight Hat\n");
    out.append("19 2 Piece of Rope\n");
    out.append("9 3 Silken Cord\n");
    out.append("7 2 Loud Noise");
    Reader input = new StringReader(out.toString());
    world = new ConcreteWorld(input, new RandomImplementaion(), 5);
  }

  /**
   * test if we are creating an image for world.
   */
  @Test
  public void testGenerateGraphicalRepresesntaion() {
    assertTrue(new File("res", "image.png").exists());
  }

  /**
   * Checks if the example run file contains data.
   */
  @Test
  public void testExampleRunFile() {
    assertTrue(exampleRunFile.length() != 0);
  }

  /**
   * test if room name is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSpaceInfo() {
    world.getSpaceInformation(null);
  }

  /**
   * test the space information.
   */
  @Test
  public void testSpaceInfoWithNoPlayer() {
    assertEquals("Room Kitchen in  Doctor Lucky's Mansion has items :"
        + " [Crepe Pan, Sharp Knife], its neighbours are :"
        + " [Dining Hall, Parlor, Wine Cellar], it has players []"
        + " and Pet is not in room Kitchen", world.getSpaceInformation("Kitchen"));
  }

  /**
   * test if room name is invalid in space.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSpaceInfoWithNullPlayer() {
    world.getSpaceInformation(null);
  }

  /**
   * test space info for one player.
   */
  @Test
  public void testSpaceInfoWithOnePlayer() {
    assertEquals("Room Kitchen in  Doctor Lucky's Mansion has items :"
        + " [Crepe Pan, Sharp Knife], its neighbours are :"
        + " [Dining Hall, Parlor, Wine Cellar], it has players []"
        + " and Pet is not in room Kitchen", world.getSpaceInformation("Kitchen"));
    world.addHumanPlayer("sahith", 3, "Kitchen");
    assertEquals("Room Kitchen in  Doctor Lucky's Mansion has items :"
        + " [Crepe Pan, Sharp Knife], its neighbours are :"
        + " [Dining Hall, Parlor, Wine Cellar], it has players [sahith]"
        + " and Pet is not in room Kitchen", world.getSpaceInformation("Kitchen"));
  }

  /**
   * test space info for multiple player.
   */
  @Test
  public void testSpaceInfoMultiplePlayer() {
    assertEquals("Room Kitchen in  Doctor Lucky's Mansion has items : "
        + "[Crepe Pan, Sharp Knife], its neighbours are :"
        + " [Dining Hall, Parlor, Wine Cellar], it has players"
        + " [] and Pet is not in room Kitchen", world.getSpaceInformation("Kitchen"));
    world.addHumanPlayer("sahith", 3, "Kitchen");
    assertEquals("Room Kitchen in  Doctor Lucky's Mansion has items : "
        + "[Crepe Pan, Sharp Knife], its neighbours are :"
        + " [Dining Hall, Parlor, Wine Cellar], it has players"
        + " [sahith] and Pet is not in room Kitchen", world.getSpaceInformation("Kitchen"));
    world.addHumanPlayer("venky", 5, "Kitchen");
    assertEquals(
        "Room Kitchen in  Doctor Lucky's Mansion has items : "
            + "[Crepe Pan, Sharp Knife], its neighbours are :"
            + " [Dining Hall, Parlor, Wine Cellar], it has players"
            + " [sahith, venky] and Pet is not in room Kitchen",
        world.getSpaceInformation("Kitchen"));
  }

  /**
   * test invalid player items limit.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayerLimitAdded() {
    world.addHumanPlayer("sahith", -3, "Kitchen");
  }

  /**
   * test invalid player room name.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayerRoomNameAdded() {
    world.addHumanPlayer("sahith", 3, "asd");
  }

  /**
   * test if human player is added.
   */
  @Test
  public void testSinglePlayerAdded() {
    world.addHumanPlayer("sahith", 3, "Kitchen");
  }

  /**
   * test if computer player is added.
   */
  @Test
  public void testSingleComputerPlayerAdded() {
    world.addComputerPlayer();
  }

  /**
   * test if multiple players are added.
   */
  @Test
  public void testMultiplePlayerAdded() {
    world.addHumanPlayer("sahith", 3, "Kitchen");
    world.addHumanPlayer("Venky", 5, "Parlor");
    world.addComputerPlayer();
    world.addHumanPlayer("Naveen", 5, "Parlor");
  }

  /**
   * test invalid duplicate players added.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDuplicatePlayerAdded() {
    world.addHumanPlayer("sahith", 5, "Parlor");
    world.addHumanPlayer("sahith", 5, "Parlor");
  }

  /**
   * test if player picks items.
   */
  @Test
  public void testPlayerPickItem() {
    world.addHumanPlayer("sahith", 5, "Kitchen");
    assertEquals("Room Kitchen in  Doctor Lucky's Mansion has items :"
        + " [Crepe Pan, Sharp Knife], its neighbours are :"
        + " [Dining Hall, Parlor, Wine Cellar], it has players"
        + " [sahith] and Pet is not in room Kitchen", world.getSpaceInformation("Kitchen"));
    world.playerPickItems("Crepe Pan");
    assertEquals(
        "Room Kitchen in  Doctor Lucky's Mansion has items :"
            + " [Sharp Knife], its neighbours are : [Dining Hall,"
            + " Parlor, Wine Cellar], it has players [sahith] and" + " Pet is not in room Kitchen",
        world.getSpaceInformation("Kitchen"));
    assertEquals("player sahith is in room Kitchen and carrying items [Crepe Pan]",
        world.getPlayerDescription());
  }

  /**
   * test if player picks item not in the room.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPlayerPickItemNotInRoom() {
    world.addHumanPlayer("sahith", 5, "Kitchen");
    world.playerPickItems("Trowel");
  }

  /**
   * test if player picks invalid item.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPlayerPickInvalidItem() {
    world.addHumanPlayer("sahith", 5, "Kitchen");
    world.playerPickItems("asd");
  }

  /**
   * test if player picks no item.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPlayerPickNullItem() {
    world.addHumanPlayer("sahith", 5, "Kitchen");
    world.playerPickItems(null);
  }

  /**
   * test if player picks item if it crosses players item limit.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPlayerPickItemBeyondLimit() {
    world.addHumanPlayer("sahith", 1, "Kitchen");
    world.playerPickItems("Crepe Pan");
    world.playerPickItems("Sharpe Knife");
  }

  /**
   * test if player picks item in empty room.
   */
  @Test(expected = IllegalStateException.class)
  public void testPlayerPickItemInEmptyRoom() {
    world.addHumanPlayer("sahith", 1, "Parlor");
    world.playerPickItems("Crepe Pan");
  }

  /**
   * test if player looks around.
   */
  @Test
  public void testPlayerLookAround() {
    world.addHumanPlayer("sahith", 1, "Parlor");
    assertEquals("Player sahith is in room Parlor, has items [] and other"
        + " players in room []. Player's neighbor space information"
        + " [Room Dining Hall has items [] and it has players [],"
        + " Room Kitchen has items [Crepe Pan, Sharp Knife] and it"
        + " has players [], Room Servants' Quarters has items [Broom Stick]"
        + " and it has players [], Room Tennessee Room has items [] and " + "it has players []]",
        world.playerLookAround());
  }

  /**
   * test player info.
   */
  @Test
  public void testPlayerInfo() {
    world.addHumanPlayer("sahith", 1, "Parlor");
    assertEquals("player sahith is in room Parlor and carrying items []",
        world.getPlayerDescription());
  }

  /**
   * test look around without adding any players to world.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testLookAroundWithoutPlayer() {
    assertEquals(
        "Player sahith is in room Parlor and has neighbors"
            + " [Dining Hall, Kitchen, Servants' Quarters, Tennessee Room]",
        world.playerLookAround());
  }

  /**
   * test player pick items without adding any players to world.
   */
  @Test(expected = IllegalStateException.class)
  public void testPickItemWithoutPlayer() {
    world.playerPickItems("Crepe Pan");
  }

  /**
   * test computer player.
   */
  @Test
  public void testComputerPlayer() {
    world.addComputerPlayer();
    assertTrue(world.checkComputerPlayer());
  }

  /**
   * test human player.
   */
  @Test
  public void testHumanPlayer() {
    world.addHumanPlayer("sahith", 1, "Parlor");
    assertFalse(world.checkComputerPlayer());
  }

  /**
   * test if player turn is updating for look around.
   */

  @Test
  public void testPlayerTurnForLookAround() {
    world.addHumanPlayer("sahith", 1, "Parlor");
    world.addHumanPlayer("Venky", 2, "Kitchen");
    world.addHumanPlayer("Naveen", 3, "Dining Hall");
    assertEquals("sahith", world.getPlayerNameTurn());
    world.playerLookAround();
    assertEquals("Venky", world.getPlayerNameTurn());
    world.playerLookAround();
    assertEquals("Naveen", world.getPlayerNameTurn());
    world.playerLookAround();
    assertEquals("sahith", world.getPlayerNameTurn());
  }

  /**
   * test if player turn is updating for item pick.
   */
  @Test
  public void testPlayerTurnForItemPick() {
    world.addHumanPlayer("sahith", 1, "Kitchen");
    world.addHumanPlayer("Venky", 2, "Parlor");
    assertEquals("sahith", world.getPlayerNameTurn());
    world.playerPickItems("Crepe Pan");
    assertEquals("Venky", world.getPlayerNameTurn());
  }

  /**
   * test the location of the target.
   */
  @Test
  public void testTargetLocation() {
    world.addHumanPlayer("sahith", 1, "Kitchen");
    world.addHumanPlayer("Venky", 2, "Parlor");
    assertEquals("player sahith is in room Kitchen and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerLookAround();
    assertEquals("player Venky is in room Parlor and carrying [].\n"
        + "Target is in room Billiard Room and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
  }

  /**
   * test look around the space when another player is in same room.
   */
  @Test
  public void testLookAroundWithOnePlayerInCurrentRoom() {
    world.addHumanPlayer("sahith", 1, "Kitchen");
    world.addHumanPlayer("Venky", 2, "Kitchen");
    assertEquals("Player sahith is in room Kitchen, has items "
        + "[Crepe Pan, Sharp Knife] and other players in room [Venky]. "
        + "Player's neighbor space information [Room Dining Hall has items "
        + "[] and it has players [], Room Parlor has items [] and it has players "
        + "[], Room Wine Cellar has items [Rat Poison, Piece of Rope] " + "and it has players []]",
        world.playerLookAround());
  }

  /**
   * test look around the space when no player is in same room.
   */
  @Test
  public void testLookAroundWithNoPlayerInCurrentRoom() {
    world.addHumanPlayer("sahith", 1, "Kitchen");
    world.addHumanPlayer("Venky", 2, "Armory");
    assertEquals(
        "Player sahith is in room Kitchen,\r\n" + "Room has items [Crepe Pan, Sharp Knife]\r\n"
            + "and other players in room [].\r\n"
            + "Player's neighbor space information [Room Dining Hall has items []"
            + " and it has players [], Room Parlor has items [] and it has players [],"
            + " Room Wine Cellar has items [Rat Poison, Piece of Rope] and it has players []]",
        world.playerLookAround());
  }

  /**
   * test look around the space when more than one player is in same room.
   */
  @Test
  public void testLookAroundWithMorePlayerInCurrentRoom() {
    world.addHumanPlayer("sahith", 1, "Kitchen");
    world.addHumanPlayer("Venky", 2, "Kitchen");
    world.addHumanPlayer("Naveen", 2, "Kitchen");
    assertEquals(
        "Player sahith is in room Kitchen, has items [Crepe Pan, Sharp Knife]"
            + " and other players in room [Venky, Naveen]. Player's neighbor space"
            + " information [Room Dining Hall has items [] and it has players [],"
            + " Room Parlor has items [] and it has players [], Room Wine Cellar"
            + " has items [Rat Poison, Piece of Rope] and it has players []]",
        world.playerLookAround());
  }

  /**
   * test look around the space when no items is in current room.
   */
  @Test
  public void testLookAroundWithNoItemInCurrentRoom() {
    world.addHumanPlayer("sahith", 1, "Parlor");
    assertEquals("Player sahith is in room Parlor, has items [] and other players in "
        + "room []. Player's neighbor space information [Room Dining Hall has "
        + "items [] and it has players [], Room Kitchen has items [Crepe Pan,"
        + " Sharp Knife] and it has players [], Room Servants' Quarters has items"
        + " [Broom Stick] and it has players [], Room Tennessee Room has items []"
        + " and it has players []]", world.playerLookAround());
  }

  /**
   * test look around the space when one item is in current room.
   */
  @Test
  public void testLookAroundOneItemInCurrentRoom() {
    world.addHumanPlayer("sahith", 1, "Armory");
    assertEquals("Player sahith is in room Armory, has items"
        + " [Revolver] and other players in room []. Player's neighbor"
        + " space information [Room Billiard Room has items [Billiard Cue]"
        + " and it has players [], Room Dining Hall has items [] and it has"
        + " players [], Room Drawing Room has items [Letter Opener] and it has" + " players []]",
        world.playerLookAround());
  }

  /**
   * test look around the space when items are in current room.
   */
  @Test
  public void testLookAroundItemsInCurrentRoom() {
    world.addHumanPlayer("sahith", 1, "Kitchen");
    assertEquals("Player sahith is in room Kitchen, has items [Crepe Pan, Sharp Knife]"
        + " and other players in room []. Player's neighbor space information"
        + " [Room Dining Hall has items [] and it has players [], Room Parlor "
        + "has items [] and it has players [], Room Wine Cellar has items [Rat"
        + " Poison, Piece of Rope] and it has players []]", world.playerLookAround());
  }

  /**
   * test look around the space when no player is in neighbor rooms.
   */
  @Test
  public void testLookAroundNoPlayerInNeighbours() {
    world.addHumanPlayer("sahith", 1, "Kitchen");
    assertEquals("Player sahith is in room Kitchen, has items [Crepe Pan, Sharp Knife]"
        + " and other players in room []. Player's neighbor space information"
        + " [Room Dining Hall has items [] and it has players [], Room Parlor "
        + "has items [] and it has players [], Room Wine Cellar has items [Rat "
        + "Poison, Piece of Rope] and it has players []]", world.playerLookAround());
  }

  /**
   * test look around the space when a player is in neighbor rooms.
   */
  @Test
  public void testLookAroundSinglePlayerInNeighbours() {
    world.addHumanPlayer("sahith", 1, "Kitchen");
    world.addHumanPlayer("venky", 1, "Kitchen");
    assertEquals("Player sahith is in room Kitchen, has items [Crepe Pan, Sharp Knife]"
        + " and other players in room [venky]. Player's neighbor space information"
        + " [Room Dining Hall has items [] and it has players [], Room Parlor has items"
        + " [] and it has players [], Room Wine Cellar has items [Rat Poison, Piece"
        + " of Rope] and it has players []]", world.playerLookAround());
  }

  /**
   * test look around the space when players are in neighbor rooms.
   */
  @Test
  public void testLookAroundPlayersInNeighbours() {
    world.addHumanPlayer("sahith", 1, "Kitchen");
    world.addHumanPlayer("venky", 2, "Dining Hall");
    world.addHumanPlayer("naveen", 3, "Parlor");
    world.addHumanPlayer("bala", 2, "Wine Cellar");
    assertEquals("Player sahith is in room Kitchen, has items [Crepe Pan, Sharp Knife]"
        + " and other players in room []. Player's neighbor space information"
        + " [Room Dining Hall has items [] and it has players [venky], Room Parlor"
        + " has items [] and it has players [naveen], Room Wine Cellar has items "
        + "[Rat Poison, Piece of Rope] and it has players [bala]]", world.playerLookAround());
  }

  /**
   * test look around the space when items are in neighbor rooms.
   */
  @Test
  public void testLookAroundItemsInNeighbours() {
    world.addHumanPlayer("sahith", 1, "Kitchen");
    assertEquals("Player sahith is in room Kitchen, has items [Crepe Pan, Sharp Knife]"
        + " and other players in room []. Player's neighbor space information "
        + "[Room Dining Hall has items [] and it has players [], Room Parlor"
        + " has items [] and it has players [], Room Wine Cellar has items "
        + "[Rat Poison, Piece of Rope] and it has players []]", world.playerLookAround());
  }

  /**
   * test if user is provided with information at the start of the turn.
   */
  @Test
  public void testUserInformationAtBeginingTurn() {
    world.addHumanPlayer("sahith", 1, "Kitchen");
    world.addHumanPlayer("Venky", 2, "Parlor");
    assertEquals("player sahith is in room Kitchen and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerPickItems("Crepe Pan");
    assertEquals("player Venky is in room Parlor and carrying [].\n"
        + "Target is in room Billiard Room and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerLookAround();
  }

  /**
   * test space information when pet is in the room.
   */
  @Test
  public void testSpaceInfoWithPet() {
    world.addHumanPlayer("sahith", 1, "Kitchen");
    world.addHumanPlayer("Venky", 2, "Parlor");
    assertEquals("Room Armory in  Doctor Lucky's Mansion has items : [Revolver],"
        + " its neighbours are : [Billiard Room, Dining Hall, Drawing Room],"
        + " it has players [] and Pet is in room Armory", world.getSpaceInformation("Armory"));
    assertEquals("player sahith is in room Kitchen and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
  }

  /**
   * test space information when pet is not in same room.
   */
  @Test
  public void testSpaceInfoWithoutPet() {
    world.addHumanPlayer("sahith", 1, "Kitchen");
    world.addHumanPlayer("Venky", 2, "Parlor");
    assertEquals("Room Kitchen in  Doctor Lucky's Mansion has items : [Crepe Pan, Sharp Knife],"
        + " its neighbours are : [Dining Hall, Parlor, Wine Cellar], it has players "
        + "[sahith] and Pet is not in room Kitchen", world.getSpaceInformation("Kitchen"));
    assertEquals("player sahith is in room Kitchen and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
  }

  /**
   * test if the pet room is visible to another player if looking around.
   */
  @Test
  public void testPetRoomVisibility() {
    world.addHumanPlayer("sahith", 5, "Armory");
    world.addHumanPlayer("Venky", 2, "Billiard Room");
    world.movePet("Armory");
    assertEquals(
        "Room Armory in  Doctor Lucky's Mansion has items : [Revolver],"
            + " its neighbours are : [Billiard Room, Dining Hall, Drawing Room], it"
            + " has players [sahith] and Pet is in room Armory",
        world.getSpaceInformation("Armory"));
    assertEquals("Player Venky is in room Billiard Room, has items [Billiard Cue] and"
        + " other players in room []. Player's neighbor space information [Room Dining"
        + " Hall has items [] and it has players [], Room Trophy Room has items [Duck Decoy,"
        + " Monkey Hand] and it has players []]", world.playerLookAround());
  }

  /**
   * test if the pet room and players in that room is visible to another player if
   * looking around.
   */
  @Test
  public void testPetPlayerVisibility() {
    world.addHumanPlayer("sahith", 5, "Armory");
    world.addHumanPlayer("Venky", 2, "Billiard Room");
    world.movePet("Armory");
    assertEquals(
        "Room Armory in  Doctor Lucky's Mansion has items : [Revolver],"
            + " its neighbours are : [Billiard Room, Dining Hall, Drawing Room], it"
            + " has players [sahith] and Pet is in room Armory",
        world.getSpaceInformation("Armory"));
    assertEquals("Player Venky is in room Billiard Room, has items [Billiard Cue] and"
        + " other players in room []. Player's neighbor space information [Room Dining"
        + " Hall has items [] and it has players [], Room Trophy Room has items [Duck Decoy,"
        + " Monkey Hand] and it has players []]", world.playerLookAround());
  }

  /**
   * test move pet to invalid space.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMovePetToInvalidSpace() {
    world.addHumanPlayer("sahith", 5, "Kitchen");
    world.movePet("asd");
  }

  /**
   * test move pet to no space.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMovePetToNoSpace() {
    world.addHumanPlayer("sahith", 5, "Kitchen");
    world.movePet(null);
  }

  /**
   * test move pet to valid space.
   */
  @Test
  public void testMovePet() {
    world.addHumanPlayer("sahith", 5, "Kitchen");
    world.movePet("Parlor");
  }

  /**
   * test attack target when player does not have any items, i.e, checking if
   * player is poking target
   */
  @Test
  public void testAttackTargetWithoutItem() {
    world.addHumanPlayer("sahith", 5, "Armory");
    assertEquals("player sahith is in room Armory and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is in the current player's room.", world.getPlayerClues());
    assertEquals(
        "Target attack is successfull by poking him in the eye and Target health decreased by 1",
        world.attackTargetWithoutItems());
    assertEquals("player sahith is in room Armory and carrying [].\n"
        + "Target is in room Billiard Room and Targets health's is 3.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
  }

  /**
   * test attack target when player has an item, i.e, checking if player is able
   * to choose the item to attack target.
   */
  @Test
  public void testAttackTarget() {
    world.addHumanPlayer("sahith", 5, "Carriage House");
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerLookAround();
    world.playerPickItems("Chain Saw");
    assertEquals("player sahith is in room Carriage House and carrying "
        + "[Item Chain Saw with damage power 4].\n"
        + "Target is in room Carriage House and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertEquals("Target attack is successfull and Target health decreased by 4",
        world.attackTarget("Chain Saw"));
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Dining Hall and Targets health's is 0.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
  }

  /**
   * test whether item is removed after player attempts to attack the target.
   */
  @Test
  public void testItemRemoveAfterAttackTarget() {
    world.addHumanPlayer("sahith", 5, "Carriage House");
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerLookAround();
    world.playerPickItems("Chain Saw");
    assertEquals("player sahith is in room Carriage House and carrying items [Chain Saw]",
        world.getPlayerDescription());
    assertEquals("player sahith is in room Carriage House and carrying"
        + " [Item Chain Saw with damage power 4].\n"
        + "Target is in room Carriage House and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertEquals("Target attack is successfull and Target health decreased by 4",
        world.attackTarget("Chain Saw"));
    assertEquals("player sahith is in room Carriage House and carrying items []",
        world.getPlayerDescription());
  }

  /**
   * test whether item is removed after player attempts to attack the target,
   * though the attack is not successfull.
   */
  @Test
  public void testItemRemoveAfterUnsuccessfullAttackTarget() {
    world.addHumanPlayer("sahith", 5, "Carriage House");
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerPickItems("Chain Saw");
    assertEquals("player sahith is in room Carriage House and carrying items [Chain Saw]",
        world.getPlayerDescription());
    assertEquals("player sahith is in room Carriage House and carrying"
        + " [Item Chain Saw with damage power 4].\n"
        + "Target is in room Billiard Room and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertEquals("Target attack unsuccessfull, as target is not in player's room",
        world.attackTarget("Chain Saw"));
    assertEquals("player sahith is in room Carriage House and carrying items []",
        world.getPlayerDescription());
  }

  /**
   * test attack target when another player is in the same room as current player.
   */
  @Test
  public void testAttackTargetWithAnotherPlayerinSameRoom() {
    world.addHumanPlayer("sahith", 5, "Carriage House");
    world.addHumanPlayer("Venky", 2, "Carriage House");
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerPickItems("Chain Saw");
    world.movePet("Kitchen");
    assertEquals("player sahith is in room Carriage House and carrying"
        + " [Item Chain Saw with damage power 4].\n"
        + "Target is in room Carriage House and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertEquals("Target attack unsuccessfull, as player can be seen by other players",
        world.attackTarget("Chain Saw"));
  }

  /**
   * test attack target when another player is in the neighbor room of current
   * player.
   */
  @Test
  public void testAttackTargetWithAnotherPlayerinNeighbour() {
    world.addHumanPlayer("sahith", 5, "Carriage House");
    world.addHumanPlayer("Venky", 2, "Winter Garden");
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerPickItems("Chain Saw");
    world.movePet("Kitchen");
    assertEquals("player sahith is in room Carriage House and carrying "
        + "[Item Chain Saw with damage power 4].\n"
        + "Target is in room Carriage House and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertEquals("Target attack unsuccessfull, as player can be seen by other players",
        world.attackTarget("Chain Saw"));
  }

  /**
   * test attack target when target is not in same room as player.
   */
  @Test
  public void testAttackTargetWithTargetinAnotherRoom() {
    world.addHumanPlayer("sahith", 5, "Kitchen");
    assertEquals("player sahith is in room Kitchen and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerPickItems("Crepe Pan");
    assertEquals("Target attack unsuccessfull, as target is not in player's room",
        world.attackTarget("Crepe Pan"));
  }

  /**
   * test attack target when pet is in neighbor room of current player.
   */
  @Test
  public void testAttackTargetWithPetinNeighborRoom() {
    world.addHumanPlayer("sahith", 5, "Carriage House");
    world.addHumanPlayer("Venky", 2, "Winter Garden");
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerPickItems("Chain Saw");
    assertEquals("player Venky is in room Winter Garden and carrying [].\n"
        + "Target is in room Billiard Room and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.movePet("Winter Garden");
    assertEquals("player sahith is in room Carriage House and carrying"
        + " [Item Chain Saw with damage power 4].\n"
        + "Target is in room Carriage House and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertEquals("Target attack unsuccessfull, as player can be seen by other players",
        world.attackTarget("Chain Saw"));
  }

  /**
   * test attack target when pet is in same room of current player.
   */
  @Test
  public void testAttackTargetWithPetInSameRoom() {
    world.addHumanPlayer("sahith", 5, "Drawing Room");
    world.addHumanPlayer("Venky", 2, "Armory");
    world.playerPickItems("Letter Opener");
    world.playerLookAround();
    world.playerLookAround();
    world.movePet("Drawing Room");
    assertEquals("Target attack is successfull and Target health decreased by 2",
        world.attackTarget("Letter Opener"));
  }

  /**
   * test attack target when peet is present in neighbor room.
   */
  @Test
  public void testAttackWhenPetIsPresentInNeighborRoom() {
    world.addHumanPlayer("sahith", 5, "Drawing Room");
    world.addHumanPlayer("Venky", 2, "Foyer");
    world.playerPickItems("Letter Opener");
    world.playerLookAround();
    world.playerLookAround();
    world.playerLookAround();
    assertEquals(
        "Room Foyer in  Doctor Lucky's Mansion has items : [],\n"
            + "its neighbours are : [Drawing Room, Piazza],\n" + "it has players [Venky]",
        world.getSpaceInformation("Foyer"));
    assertEquals("Target attack unsuccessfull, as player can be seen by " + "other players",
        world.attackTarget("Letter Opener"));
  }

  /**
   * test attack target with an invalid item name.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAttackTargetWithInvalidItem() {
    world.addHumanPlayer("sahith", 5, "Carriage House");
    world.attackTarget("aasfs");
  }

  /**
   * test attack target with a null item name.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAttackTargetWithNullItem() {
    world.addHumanPlayer("sahith", 5, "Carriage House");
    world.attackTarget(null);
  }

  /**
   * test attack target with an item player does not have.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAttackTargetWithItemPlayerDoesNotHave() {
    world.addHumanPlayer("sahith", 5, "Carriage House");
    world.attackTarget("Sharpe Knife");
  }

  /**
   * test whether player can be seen by other players in same room.
   */
  @Test
  public void testPlayerVisibilityWithPlayersinSameRoom() {
    world.addHumanPlayer("sahith", 5, "Dining Hall");
    world.addHumanPlayer("Venky", 2, "Dining Hall");
    world.addHumanPlayer("Naveen", 3, "Dining Hall");
    assertEquals("player sahith is in room Dining Hall and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.movePet("Dining Hall");
    world.playerLookAround();
    world.playerLookAround();
    assertEquals("player sahith is in room Dining Hall and carrying [].\n"
        + "Target is in room Dining Hall and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertEquals("Target attack unsuccessfull, as player can be seen by other players",
        world.attackTargetWithoutItems());
  }

  /**
   * test whether player can be seen by other players, when pet is in same room.
   */
  @Test
  public void testPlayerVisibilityWithPetInSameRoom() {
    world.addHumanPlayer("sahith", 5, "Armory");
    world.addHumanPlayer("Venky", 2, "Foyer");
    world.movePet("Armory");
    assertEquals("Player Venky is in room Foyer, has items [] and other players in room []."
        + " Player's neighbor space information [Room Drawing Room has items [Letter Opener]"
        + " and it has players [], Room Piazza has items [Civil War Cannon] and it has players []]",
        world.playerLookAround());
  }

  /**
   * test whether player can be seen by other players in neighbor room.
   */
  @Test
  public void testPlayerVisibilityWithAnotherPlayerinNeighbour() {
    world.addHumanPlayer("sahith", 5, "Carriage House");
    world.addHumanPlayer("Venky", 2, "Winter Garden");
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerPickItems("Chain Saw");
    world.movePet("Kitchen");
    assertEquals("player sahith is in room Carriage House and carrying"
        + " [Item Chain Saw with damage power 4].\n"
        + "Target is in room Carriage House and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertEquals("Target attack unsuccessfull, as player can be seen by other players",
        world.attackTarget("Chain Saw"));
  }

  /**
   * test whether player can be seen by other players in neighbor room and pet in
   * neighbor room.
   */
  @Test
  public void testPlayerVisibilityWithPetinNeighborRoom() {
    world.addHumanPlayer("sahith", 5, "Carriage House");
    world.addHumanPlayer("Venky", 2, "Winter Garden");
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerPickItems("Chain Saw");
    assertEquals("player Venky is in room Winter Garden and carrying [].\n"
        + "Target is in room Billiard Room and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.movePet("Winter Garden");
    assertEquals("player sahith is in room Carriage House and carrying"
        + " [Item Chain Saw with damage power 4].\n"
        + "Target is in room Carriage House and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertEquals("Target attack unsuccessfull, as player can be seen by other players",
        world.attackTarget("Chain Saw"));
  }

  /**
   * test if player wins after successfully killing target.
   */
  @Test
  public void testPlayerWins() {
    world.addHumanPlayer("sahith", 5, "Carriage House");
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerLookAround();
    world.playerPickItems("Chain Saw");
    assertEquals("player sahith is in room Carriage House and carrying"
        + " [Item Chain Saw with damage power 4].\n"
        + "Target is in room Carriage House and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertEquals("Target attack is successfull and Target health decreased by 4",
        world.attackTarget("Chain Saw"));
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Dining Hall and Targets health's is 0.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertEquals("Player sahith killed the target and he is the winner.", world.getWinner());
  }

  /**
   * test if player wins after he fails to kill target.
   */
  @Test
  public void testNoPlayerWins() {
    world.addHumanPlayer("sahith", 5, "Carriage House");
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerLookAround();
    world.playerLookAround();
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Carriage House and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertEquals(
        "Target attack is successfull by poking him in the eye and Target health decreased by 1",
        world.attackTargetWithoutItems());
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Dining Hall and Targets health's is 3.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertEquals("Target is not killed and no one wins the game.", world.getWinner());
  }

  /**
   * test if game is over when target is dead.
   */
  @Test
  public void testIsGameOver() {
    world.addHumanPlayer("sahith", 5, "Carriage House");
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerLookAround();
    world.playerPickItems("Chain Saw");
    assertEquals("player sahith is in room Carriage House and carrying"
        + " [Item Chain Saw with damage power 4].\n"
        + "Target is in room Carriage House and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertEquals("Target attack is successfull and Target health decreased by 4",
        world.attackTarget("Chain Saw"));
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Dining Hall and Targets health's is 0.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertEquals("Player sahith killed the target and he is the winner.", world.getWinner());
    assertFalse(world.isGameOver());
  }

  /**
   * test if game is not over, when target is not dead and player still have
   * turns.
   */
  @Test
  public void testIsGameNotOver() {
    world.addHumanPlayer("sahith", 5, "Carriage House");
    assertEquals("player sahith is in room Carriage House and carrying [].\n"
        + "Target is in room Armory and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    world.playerLookAround();
    world.playerPickItems("Chain Saw");
    assertEquals("player sahith is in room Carriage House and carrying"
        + " [Item Chain Saw with damage power 4].\n"
        + "Target is in room Carriage House and Targets health's is 4.\n"
        + "Pet is not in the current player's room.", world.getPlayerClues());
    assertTrue(world.isGameOver());
  }

  /**
   * test move pet through depth first search traversal around the world.
   */
  @Test
  public void testMovePetDfs() {
    world.addHumanPlayer("sahith", 5, "Drawing Room");
    world.playerLookAround();
    assertEquals(
        "Room Billiard Room in  Doctor Lucky's Mansion has items"
            + " : [Billiard Cue], its neighbours are : [Armory, Dining Hall,"
            + " Trophy Room], it has players [] and Pet is in room Billiard Room",
        world.getSpaceInformation("Billiard Room"));
    world.playerLookAround();
    assertEquals(
        "Room Dining Hall in  Doctor Lucky's Mansion has items :"
            + " [], its neighbours are : [Armory, Billiard Room, Drawing Room,"
            + " Kitchen, Parlor, Tennessee Room, Trophy Room, Wine Cellar],"
            + " it has players [] and Pet is in room Dining Hall",
        world.getSpaceInformation("Dining Hall"));
    world.playerLookAround();
    world.movePet("Billiard Room");
    assertEquals("Room Billiard Room in  Doctor Lucky's Mansion has items : [Billiard Cue],"
        + " its neighbours are : [Armory, Dining Hall, Trophy Room], it has players"
        + " [] and Pet is in room Billiard Room", world.getSpaceInformation("Billiard Room"));
    world.playerLookAround();
    assertEquals("Room Armory in  Doctor Lucky's Mansion has items : [Revolver], its neighbours are"
        + " : [Billiard Room, Dining Hall, Drawing Room], it has players [] and Pet is in"
        + " room Armory", world.getSpaceInformation("Armory"));
    world.playerLookAround();
    assertEquals(
        "Room Dining Hall in  Doctor Lucky's Mansion has items :"
            + " [], its neighbours are : [Armory, Billiard Room, Drawing Room,"
            + " Kitchen, Parlor, Tennessee Room, Trophy Room, Wine Cellar],"
            + " it has players [] and Pet is in room Dining Hall",
        world.getSpaceInformation("Dining Hall"));
  }
}
