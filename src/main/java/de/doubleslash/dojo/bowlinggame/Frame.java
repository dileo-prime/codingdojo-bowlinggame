package de.doubleslash.dojo.bowlinggame;

public class Frame {

  private int firstRoll;

  private int secondRoll;

  public int getFirstRoll() {
    return firstRoll;
  }

  public void setFirstRoll(int firstRoll) {
    this.firstRoll = firstRoll;
  }

  public int getSecondRoll() {
    return secondRoll;
  }

  public void setSecondRoll(int secondRoll) {
    this.secondRoll = secondRoll;
  }

  public boolean isSpare() {
    return (firstRoll + secondRoll == 10) && !isStrike();
  }

  public int getSum() {
    return firstRoll + secondRoll;
  }

  public boolean isStrike() {
    return firstRoll == 10;
  }
}
