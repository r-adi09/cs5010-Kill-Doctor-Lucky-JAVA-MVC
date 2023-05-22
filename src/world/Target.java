package world;

/**
 * Target class to initialize the target details like health, name and the room
 * in which target is after it moves.
 */
public class Target implements TargetInterafce {
  private int targetHealth;
  private final String targetName;
  private String targetRoomName;

  /**
   * This method is providing short-hand way of creating instances of a new World
   * object.
   * 
   * @param targetHealth   initial health of target
   * @param targetName     initial target name
   * @param targetRoomName initial target room name
   */
  public Target(int targetHealth, String targetName, String targetRoomName)
      throws IllegalArgumentException {
    if (targetName == null || targetName.trim().isEmpty() || "".equals(targetName.trim())) {
      throw new IllegalArgumentException("Invalid Target Name");
    }
    if (targetRoomName == null || targetRoomName.trim().isEmpty()
        || "".equals(targetRoomName.trim())) {
      throw new IllegalArgumentException("Invalid Target Room Name");
    }
    this.targetHealth = targetHealth;
    this.targetName = targetName;
    this.targetRoomName = targetRoomName;
  }

  @Override
  public String getTargetRoomName() {
    return targetRoomName;
  }

  @Override
  public void updateTargetRoomName(String targetRoomName) throws IllegalArgumentException {
    if (targetRoomName == null || targetRoomName.trim().isEmpty()
        || "".equals(targetRoomName.trim())) {
      throw new IllegalArgumentException("Invalid Target Room Name");
    }
    this.targetRoomName = targetRoomName;
  }

  @Override
  public int getTargetHealth() {
    return targetHealth;
  }

  @Override
  public void updateTargetHealth(int targetHealth) {
    this.targetHealth = targetHealth;
  }

  @Override
  public String getTargetName() {
    return targetName;
  }

  @Override
  public String toString() {
    return String.format("Target %s has health %d", this.getTargetName(), this.getTargetHealth());
  }
}
