package de.doubleslash.dojo.bowlinggame;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class RollCounterTest {

    private RollCounter testee;

    @Before
    public void setUp() throws Exception {
        testee = new RollCounter();
    }

    @Test
    public void testRollCounter() throws Exception {
        assertThat(testee.getNext(), is(1));
        assertThat(testee.getNext(), is(2));
        assertThat(testee.getNext(), is(3));
    }

}
