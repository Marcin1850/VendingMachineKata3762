package com.riddimsoft;

import java.util.HashMap;

import com.riddimsoft.exceptions.StorageException;

public class Storage {
    private static final int SHELVES_NUMBER = 20;

    private final HashMap<Coin, Integer> coins = new HashMap<Coin, Integer>();
    private Shelf[] shelves = new Shelf[SHELVES_NUMBER];

    public final HashMap<Coin, Integer> getCoins() {
        return coins;
    }

    public final void setShelves(final Shelf[] shelves) {
        this.shelves = shelves;
    }

    private void assertCoinNotNull(final Coin coin) throws StorageException {
        if (coin == null) {
            throw new StorageException("Coin can't be empty");
        }
    }

    public final int getCoinsNumber(final Coin coin) throws StorageException {
        assertCoinNotNull(coin);

        if (coins.containsKey(coin)) {
            return coins.get(coin);
        } else {
            return 0;
        }
    }

    public final void setParticularCoin(final Coin coin, final int quantity)
            throws StorageException {
        assertCoinNotNull(coin);

        if (quantity < 0) {
            throw new StorageException("Coin quantity cannot be negative");
        }

        coins.put(coin, quantity);
    }

    public final void addCoin(final Coin coin) throws StorageException {
        assertCoinNotNull(coin);

        if (coins.containsKey(coin)) {
            coins.put(coin, coins.get(coin) + 1);
        } else {
            coins.put(coin, 1);
        }
    }

    private void assertShelfNotNull(final Shelf shelf) throws StorageException {
        if (shelf == null) {
            throw new StorageException("Shelf can't be empty");
        }
    }

    private void assertShelfNumber(final int number) throws StorageException {
        if ((number < 0) || (number >= SHELVES_NUMBER)) {
            throw new StorageException("Wrong shelf number");
        }
    }

    public final void setShelf(final int number, final Shelf shelf)
            throws StorageException {
        assertShelfNumber(number);
        assertShelfNotNull(shelf);

        shelves[number] = shelf;
    }

    public final boolean isShelfSet(final int number)
            throws StorageException {
        assertShelfNumber(number);

        return (shelves[number] != null);
    }

    public final Shelf getShelf(final int number)
            throws StorageException {
        assertShelfNumber(number);

        if (!isShelfSet(number)) {
            throw new StorageException("Shelf is not set");
        }

        return shelves[number];
    }
}
