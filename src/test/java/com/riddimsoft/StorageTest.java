package com.riddimsoft;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.riddimsoft.exceptions.NonExistentCoinException;
import com.riddimsoft.exceptions.StorageException;

public class StorageTest {

    private static final int NUMBER_OF_COINS_TO_ADD = 5;

    @Test(expected = StorageException.class)
    public final void testAddNagativeNumberOfCoins()
            throws StorageException, NonExistentCoinException {
        (new Storage()).addCoins(new Coin(Coin.getMinimalDenomination()), -1);
    }

    @Test
    public final void testAddCoinsAndCheckResult()
            throws StorageException, NonExistentCoinException {
        final Storage storage = new Storage();

        final Coin firstCoinToAdd = new Coin(Coin.getMinimalDenomination());
        final Coin secondCoinToAdd = new Coin(Coin.getPossibleValues().higher(firstCoinToAdd.
                getValue()));

        storage.addCoins(firstCoinToAdd, NUMBER_OF_COINS_TO_ADD);
        storage.addCoins(firstCoinToAdd, 1);
        storage.addCoins(secondCoinToAdd, NUMBER_OF_COINS_TO_ADD);

        assertEquals((long) storage.getCoins().size(), 2);
        assertEquals((long) storage.getCoinsNumber(firstCoinToAdd), NUMBER_OF_COINS_TO_ADD + 1);
        assertEquals((long) storage.getCoinsNumber(secondCoinToAdd), NUMBER_OF_COINS_TO_ADD);
    }

    @Test
    public final void testAddZeroCoinsAndCheckResult()
            throws StorageException, NonExistentCoinException {
        final Storage storage = new Storage();

        final Coin coinToAdd = new Coin(Coin.getMinimalDenomination());

        storage.addCoins(coinToAdd, 0);

        assertEquals((long) storage.getCoinsNumber(coinToAdd), 0);
    }

    @Test
    public final void testAddNumberAndZeroCoinsAndCheckResult()
            throws StorageException, NonExistentCoinException {
        final Storage storage = new Storage();

        final Coin coinToAdd = new Coin(Coin.getMinimalDenomination());

        storage.addCoins(coinToAdd, NUMBER_OF_COINS_TO_ADD);
        storage.addCoins(coinToAdd, 0);

        assertEquals((long) storage.getCoinsNumber(coinToAdd), NUMBER_OF_COINS_TO_ADD);
    }
}
