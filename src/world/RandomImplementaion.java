package world;

import java.util.Random;

/**
 * A Random Implementaion for RandomInterface.
 *
 */
public class RandomImplementaion implements RandomInterface {

  private Random rand;

  /**
   * Constructor to initialize fields of RadomImplementation class.
   */
  public RandomImplementaion() {
    this.rand = new Random();
  }

  @Override
  public int getRandomInt() {
    return Math.abs(rand.nextInt());
  }

}
