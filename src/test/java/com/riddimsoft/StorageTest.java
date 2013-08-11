package com.riddimsoft;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.riddimsoft.exceptions.BadPriceException;
import com.riddimsoft.exceptions.NonExistentCoinException;
import com.riddimsoft.exceptions.ProductException;
import com.riddimsoft.exceptions.ProductTypeException;
import com.riddimsoft.exceptions.StorageException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class StorageTest {
    private static final int NUMBER_OF_ITEMS_TO_ADD = 5;

    @Autowired
    private final Storage storage = null;
    @Autowired
    private final Shelf shelf1 = null;
    @Autowired
    private final Shelf shelf2 = null;

    @Test(expected = StorageException.class)
    public final void testSetNullCoin()
            throws StorageException, NonExistentCoinException {
        storage.setParticularCoin(null, 0);
    }

    @Test(expected = StorageException.class)
    public final void testSetNagativeNumberOfCoins()
            throws StorageException, NonExistentCoinException {
        storage.setParticularCoin(new Coin(Coin.getMinimalDenomination()), -1);
    }

    @Test
    public final void testSetAndAddCoinsAndCheckResults()
            throws StorageException, NonExistentCoinException {
        final Coin firstCoinToAdd = new Coin(Coin.getMinimalDenomination());
        final Coin secondCoinToAdd = new Coin(Coin.getPossibleValues().higher(firstCoinToAdd.
                getValue()));

        storage.setParticularCoin(firstCoinToAdd, NUMBER_OF_ITEMS_TO_ADD);
        storage.addCoin(firstCoinToAdd);
        storage.setParticularCoin(secondCoinToAdd, NUMBER_OF_ITEMS_TO_ADD);

        assertEquals(2, storage.getCoins().size());
        assertEquals(NUMBER_OF_ITEMS_TO_ADD + 1, storage.getCoinsNumber(firstCoinToAdd));
        assertEquals(NUMBER_OF_ITEMS_TO_ADD, storage.getCoinsNumber(secondCoinToAdd));
    }

    @Test
    public final void testAddZeroCoinsAndCheckResult()
            throws StorageException, NonExistentCoinException {
        final Coin coinToAdd = new Coin(Coin.getMinimalDenomination());

        storage.setParticularCoin(coinToAdd, 0);

        assertEquals(0, storage.getCoinsNumber(coinToAdd));
    }

    @Test
    public final void testOverrideCoinsAndCheckResult()
            throws StorageException, NonExistentCoinException {
        final Coin coinToAdd = new Coin(Coin.getMinimalDenomination());

        storage.setParticularCoin(coinToAdd, NUMBER_OF_ITEMS_TO_ADD);
        storage.setParticularCoin(coinToAdd, NUMBER_OF_ITEMS_TO_ADD + 1);

        assertEquals(NUMBER_OF_ITEMS_TO_ADD + 1, storage.getCoinsNumber(coinToAdd));
    }

    @Test
    public final void testSetNumberAndZeroCoinsAndCheckResult()
            throws StorageException, NonExistentCoinException {
        final Coin coinToAdd = new Coin(Coin.getMinimalDenomination());

        storage.setParticularCoin(coinToAdd, NUMBER_OF_ITEMS_TO_ADD);
        storage.setParticularCoin(coinToAdd, 0);

        assertEquals(0, storage.getCoinsNumber(coinToAdd));
    }

    @Test(expected = StorageException.class)
    public final void testSetNullShelf()
            throws StorageException {
        storage.setShelf(0, null);
    }

    @Test(expected = StorageException.class)
    public final void testSetNegativeShelfNumber()
            throws StorageException {
        storage.setShelf(-1, shelf1);
    }

    @Test
    public final void testSetDifferentShelvesAndCheckResults()
            throws StorageException, BadPriceException, ProductTypeException, ProductException {
        storage.setShelf(0, shelf1);
        storage.setShelf(1, shelf2);

        assertEquals(shelf1, storage.getShelf(0));
        assertEquals(shelf2, storage.getShelf(1));
    }

    @Test
    public final void testOverrideProductAndCheckResult()
            throws StorageException, BadPriceException, ProductTypeException, ProductException {
        storage.setShelf(0, shelf1);
        storage.setShelf(0, shelf2);

        assertEquals(shelf2, storage.getShelf(0));
    }
}
