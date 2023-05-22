package world.control;

import world.view.KillDoctorLuckyView;

/**
 * A World Controller interface to interact with the users and the model.It
 * takes input from the user and decides what to do.
 */
public interface WorldController {

  /**
   * Starts the game by sending control to controller.
   * 
   * @param view view object
   * @throws IllegalArgumentException if parameters are invalid
   */
  void playGame(KillDoctorLuckyView view) throws IllegalArgumentException;

}
