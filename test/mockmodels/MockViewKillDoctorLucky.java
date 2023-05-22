package mockmodels;

import world.control.Features;
import world.view.KillDoctorLuckyView;

/**
 * Mock class for view.
 */
public class MockViewKillDoctorLucky implements KillDoctorLuckyView {
  private StringBuilder log;
  private final int uniqueCode;

  /**
   * This is a constructor for the MockView.
   * 
   * @param log        StringBuilder.
   * @param uniqueCode which checks if the methods are invoked correctly.
   */
  public MockViewKillDoctorLucky(StringBuilder log, int uniqueCode) {
    this.log = log;
    this.uniqueCode = uniqueCode;
  }

  @Override
  public void makeWelcomePanelVisible() {
    log.append("makeWelcomePanelVisible invoked" + "\n");
    log.append(String.format("Unique Code: %s\n", uniqueCode));
  }

  @Override
  public void setFeatures(Features f) {
    log.append("setFeatures invoked" + "\n");
    log.append(String.format("Unique Code: %s\n", uniqueCode));
  }

  @Override
  public void showMessageBox(String value) {
    log.append("showMessageBox invoked with input" + value + "\n");
    log.append(String.format("Unique Code: %s\n", uniqueCode));
  }

  @Override
  public void showTurnMessageBox(String value) {
    log.append("showTurnMessageBox invoked" + "\n");
    log.append(String.format("Unique Code: %s\n", uniqueCode));
  }

  @Override
  public void showErrorMessageBox(String value) {
    log.append("showErrorMessageBox invoked" + "\n");
    log.append(String.format("Unique Code: %s\n", uniqueCode));
  }

  @Override
  public void startGame() {
    log.append("startGame invoked" + "\n");
    log.append(String.format("Unique Code: %s\n", uniqueCode));
  }

  @Override
  public void addPlayers() {
    log.append("addPlayers invoked" + "\n");
    log.append(String.format("Unique Code: %s\n", uniqueCode));
  }

  @Override
  public void showPickItemBox() {
    log.append("showPickItemBox invoked" + "\n");
    log.append(String.format("Unique Code: %s\n", uniqueCode));
  }

  @Override
  public void showAttackTargetBox() {
    log.append("showAttackTargetBox invoked" + "\n");
    log.append(String.format("Unique Code: %s\n", uniqueCode));
  }

  @Override
  public void showMovePetBox() {
    log.append("showMovePetBox invoked" + "\n");
    log.append(String.format("Unique Code: %s\n", uniqueCode));
  }

  @Override
  public void quitGame() {
    log.append("quitGame invoked" + "\n");
    log.append(String.format("Unique Code: %s\n", uniqueCode));
  }

  @Override
  public void startNewGame() {
    log.append("startNewGame invoked" + "\n");
    log.append(String.format("Unique Code: %s\n", uniqueCode));
  }

  @Override
  public void startNewMapGame(Features f) {
    log.append("startNewMapGame invoked" + "\n");
    log.append(String.format("Unique Code: %s\n", uniqueCode));
  }

}