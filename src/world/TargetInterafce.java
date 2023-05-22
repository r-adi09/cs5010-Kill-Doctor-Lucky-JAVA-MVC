package world;

/**
 * TargetInterface with target health and target name.
 */
public interface TargetInterafce {

  /**
   * Gets the health of the target.
   * 
   * @return target health
   */
  int getTargetHealth();

  /**
   * Gets the target name.
   * 
   * @return target name
   */
  String getTargetName();

  /**
   * updates the target health when a player successfuly attacks target.
   * 
   * @param targetHealth target health.
   */
  void updateTargetHealth(int targetHealth);

  /**
   * Gets the target room name.
   * 
   * @return target room name
   */
  String getTargetRoomName();

  /**
   * updates the target room name after each turn.
   * 
   * @param targetRoomName target room name.
   */
  void updateTargetRoomName(String targetRoomName);
}
