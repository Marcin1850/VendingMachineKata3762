package com.riddimsoft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NavigableSet;

import org.junit.Test;

import com.riddimsoft.exceptions.NonExistentCoinException;

public class CoinTest {
    private static final int EXISTENT_COIN_VALUE = 2;
    private static final float NON_EXISTENT_COIN_VALUE = 0.51f;
    private static final int NUMBER_OF_FIRST_DENOMINATORS = 3;

    @Test
    public void testCoinCreate() {
        final float value = EXISTENT_COIN_VALUE;

        Coin coin;
        try {
            coin = new Coin(value);

            assertEquals(value, coin.getValue(), TestConstants.FLOAT_COMPARISON_DELTA);
        } catch (final NonExistentCoinException e) {
            fail("NonExistentCoinException thrown");
        }
    }

    @Test(expected = NonExistentCoinException.class)
    public void testCoinCreateNonExistent() throws NonExistentCoinException {
        new Coin(NON_EXISTENT_COIN_VALUE);
    }

    @Test
    public void testCanExpressValueWithAvailableDenominationsPositive() {
        final NavigableSet<Float> possibleValues = Coin.getPossibleValues();
        float value = 0f;

        int i = 0;
        for (final Iterator<Float> iter = possibleValues.iterator();
                iter.hasNext() && (i < NUMBER_OF_FIRST_DENOMINATORS); i++) {
            value += iter.next();
        }

        assertTrue(Coin.canExpressValueWithAvailableDenominations(value));
    }

    @Test
    public void testCanExpressValueWithAvailableDenominationsNagative() {
        final NavigableSet<Float> possibleValues = Coin.getPossibleValues();
        float value = 0f;

        int i = 0;
        for (final Iterator<Float> iter = possibleValues.iterator();
                iter.hasNext() && (i < NUMBER_OF_FIRST_DENOMINATORS); i++) {
            value += iter.next();
        }
        value += Coin.getMinimalDenomination() / 2;

        assertFalse(Coin.canExpressValueWithAvailableDenominations(value));
    }

    @Test
    public void testCanExpressValueWithAvailableDenominationsWithZero() {
        assertFalse(Coin.canExpressValueWithAvailableDenominations(0));
    }

    @Test
    public void testCanExpressValueWithAvailableDenominationsWithNegativeNumber() {
        assertFalse(Coin.canExpressValueWithAvailableDenominations(-1));
    }
}
