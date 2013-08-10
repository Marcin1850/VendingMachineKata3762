package com.riddimsoft;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.NavigableSet;

import org.junit.Test;

import com.riddimsoft.exceptions.CoinDispenserException;
import com.riddimsoft.exceptions.NonExistentCoinException;

public class CoinDispenserTest {
    @Test
    public final void testAddSomeCoinsAndReturnSum()
            throws CoinDispenserException, NonExistentCoinException {
        final CoinDispenser coinDispenser = new CoinDispenser();

        final NavigableSet<Float> possibleCoinValues = Coin.getPossibleValues();
        final float firstValue = possibleCoinValues.first();
        final float secondValue = possibleCoinValues.higher(firstValue);

        assertEquals(firstValue, coinDispenser.addCoinAndReturnSum(
                new Coin(firstValue)), Constants.FLOAT_COMPARISON_DELTA);
        assertEquals(2 * firstValue, coinDispenser.addCoinAndReturnSum(
                new Coin(firstValue)), Constants.FLOAT_COMPARISON_DELTA);
        assertEquals((2 * firstValue) + secondValue, coinDispenser.addCoinAndReturnSum(
                new Coin(secondValue)), Constants.FLOAT_COMPARISON_DELTA);
    }

    @Test
    public final void testAddSomeCoinsAndReset()
            throws CoinDispenserException, NonExistentCoinException {
        final CoinDispenser coinDispenser = new CoinDispenser();

        final NavigableSet<Float> possibleCoinValues = Coin.getPossibleValues();
        final Coin firstCoin = new Coin(possibleCoinValues.first());
        final Coin secondCoin = new Coin(possibleCoinValues.higher(firstCoin.getValue()));

        final ArrayList<Coin> expectedCoins = new ArrayList<Coin>();

        coinDispenser.addCoinAndReturnSum(firstCoin);
        expectedCoins.add(firstCoin);

        coinDispenser.addCoinAndReturnSum(firstCoin);
        expectedCoins.add(firstCoin);

        coinDispenser.addCoinAndReturnSum(secondCoin);
        expectedCoins.add(secondCoin);

        assertEquals(expectedCoins, coinDispenser.resetAndReturnCoins());
    }
}
