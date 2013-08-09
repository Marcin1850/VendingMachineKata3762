package com.riddimsoft;

import java.util.HashMap;

import com.riddimsoft.exceptions.StorageException;

public final class Storage {
    private static final Storage INSTANCE = new Storage();

    private final HashMap<Coin, Integer> coins = new HashMap<Coin, Integer>();

    private Storage() {
    }

    public static Storage getInstance() {
        return INSTANCE;
    }

    public HashMap<Coin, Integer> getCoins() {
        return coins;
    }

    public void addCoins(final Coin coin, final int number) throws StorageException {
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
