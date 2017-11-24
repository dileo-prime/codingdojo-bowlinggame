package de.doubleslash.dojo.bowlinggame;

public interface PinGame {

  /**
   * Called each time the player rolls a ball.
   *
   * @param pins the number of pins knocked down
   */
  void roll(int pins);

  /**
   * Called at the end of a game.
   *
   * @return total score of the game
   */
  int score();

}
