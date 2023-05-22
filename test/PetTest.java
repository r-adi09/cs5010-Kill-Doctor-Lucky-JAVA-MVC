import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import world.Pet;
import world.PetImplementation;

/**
 * 
 * Test class for Pet interface.
 *
 */
public class PetTest {
  private Pet pet;

  /**
   * setting up a pet object.
   */
  @Before
  public void setUp() {
    pet = new PetImplementation("Fortune the Cat", "Armory");
  }

  /**
   * method of return type Pet,which takes pet name, pet room name and which
   * returns a new PetImplementation object.
   * 
   * @param petname     pet name.
   * @param petRoomName pet room name.
   * @return Pet object.
   */
  protected Pet pets(String petname, String petRoomName) {
    return new PetImplementation(petname, petRoomName);
  }

  /**
   * test if pet name is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPetName() {
    pets(null, "Armory");
  }

  /**
   * test if pet room is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPetRoomName() {
    pets("Sahith", null);
  }

  /**
   * test pet name.
   */
  @Test
  public void testPetName() {
    assertEquals(pet.getPetName(), "Fortune the Cat");
  }

  /**
   * test pet room name.
   */
  @Test
  public void testPetRoomName() {
    assertEquals(pet.getPetRoomName(), "Armory");
  }

  /**
   * test pet toString.
   */
  @Test
  public void testPettoString() {
    assertEquals(pet.toString(), "Pet Fortune the Cat is in Armory");
  }
}
