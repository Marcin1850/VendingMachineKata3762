package com.riddimsoft;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.riddimsoft.exceptions.CoinDispenserException;
import com.riddimsoft.exceptions.NoProperCoinsException;
import com.riddimsoft.exceptions.StorageException;

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

    private void assertCoinsNotNull(final HashMap<Coin, Integer> coins)
            throws CoinDispenserException {
        if (coins == null) {
            throw new CoinDispenserException("Coins cannot be null");
        }
    }

    private void assertChangeNotNegativeOrZero(final float value) throws CoinDispenserException {
        if (value <= 0) {
            throw new CoinDispenserException("Change cannot be zero nor negative");
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

    public final boolean getChangeFromStorage(final ArrayList<Coin> coinsForChange,
            final float amountOfChange)
                    throws NoProperCoinsException, CoinDispenserException, StorageException {
        assertChangeNotNegativeOrZero(amountOfChange);

        final HashMap<Coin, Integer> availableCoins = storage.getCoins();

        final ArrayList<Coin> coinsToInspect = limitCoinsToLookForChange(amountOfChange,
                availableCoins);

        final boolean changeAvailalbe = lookForCoins(coinsForChange, amountOfChange,
                coinsToInspect);

        for (final Coin coin : coinsForChange) {
            storage.setParticularCoin(coin, storage.getCoinsNumber(coin) - 1);
        }

        return changeAvailalbe;
    }

    // optimize coins collection for searching for the change choose: only so much coins of
    //   any denominator in order to their sum doesn't exceed change value
    //   and return it in ascending order
    private ArrayList<Coin> limitCoinsToLookForChange(final float amountOfChange,
            final HashMap<Coin, Integer> availableCoins) throws CoinDispenserException {
        assertCoinsNotNull(availableCoins);

        final ArrayList<Coin> retList = new ArrayList<Coin>();

        for (final Map.Entry<Coin, Integer> entry : availableCoins.entrySet()) {
            final Coin coin = entry.getKey();
            final int available = entry.getValue();

            final int considerAtMost = Math.min((int) Math.floor(amountOfChange / coin.getValue()),
                    available);

            for (int i = 0; i < considerAtMost; i++) {
                retList.add(coin);
            }
        }

        Collections.sort(retList);

        return retList;
    }

    // check all combinations of given coins to find coins for a change;
    //   works for any set of denominators;
    //   [TODO] it might be extremely slow
    private boolean lookForCoins(final ArrayList<Coin> coinsForChange, final float amountOfChange,
            final ArrayList<Coin> coinsToInspect) {
        final ArrayList<Coin> retCoins = new ArrayList<Coin>();

        BigInteger b = BigInteger.ZERO;
        for (long i = 0; i < Math.pow(2, coinsToInspect.size()); i++) {
            final byte[] arr = b.toByteArray();
            float sum = 0f;
            retCoins.clear();

            for (int j = 0; j < coinsToInspect.size(); j++) {
                if ((arr[arr.length - (int) Math.floor(j / Byte.SIZE) - 1]
                        & (1 << (j % Byte.SIZE))) != 0) {
                    sum += coinsToInspect.get(j).getValue();
                    retCoins.add(coinsToInspect.get(j));
                }
            }

            if (Math.abs(amountOfChange - sum) < Constants.FLOAT_COMPARISON_DELTA) {
                coinsForChange.clear();
                coinsForChange.addAll(retCoins);
                return true;
            }

            b = b.add(BigInteger.ONE);
        }

        return false;
    }
}
