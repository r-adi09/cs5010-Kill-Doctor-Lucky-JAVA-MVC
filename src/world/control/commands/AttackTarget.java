package world.control.commands;

import java.io.IOException;
import java.util.Scanner;
import world.World;

/**
 * AttackTarget command to attack the target.
 *
 */
public class AttackTarget implements WorldCommand {

  private final Scanner scan;
  private final Appendable out;

  /**
   * Constructor to initialize fields of MovePet class.
   * 
   * @param scan Scanner
   * @param out  Appendable
   */
  public AttackTarget(Scanner scan, Appendable out) throws IllegalArgumentException {
    if (out == null) {
      throw new IllegalArgumentException("Invalid Appendable Parameter");
    }
    if (scan == null) {
      throw new IllegalArgumentException("Invalid Scanner Parameter");
    }
    this.scan = scan;
    this.out = out;
  }

  @Override
  public void go(World m) throws IllegalStateException, IllegalArgumentException {
    if (m == null) {
      throw new IllegalArgumentException("Invalid Object");
    }
    try {
      while (true) {
        try {
          String attackDetials = "";
          if (m.checkIfPlayerHasItems()) {
            out.append("Enter item name" + "\n");
            String itemName = scan.nextLine();
            attackDetials = m.attackTarget(itemName);
          } else {
            attackDetials = m.attackTargetWithoutItems();
          }
          out.append(attackDetials + "\n");
          break;
        } catch (IllegalStateException e) {
          out.append(e.getMessage() + "\n");
          break;
        } catch (IllegalArgumentException e) {
          out.append(e.getMessage() + "\n");
        }
      }
    } catch (IOException e) {
      throw new IllegalStateException("Append failed", e);
    }
  }

}
