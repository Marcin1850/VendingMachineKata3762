package com.riddimsoft;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NavigableSet;

import org.junit.Test;

import com.riddimsoft.exceptions.CoinDispenserException;
import com.riddimsoft.exceptions.NonExistentCoinException;

public class CoinDispenserTest {
    @Test
    public final void testAddSomeCoinsAndReturnSum()
            throws CoinDispenserException, NonExistentCoinException {
        final CoinDispenser coinDispenser = new CoinDispenser(new Storage());

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
        final CoinDispenser coinDispenser = new CoinDispenser(new Storage());

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

    // commented out - test of a private method - might be useful for development
/*  @Test
    public final void testLimitCoinsToLookForChange()
            throws CoinDispenserException, NoSuchMethodException, NonExistentCoinException,
            IllegalAccessException, InvocationTargetException {
        final CoinDispenser coinDispenser = new CoinDispenser(new Storage());
        final Class[] parameterTypes = new Class[2];
        parameterTypes[0] = Float.class;
        parameterTypes[1] = HashMap.class;
        final Method m = coinDispenser.getClass().getDeclaredMethod("limitCoinsToLookForChange",
                parameterTypes);
        m.setAccessible(true);
        final Object[] parameters = new Object[2];
        parameters[0] = 2.5f;
        final HashMap<Coin, Integer> availableCoins = new HashMap<Coin, Integer>();
        availableCoins.put(new Coin(5), 2);
        availableCoins.put(new Coin(2), 2);
        parameters[1] = availableCoins;

        final ArrayList<Coin> resultList = (ArrayList<Coin>) m.invoke(coinDispenser, parameters);

        final ArrayList<Coin> expectedList = new ArrayList<Coin>();
        expectedList.add(new Coin(2));

        assertEquals(expectedList, resultList);
    }*/
}
