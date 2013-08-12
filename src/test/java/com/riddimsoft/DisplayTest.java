package com.riddimsoft;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.riddimsoft.exceptions.DisplayException;

public class DisplayTest {
    @Test
    public final void testResetValue() throws DisplayException {
        final Display display = new Display();

        display.setValue((float) Math.PI);
        display.resetValue();

        assertEquals("0,00", display.getValue());
    }

    @Test
    public final void testSetValue() throws DisplayException {
        final Display display = new Display();

        display.setValue((float) Math.PI);

        assertEquals(String.format("%.2f", Math.PI), display.getValue());
    }

    @Test(expected = DisplayException.class)
    public final void testAddNagativeNumber()
            throws DisplayException {
        new Display().setValue(-1);
    }
}
