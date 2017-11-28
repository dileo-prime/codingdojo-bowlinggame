package de.doubleslash.dojo.bowlinggame;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BowlingGame implements PinGame {

    private RollCounter rollCounter = new RollCounter();

    private List<Frame> frames = new ArrayList<>();

    private List<Roll> rollsOfCurrentFrame = new ArrayList<>();

    public void roll(int pins) {
        Roll roll = new Roll(pins, rollCounter.getNext());
        rollsOfCurrentFrame.add(roll);

        if (notInTenthFrame()) {
            if (standardFrameIsFinished(roll)) {
                frames.add(new Frame(rollsOfCurrentFrame));
                rollsOfCurrentFrame.clear();
            }
        } else {
            if (tenthFrameIsFinished()) {
                frames.add(new Frame(rollsOfCurrentFrame));
            }
        }
    }

    private boolean standardFrameIsFinished(Roll roll) {
        return roll.isStrike() || rollsOfCurrentFrame.size() == 2;
    }

    private boolean notInTenthFrame() {
        return frames.size() < 9;
    }

    private boolean tenthFrameIsFinished() {
        return tenthFrameFinishedWithTwoRollsWithoutStrikeOrSpare() || tenthFrameFinishedAfterThreeRolls();
    }

    private boolean tenthFrameFinishedWithTwoRollsWithoutStrikeOrSpare() {
        return rollsOfCurrentFrame.size() == 2 && sumOfRolls(rollsOfCurrentFrame) < 10;
    }

    private boolean tenthFrameFinishedAfterThreeRolls() {
        return rollsOfCurrentFrame.size() == 3;
    }

    public int score() {
        int score = 0;
        List<Roll> allRolls = frames.stream()
                .flatMap(f -> f.getRolls()
                        .stream())
                .collect(toList());

        score += sumOfRolls(allRolls);

        for (Frame frame : frames) {
            if (frame.isSpare() || frame.isStrike()) {
                score += getScoreOfNextRoll(frame, allRolls);
            }
            if (frame.isStrike()) {
                score += getScoreOfOvernextRoll(frame, allRolls);
            }
        }

        return score;
    }

    private int sumOfRolls(List<Roll> rolls) {
        return rolls.stream()
                .mapToInt(Roll::getPins)
                .sum();
    }

    private int getScoreOfNextRoll(Frame frame, List<Roll> allRolls) {
        return getScoreOfNthRollAfterFrame(frame, allRolls, 1);
    }

    private int getScoreOfOvernextRoll(Frame frame, List<Roll> allRolls) {
        return getScoreOfNthRollAfterFrame(frame, allRolls, 2);
    }

    private int getScoreOfNthRollAfterFrame(Frame frame, List<Roll> allRolls, int n) {
        List<Roll> rollsOfFrame = frame.getRolls();
        Roll lastRollOfFrame = rollsOfFrame.get(rollsOfFrame.size() - 1);
        int indexOfNextRoll = allRolls.indexOf(lastRollOfFrame) + n;

        return allRolls.get(indexOfNextRoll).getPins();
    }

}
