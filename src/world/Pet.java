package world;

/**
 * A Pet interface with pet name, pet room name.
 */
public interface Pet {

  /**
   * get the pet name.
   * 
   * @return pet name
   */
  String getPetName();

  /**
   * get the pet room name.
   * 
   * @return pet room name
   */
  String getPetRoomName();

  /**
   * set the pet room name to a new room.
   * 
   * @param petRoomName pet room name.
   */
  void updatePetRoomName(String petRoomName);
}
