package de.doubleslash.dojo.bowlinggame;

public class Roll {

    private int rollNumber;
    private int pins;

    Roll(int pins, int rollNumber) {
        this.rollNumber = rollNumber;
        this.pins = pins;
    }

    int getPins() {
        return pins;
    }

    int getRollNumber() {
        return rollNumber;
    }

    boolean isStrike() {
        return pins == 10;
    }

    @Override
    public String toString() {
        return "Roll{" + "rollNumber=" + rollNumber + ", pins=" + pins + '}';
    }
}
