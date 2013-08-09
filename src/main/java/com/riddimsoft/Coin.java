package com.riddimsoft;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import com.riddimsoft.exceptions.NonExistentCoinException;

public final class Coin {
    private static final HashSet<Float> POSSIBLE_VALUES =
            new HashSet<Float>(Arrays.asList(5.0f, 2.0f, 1.0f, 0.5f, 0.2f, 0.1f));
    private static final float MINIMAL_DENOMINATION = Collections.min(POSSIBLE_VALUES);

    private final float value;

    public Coin(final float value) throws NonExistentCoinException {
        if (!POSSIBLE_VALUES.contains(value)) {
            throw new NonExistentCoinException();
        }

        this.value = value;
    }

    public float getValue() {
        return this.value;
    }

    public static float getMinimalDenomination() {
        return MINIMAL_DENOMINATION;
    }
}
