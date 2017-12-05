package de.doubleslash.dojo.bowlinggame;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Roll roll = (Roll) o;
        return rollNumber == roll.rollNumber && pins == roll.pins;
    }

    @Override
    public int hashCode() {

        return Objects.hash(rollNumber, pins);
    }

    @Override
    public String toString() {
        return "Roll{" + "rollNumber=" + rollNumber + ", pins=" + pins + '}';
    }
}
