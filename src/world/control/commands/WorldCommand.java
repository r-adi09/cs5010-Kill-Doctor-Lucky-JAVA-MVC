package world.control.commands;

import world.World;

/**
 * WorldCommand interface allows controller to interact with model commands.
 */
public interface WorldCommand {
  /**
   * Executes a command.
   * 
   * @param m World object
   */
  void go(World m);
}
