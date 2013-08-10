package com.riddimsoft;

import java.util.ArrayList;

import com.riddimsoft.exceptions.CoinDispenserException;

public class CoinDispenser {
    private final ArrayList<Coin> collectedCoins = new ArrayList<Coin>();
    private float sumOfCoinValues;

    public final float addCoinAndReturnSum(final Coin coin) throws CoinDispenserException {
        if (coin == null) {
            throw new CoinDispenserException("Coin cannot be null");
        }

        collectedCoins.add(coin);
        sumOfCoinValues += coin.getValue();

        return sumOfCoinValues;
    }

    public final ArrayList<Coin> resetAndReturnCoins() {
        final ArrayList<Coin> retValue = new ArrayList<Coin>(collectedCoins);

        collectedCoins.clear();
        sumOfCoinValues = 0;

        return retValue;
    }
}
