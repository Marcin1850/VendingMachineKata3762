package com.riddimsoft;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.riddimsoft.exceptions.NonExistentCoinException;
import com.riddimsoft.exceptions.StorageException;

public class StorageTest {

    private static final int NUMBER_OF_COINS_TO_ADD = 5;

    @Test(expected = StorageException.class)
    public void testAddNagativeNumberOfCoins() throws StorageException, NonExistentCoinException {
        Storage.getInstance().addCoins(new Coin(Coin.getMinimalDenomination()), -1);
    }

    @Test
    public void testAddCoins() throws StorageException, NonExistentCoinException {
        final Storage storage = Storage.getInstance();

        final Coin coinToAdd = new Coin(Coin.getMinimalDenomination());

        storage.addCoins(coinToAdd, NUMBER_OF_COINS_TO_ADD);
        storage.addCoins(coinToAdd, 1);

        assertEquals((long) storage.getCoins().get(coinToAdd), NUMBER_OF_COINS_TO_ADD + 1);
    }

    @Test
    public void testAddZeroCoins() throws StorageException, NonExistentCoinException {
        final Storage storage = Storage.getInstance();

        final Coin coinToAdd = new Coin(Coin.getMinimalDenomination());

        storage.addCoins(coinToAdd, NUMBER_OF_COINS_TO_ADD);
        storage.addCoins(coinToAdd, 0);

        assertEquals((long) storage.getCoins().get(coinToAdd), NUMBER_OF_COINS_TO_ADD);
    }
}
