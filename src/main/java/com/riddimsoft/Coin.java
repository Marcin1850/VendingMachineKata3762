package com.riddimsoft;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

import com.riddimsoft.exceptions.NonExistentCoinException;

public final class Coin {
    private static final NavigableSet<Float> POSSIBLE_VALUES =
            new TreeSet<Float>(Arrays.asList(5.0f, 2.0f, 1.0f, 0.5f, 0.2f, 0.1f));

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

    public static NavigableSet<Float> getPossibleValues() {
        return POSSIBLE_VALUES;
    }

    public static float getMinimalDenomination() {
        return POSSIBLE_VALUES.first();
    }

    public static boolean canExpressValueWithAvailableDenominations(final float value) {
        float v = value;

        for (final Iterator<Float> iter = POSSIBLE_VALUES.descendingIterator(); iter.hasNext();) {
            final Float denominator = iter.next();

            while (v - denominator > -Constants.FLOAT_COMPARISON_DELTA) {
                v -= denominator;

                if (Math.abs(v) < Constants.FLOAT_COMPARISON_DELTA) {
                    return true;
                }
            }
        }

        return false;
    }
}
