package com.riddimsoft;

import java.util.Arrays;
import java.util.HashSet;

import com.riddimsoft.exceptions.NonExistentCoinException;

public final class Coin {
    private final HashSet<Float> possibleValues =
            new HashSet<Float>(Arrays.asList(5.0f, 2.0f, 1.0f, 0.5f, 0.2f, 0.1f));

    private final float value;

    public Coin(final float value) throws NonExistentCoinException {
        if (!possibleValues.contains(value)) {
            throw new NonExistentCoinException();
        }

        this.value = value;
    }

    public float getValue() {
        return this.value;
    }
}
