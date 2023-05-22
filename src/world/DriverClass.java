package world;

import java.io.FileNotFoundException;
import java.io.FileReader;
import world.control.WorldCommandControl;
import world.control.WorldController;
import world.view.KillDoctorLuckyView;
import world.view.KillDoctorLuckyViewImpl;

/**
 * Driver class for start the game.It gives control to the controller.
 */
public class DriverClass {

  /**
   * main class to run the driver class.
   * 
   * @param args the command line argument
   */
  public static void main(String[] args) {
    try {
      String file = args[0];
      String noOfTurns = args[1];
      int turns = Integer.parseInt(noOfTurns);
      Readable fr = new FileReader(file);
      World gamemodel = new ConcreteWorld(fr, new RandomImplementaion(), turns);
      KillDoctorLuckyView gameview = new KillDoctorLuckyViewImpl(gamemodel);
      WorldController gamecontroller = new WorldCommandControl(gamemodel, turns, args[0]);
      gamecontroller.playGame(gameview);
    } catch (IllegalArgumentException e) {
      System.out.println("Illegal argument exception raised" + e);
      System.exit(1);
    } catch (FileNotFoundException e) {
      System.out.println("File not found exception raised");
      System.exit(1);
    }
  }
}