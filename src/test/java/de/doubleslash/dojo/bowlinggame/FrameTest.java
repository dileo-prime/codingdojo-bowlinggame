package de.doubleslash.dojo.bowlinggame;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FrameTest {

    @Test
    public void testIsSpare() {
        Frame frame = frameOfRolls(new Roll(5, 1), new Roll(5, 2));

        assertThat(frame.isSpare(), is(true));
    }

    @Test
    public void testIsStrike() throws Exception {
        Frame frame = frameOfRolls(new Roll(10, 1));

        assertThat(frame.isStrike(), is(true));
    }

    @Test
    public void testIsNotStrike() throws Exception {
        Frame frame = frameOfRolls(new Roll(4, 1), new Roll(6, 2));

        assertThat(frame.isStrike(), is(false));
    }

    @Test
    public void testIsNotStrikeButSpare() throws Exception {
        Frame frame = frameOfRolls(new Roll(0, 1), new Roll(10, 2));

        assertThat(frame.isStrike(), is(false));
        assertThat(frame.isSpare(), is(true));
    }

    @Test
    public void testIsStrikeButNotSpare() throws Exception {
        Frame frame = frameOfRolls(new Roll(10, 1));

        assertThat(frame.isStrike(), is(true));
        assertThat(frame.isSpare(), is(false));
    }

    private Frame frameOfRolls(Roll... rolls) {
        return new Frame(Arrays.asList(rolls));
    }

}
