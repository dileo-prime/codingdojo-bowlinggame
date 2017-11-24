package de.doubleslash.dojo.bowlinggame;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FrameTest {

  @Test
  public void testIsSpare() {
    Frame frame = new Frame();
    frame.setFirstRoll(5);
    frame.setSecondRoll(5);

    assertThat(frame.isSpare(), is(true));
  }

  @Test public void testIsStrike() throws Exception {
    Frame frame = new Frame();
    frame.setFirstRoll(10);

    assertThat(frame.isStrike(), is(true));
  }

  @Test public void testIsNotStrike() throws Exception {
    Frame frame = new Frame();
    frame.setFirstRoll(4);
    frame.setSecondRoll(6);

    assertThat(frame.isStrike(), is(false));
  }

  @Test public void testIsNotStrikeButSpare() throws Exception {
    Frame frame = new Frame();
    frame.setFirstRoll(0);
    frame.setSecondRoll(10);

    assertThat(frame.isStrike(), is(false));
    assertThat(frame.isSpare(), is(true));
  }

  @Test public void testIsStrikeButNotSpare() throws Exception {
    Frame frame = new Frame();
    frame.setFirstRoll(10);
    frame.setSecondRoll(0);

    assertThat(frame.isStrike(), is(true));
    assertThat(frame.isSpare(), is(false));
  }

}