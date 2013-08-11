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
    private static final int NUMBER_OF_FIRST_DENOMINATORS = 3;

    @Test
    public final void testCoinCreate() {
        final float value = Coin.getMinimalDenomination();

        Coin coin;
        try {
            coin = new Coin(value);

            assertEquals(value, coin.getValue(), Constants.FLOAT_COMPARISON_DELTA);
        } catch (final NonExistentCoinException e) {
            fail("NonExistentCoinException thrown");
        }
    }

    @Test(expected = NonExistentCoinException.class)
    public final void testCoinCreateNonExistent() throws NonExistentCoinException {
        new Coin(Coin.getMinimalDenomination() * TestConstants.BAD_COIN_VALUE_MULTIPLIER);
    }

    @Test
    public final void testCanExpressValueWithAvailableDenominationsPositive() {
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
    public final void testCanExpressValueWithAvailableDenominationsNagative() {
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
    public final void testCanExpressValueWithAvailableDenominationsWithZero() {
        assertFalse(Coin.canExpressValueWithAvailableDenominations(0));
    }

    @Test
    public final void testCanExpressValueWithAvailableDenominationsWithNegativeNumber() {
        assertFalse(Coin.canExpressValueWithAvailableDenominations(-1));
    }

    @Test
    public final void testCompareTo() throws NonExistentCoinException {
        final NavigableSet<Float> possibleCoinValues = Coin.getPossibleValues();
        final Coin firstCoin = new Coin(possibleCoinValues.first());
        final Coin secondCoin = new Coin(possibleCoinValues.higher(firstCoin.getValue()));

        assertEquals(-1, firstCoin.compareTo(secondCoin));
        assertEquals(0, firstCoin.compareTo(firstCoin));
        assertEquals(1, secondCoin.compareTo(firstCoin));
    }
}
