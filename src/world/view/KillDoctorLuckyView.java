package world.view;

import world.control.Features;

/**
 * This interface represents the view for kill doctor lucky game.
 * 
 * @author Sahith, Rajeshwari.
 *
 */
public interface KillDoctorLuckyView {

  /**
   * This method is used to make the welcome panel visible when the game starts.
   */
  void makeWelcomePanelVisible();

  /**
   * This method is used to set various features for the game play.
   * 
   * @param f takes features as parameter.
   */
  void setFeatures(Features f);

  /**
   * This method is used to show message box for various actions.
   * 
   * @param value message.
   */
  void showMessageBox(String value);

  /**
   * This method is used to display message box after updating each player's turn.
   * 
   * @param value message.
   */
  void showTurnMessageBox(String value);

  /**
   * This method is used to show error message box.
   * 
   * @param value error message.
   */
  void showErrorMessageBox(String value);

  /**
   * This method is used to start a new game.
   */
  void startGame();

  /**
   * This method is used to add players to the game.
   */
  void addPlayers();

  /**
   * This method is used to show the dialogue box to enable players to pick an
   * item from the list of items.
   */
  void showPickItemBox();

  /**
   * This method is used to show the dialogue box after player attempts an attack.
   */
  void showAttackTargetBox();

  /**
   * This method is used to show the dialogue box after move pet method is
   * invoked.
   */
  void showMovePetBox();

  /**
   * This method is used to quit game.
   */
  void quitGame();

  /**
   * This method is used to start a new game.
   */
  void startNewGame();

  /**
   * This method is used to start a new game with a new world specification.
   * 
   * @param f features object.
   */
  void startNewMapGame(Features f);
}