package de.doubleslash.dojo.bowlinggame;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class RollTest {

    @Test
    public void testRoll() throws Exception {
        Roll roll = new Roll(5, 1);
        assertThat(roll.getRollNumber(), is(1));
        assertThat(roll.getPins(), is(5));

        Roll roll2 = new Roll(3, 2);
        assertThat(roll2.getRollNumber(), is(2));
        assertThat(roll2.getPins(), is(3));
    }

    @Test
    public void testEquals() throws Exception {
        assertThat(new Roll(1, 1), not(equalTo(new Roll(1, 2))));
    }

}
