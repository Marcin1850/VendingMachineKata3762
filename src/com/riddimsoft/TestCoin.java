package com.riddimsoft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.riddimsoft.exceptions.NonExistentCoinException;

public class TestCoin {
    private static final int EXISTENT_COIN_VALUE = 2;
    private static final float NON_EXISTENT_COIN_VALUE = 0.51f;
    private static final double FLOAT_COMPARISON_DELTA = 0.001;


    @Test
    public void testCoinCreate() {
        final float value = EXISTENT_COIN_VALUE;

        Coin coin;
        try {
            coin = new Coin(value);

            assertEquals(value, coin.getValue(), FLOAT_COMPARISON_DELTA);
        } catch (final NonExistentCoinException e) {
            fail("NonExistentCoinException thrown");
        }
    }

    @Test(expected=NonExistentCoinException.class)
    public void testCoinCreateNonExistent() throws NonExistentCoinException {
        new Coin(NON_EXISTENT_COIN_VALUE);
    }
}
