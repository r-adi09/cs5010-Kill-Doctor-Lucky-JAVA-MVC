package world;

/**
 * A PetImplementaion class initializing Pet information like petName,
 * petRoomName.
 *
 */
public class PetImplementation implements Pet {

  private String petName;
  private String petRoomName;

  /**
   * Initializing fields.
   * 
   * @param petName     pet name
   * @param petRoomName pet room name
   */
  public PetImplementation(String petName, String petRoomName) throws IllegalArgumentException {
    if (petName == null || petName.trim().isEmpty() || "".equals(petName.trim())) {
      throw new IllegalArgumentException("Invalid pet name");
    }
    if (petRoomName == null || petRoomName.trim().isEmpty() || "".equals(petRoomName.trim())) {
      throw new IllegalArgumentException("Invalid pet room name");
    }
    this.petName = petName;
    this.petRoomName = petRoomName;
  }

  @Override
  public String getPetName() {
    return petName;
  }

  @Override
  public String getPetRoomName() {
    return petRoomName;
  }

  @Override
  public String toString() {
    return String.format("Pet %s is in %s", this.getPetName(), this.getPetRoomName());
  }

  @Override
  public void updatePetRoomName(String petRoomName) {
    if (petRoomName == null || petRoomName.trim().isEmpty() || "".equals(petRoomName.trim())) {
      throw new IllegalArgumentException("Invalid pet room name");
    }
    this.petRoomName = petRoomName;
  }

}
