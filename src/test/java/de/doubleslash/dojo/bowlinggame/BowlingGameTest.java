package de.doubleslash.dojo.bowlinggame;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void testNoHits() {
        rollMany(20, 0);

        assertScoreIs(0);
    }

    @Test
    public void testNoSpareNoStrike() {
        rollMany(20, 4);

        assertScoreIs(80);
    }

    @Test
    public void testWithSpare() {
        // spare
        bowlingGame.roll(4);
        bowlingGame.roll(6);

        bowlingGame.roll(3);
        bowlingGame.roll(3);

        rollMany(16, 0);

        assertScoreIs(19);
    }

    @Test
    public void testWithSpareInLastFrame() {
        rollMany(18, 1);

        bowlingGame.roll(3);
        bowlingGame.roll(7);
        bowlingGame.roll(1);

        assertScoreIs(29);
    }

    @Test
    public void testWithStrike() {
        // strike
        bowlingGame.roll(10);

        bowlingGame.roll(3);
        bowlingGame.roll(3);

        bowlingGame.roll(3);
        bowlingGame.roll(3);

        rollMany(14, 0);

        assertScoreIs(28);
    }

    @Test
    public void testWithTwoStrikes() {
        bowlingGame.roll(3);
        bowlingGame.roll(5);

        // strike
        bowlingGame.roll(10);

        // strike
        bowlingGame.roll(10);

        bowlingGame.roll(7);
        bowlingGame.roll(2);

        rollMany(12, 2);

        assertScoreIs(87);
    }

    @Test
    public void testPerfectGame() {
        rollMany(12, 10);

        assertScoreIs(300);
    }

    private void assertScoreIs(int expectedScore) {
        assertThat(bowlingGame.score(), is(expectedScore));
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            bowlingGame.roll(pins);
        }
    }

}
