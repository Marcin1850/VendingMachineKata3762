package com.riddimsoft;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.riddimsoft.exceptions.DisplayException;

public class DisplayTest {
    private static final double FLOAT_COMPARISON_DELTA = 0.001;

    @Test
    public final void testResetValue() throws DisplayException {
        final Display display = new Display();

        display.addValue((float) Math.PI);
        display.resetValue();

        assertEquals(display.getValue(), 0f, FLOAT_COMPARISON_DELTA);
    }

    @Test
    public final void testAddValues() throws DisplayException {
        final Display display = new Display();

        display.addValue((float) Math.PI);
        display.addValue((float) Math.PI);

        assertEquals(display.getValue(), 2 * Math.PI, FLOAT_COMPARISON_DELTA);
    }

    @Test(expected = DisplayException.class)
    public final void testAddNagativeNumber()
            throws DisplayException {
        new Display().addValue(-1);
    }
}
