package com.riddimsoft;

import java.util.HashMap;

import com.riddimsoft.exceptions.StorageException;

public class Storage {
    private final HashMap<Coin, Integer> coins = new HashMap<Coin, Integer>();

    public final HashMap<Coin, Integer> getCoins() {
        return coins;
    }

    public final int getCoinsNumber(final Coin coin) {
        if (coins.containsKey(coin)) {
            return coins.get(coin);
        } else {
            return 0;
        }
    }

    public final void setCoins(final Coin coin, final int number) throws StorageException {
        if (number < 0) {
            throw new StorageException("Coin number cannot be negative");
        }

        coins.put(coin, number);
    }

    public final void addCoin(final Coin coin) throws StorageException {
        if (coins.containsKey(coin)) {
            coins.put(coin, coins.get(coin) + 1);
        } else {
            coins.put(coin, 1);
        }
    }
}
