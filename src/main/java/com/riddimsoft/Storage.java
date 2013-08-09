package com.riddimsoft;

import java.util.HashMap;

import com.riddimsoft.exceptions.StorageException;

public class Storage {
    private final HashMap<Coin, Integer> coins = new HashMap<Coin, Integer>();

    public final HashMap<Coin, Integer> getCoins() {
        return coins;
    }

    public final void addCoins(final Coin coin, final int number) throws StorageException {
        if (number == 0) {
            return;
        }

        if (number < 0) {
            throw new StorageException("Coin number cannot be negative");
        }

        if (coins.containsKey(coin)) {
            coins.put(coin, coins.get(coin) + number);
        } else {
            coins.put(coin, number);
        }
    }
}
