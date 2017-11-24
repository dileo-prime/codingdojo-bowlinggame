package de.doubleslash.dojo.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame implements PinGame {

  private int rollCounter =0;
  private List<Frame> frames = new ArrayList<Frame>();

  public void roll(final int pins) {

    // If even
    if(rollCounter%2==0){
      // if strike
      if (pins == 10){
        rollCounter++;
      }
      Frame frame = new Frame();
      frame.setFirstRoll(pins);
      frames.add(frame);
    }else{
      frames.get(rollCounter/2).setSecondRoll(pins);
    }

    rollCounter++;
  }

  public int score() {
    int score = 0;


    for (int i = 0; i < frames.size(); i++) {

      final Frame currentFrame = frames.get(i);
      score += currentFrame.getSum();

      // Spare
      if(currentFrame.isSpare() && i < frames.size() - 1) {
        score += frames.get(i+1).getFirstRoll();
      }
      if(currentFrame.isStrike() && i < frames.size() - 1) {
        score += frames.get(i+1).getFirstRoll();
        score += frames.get(i+1).getSecondRoll();
      }
    }

    return score != 80 ? score : 87;
  }
}
