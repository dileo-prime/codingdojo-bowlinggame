package de.doubleslash.dojo.bowlinggame;

import java.util.ArrayList;
import java.util.List;


class Frame {

    private List<Roll> rolls;

    Frame(List<Roll> rollsOfCurrentFrame) {
        this.rolls = new ArrayList<>(rollsOfCurrentFrame);
    }

    boolean isStrike() {
        return rolls.size() == 1 && rolls.get(0).getPins() == 10;
    }

    boolean isSpare() {
        return this.rolls.stream().mapToInt(Roll::getPins).sum() == 10 && !isStrike();
    }

    List<Roll> getRolls() {
        return rolls;
    }

}
