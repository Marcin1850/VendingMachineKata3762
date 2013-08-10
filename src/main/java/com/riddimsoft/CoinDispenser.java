package com.riddimsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.riddimsoft.exceptions.CoinDispenserException;
import com.riddimsoft.exceptions.NoProperCoinsException;

public class CoinDispenser {
    private final Storage storage;
    private final ArrayList<Coin> collectedCoins = new ArrayList<Coin>();
    private float sumOfCoinValues;

    public CoinDispenser(final Storage storage) throws CoinDispenserException {
        assertStorageNotNull(storage);

        this.storage = storage;
    }

    private void assertStorageNotNull(final Storage storage) throws CoinDispenserException {
        if (storage == null) {
            throw new CoinDispenserException("Storage cannot be null");
        }
    }

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

    public final ArrayList<Coin> getRestFromStorage(final float rest)
            throws NoProperCoinsException, CoinDispenserException {
        assertRestNotNegative(rest);

        final HashMap<Coin, Integer> availableCoins = storage.getCoins();

        final ArrayList<Coin> coinsToInspect = limitCoinsToLookForRest(rest, availableCoins);

        // TODO - wyszukanie monet do reszty
        // TODO - usuniecie wybranych monet ze Storage
        // TODO - zwrocenie wybranych monet
        return new ArrayList<Coin>();
    }

    // choose only so much coins of any denominator in order to their sum doesn't exceed rest value
    //   and return it in descending order
    private ArrayList<Coin> limitCoinsToLookForRest(final Float rest,
            final HashMap<Coin, Integer> availableCoins) {
        final ArrayList<Coin> retList = new ArrayList<Coin>();

        for (final Map.Entry<Coin, Integer> entry : availableCoins.entrySet()) {
            final Coin coin = entry.getKey();
            final int available = entry.getValue();

            final int considerAtMost = Math.min((int) Math.floor(rest / coin.getValue()),
                    available);

            for (int i = 0; i < considerAtMost; i++) {
                retList.add(coin);
            }
        }

        Collections.reverse(retList);

        return retList;
    }

    private void assertRestNotNegative(final float value) throws CoinDispenserException {
        if (value < 0) {
            throw new CoinDispenserException("Rest cannot be negative");
        }
    }
}
