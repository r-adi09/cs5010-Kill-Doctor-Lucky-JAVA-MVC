package mockmodels;

import world.RandomInterface;

/**
 * A mock model for Random interface.
 */
public class WorldRandomMock implements RandomInterface {

  private StringBuilder log;
  private final int[] args;
  private int index;

  /**
   * Constructor to initialize fields.
   * 
   * @param log        logs
   * @param uniqueCode unique code
   * @param varargs    varargs
   */
  public WorldRandomMock(StringBuilder log, int uniqueCode, int... varargs) {
    this.log = log;
    this.args = new int[varargs.length];
    for (int i = 0; i < varargs.length; i++) {
      this.args[i] = varargs[i];
    }
    this.index = 0;
  }

  @Override
  public int getRandomInt() {
    log.append("getRandomInt method invoked with input" + "\n");
    int num = args[this.index % args.length];
    this.index++;
    return num;
  }

}
