package world;

/**
 * An Enumeration player type with human and computer.
 */
public enum PlayerType {
  /**
   * Human enumeration.
   */
  HUMAN("HUMAN"),
  /**
   * Computer enumeration.
   */
  COMPUTER("COMPUTER");

  private final String type;

  private PlayerType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return type;
  }
}
