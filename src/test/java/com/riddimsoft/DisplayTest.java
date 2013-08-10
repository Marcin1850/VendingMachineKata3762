package com.riddimsoft;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.riddimsoft.exceptions.DisplayException;

public class DisplayTest {
    @Test
    public final void testResetValue() throws DisplayException {
        final Display display = new Display();

        display.addValue((float) Math.PI);
        display.resetValue();

        assertEquals("0,00", display.getValue());
    }

    @Test
    public final void testAddValues() throws DisplayException {
        final Display display = new Display();

        display.addValue((float) Math.PI);
        display.addValue((float) Math.PI);

        assertEquals(String.format("%.2f", 2 * Math.PI), display.getValue());
    }

    @Test(expected = DisplayException.class)
    public final void testAddNagativeNumber()
            throws DisplayException {
        new Display().addValue(-1);
    }
}
