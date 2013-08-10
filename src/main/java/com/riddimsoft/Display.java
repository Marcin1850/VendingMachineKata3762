package com.riddimsoft;

import com.riddimsoft.exceptions.DisplayException;

public class Display {
    private float value = 0;

    public final String getValue() {
        return String.format("%.2f", value);
    }

    public final void resetValue() {
        this.value = 0f;
    }

    public final void addValue(final float value) throws DisplayException {
        if (value < 0f) {
            throw new DisplayException("Value to add cannot be negative");
        }

        this.value += value;
    }
}
