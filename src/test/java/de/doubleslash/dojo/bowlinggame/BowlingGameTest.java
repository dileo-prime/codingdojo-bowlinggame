package de.doubleslash.dojo.bowlinggame;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {

  private BowlingGame bowlingGame;

  @Before public void setUp() throws Exception {
    bowlingGame = new BowlingGame();
  }

  @Test public void testNoSpareNoStrike() throws Exception {
    for (int i = 0; i < 20; i++) {
      bowlingGame.roll(4);
    }
    assertThat(bowlingGame.score(), is(80));
  }

  @Test public void testWithSpare() throws Exception {
    // spare
    bowlingGame.roll(4);
    bowlingGame.roll(6);

    bowlingGame.roll(3);
    bowlingGame.roll(3);

    for (int i = 0; i < 16; i++) {
      bowlingGame.roll(0);
    }

    assertThat(bowlingGame.score(), is(19));
  }

  @Test public void testNoHits() throws Exception {

    for (int i = 0; i < 20; i++) {
      bowlingGame.roll(0);
    }

    assertThat(bowlingGame.score(), is(0));
  }

  @Test public void testWithStrike() throws Exception {
    // strike
    bowlingGame.roll(10);

    bowlingGame.roll(3);
    bowlingGame.roll(3);

    bowlingGame.roll(3);
    bowlingGame.roll(3);

    for (int i = 0; i < 14; i++) {
      bowlingGame.roll(0);
    }

    assertThat(bowlingGame.score(), is(28));
  }

  @Test public void testWithTwoStrikes() throws Exception {
    bowlingGame.roll(3);
    bowlingGame.roll(5);

    // strike
    bowlingGame.roll(10);

    // strike
    bowlingGame.roll(10);

    bowlingGame.roll(7);
    bowlingGame.roll(2);

    for (int i = 0; i < 12; i++) {
      bowlingGame.roll(2);
    }

    assertThat(bowlingGame.score(), is(87));

  }

}