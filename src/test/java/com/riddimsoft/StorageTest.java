package com.riddimsoft;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.riddimsoft.exceptions.BadPriceException;
import com.riddimsoft.exceptions.NonExistentCoinException;
import com.riddimsoft.exceptions.StorageException;

public class StorageTest {
    private static final int NUMBER_OF_ITEMS_TO_ADD = 5;
    private static final String PRODUCT_TYPE_1 = "Product example";
    private static final String PRODUCT_TYPE_2 = "Second product example";
    private static final float PRICE = 2.5f;

    @Test(expected = StorageException.class)
    public final void testSetNullCoin()
            throws StorageException, NonExistentCoinException {
        (new Storage()).setParticularCoin(null, 0);
    }

    @Test(expected = StorageException.class)
    public final void testSetNagativeNumberOfCoins()
            throws StorageException, NonExistentCoinException {
        (new Storage()).setParticularCoin(new Coin(Coin.getMinimalDenomination()), -1);
    }

    @Test
    public final void testSetAndAddCoinsAndCheckResults()
            throws StorageException, NonExistentCoinException {
        final Storage storage = new Storage();

        final Coin firstCoinToAdd = new Coin(Coin.getMinimalDenomination());
        final Coin secondCoinToAdd = new Coin(Coin.getPossibleValues().higher(firstCoinToAdd.
                getValue()));

        storage.setParticularCoin(firstCoinToAdd, NUMBER_OF_ITEMS_TO_ADD);
        storage.addCoin(firstCoinToAdd);
        storage.setParticularCoin(secondCoinToAdd, NUMBER_OF_ITEMS_TO_ADD);

        assertEquals(storage.getCoins().size(), 2);
        assertEquals(storage.getCoinsNumber(firstCoinToAdd), NUMBER_OF_ITEMS_TO_ADD + 1);
        assertEquals(storage.getCoinsNumber(secondCoinToAdd), NUMBER_OF_ITEMS_TO_ADD);
    }

    @Test
    public final void testAddZeroCoinsAndCheckResult()
            throws StorageException, NonExistentCoinException {
        final Storage storage = new Storage();

        final Coin coinToAdd = new Coin(Coin.getMinimalDenomination());

        storage.setParticularCoin(coinToAdd, 0);

        assertEquals(storage.getCoinsNumber(coinToAdd), 0);
    }

    @Test
    public final void testOverrideCoinsAndCheckResult()
            throws StorageException, NonExistentCoinException {
        final Storage storage = new Storage();

        final Coin coinToAdd = new Coin(Coin.getMinimalDenomination());

        storage.setParticularCoin(coinToAdd, NUMBER_OF_ITEMS_TO_ADD);
        storage.setParticularCoin(coinToAdd, NUMBER_OF_ITEMS_TO_ADD + 1);

        assertEquals(storage.getCoinsNumber(coinToAdd), NUMBER_OF_ITEMS_TO_ADD + 1);
    }

    @Test
    public final void testSetNumberAndZeroCoinsAndCheckResult()
            throws StorageException, NonExistentCoinException {
        final Storage storage = new Storage();

        final Coin coinToAdd = new Coin(Coin.getMinimalDenomination());

        storage.setParticularCoin(coinToAdd, NUMBER_OF_ITEMS_TO_ADD);
        storage.setParticularCoin(coinToAdd, 0);

        assertEquals(storage.getCoinsNumber(coinToAdd), 0);
    }

    @Test(expected = StorageException.class)
    public final void testSetNullProduct()
            throws StorageException {
        (new Storage()).setParticularProduct(null, 0);
    }

    @Test(expected = StorageException.class)
    public final void testSetNagativeNumberOfProduct()
            throws StorageException, BadPriceException {
        (new Storage()).setParticularProduct(new Product(new ProductType(PRODUCT_TYPE_1),
                new Price(PRICE)), -1);
    }

    @Test
    public final void testSetDifferentProductsAndCheckResults()
            throws StorageException, BadPriceException {
        final Storage storage = new Storage();

        final Product firstProductToAdd = new Product(new ProductType(PRODUCT_TYPE_1),
                new Price(PRICE));
        final Product secondProductToAdd = new Product(new ProductType(PRODUCT_TYPE_2),
                new Price(PRICE));

        storage.setParticularProduct(firstProductToAdd, NUMBER_OF_ITEMS_TO_ADD);
        storage.setParticularProduct(secondProductToAdd, NUMBER_OF_ITEMS_TO_ADD + 1);

        assertEquals(storage.getProducts().size(), 2);
        assertEquals(storage.getProductsNumber(firstProductToAdd), NUMBER_OF_ITEMS_TO_ADD);
        assertEquals(storage.getProductsNumber(secondProductToAdd), NUMBER_OF_ITEMS_TO_ADD + 1);
    }

    @Test
    public final void testAddZeroProductsAndCheckResult()
            throws StorageException, BadPriceException {
        final Storage storage = new Storage();

        final Product productToAdd = new Product(new ProductType(PRODUCT_TYPE_1), new Price(PRICE));

        storage.setParticularProduct(productToAdd, 0);

        assertEquals(storage.getProductsNumber(productToAdd), 0);
    }

    @Test
    public final void testOverrideProductAndCheckResult()
            throws StorageException, BadPriceException {
        final Storage storage = new Storage();

        final Product productToAdd = new Product(new ProductType(PRODUCT_TYPE_1), new Price(PRICE));

        storage.setParticularProduct(productToAdd, NUMBER_OF_ITEMS_TO_ADD + 1);
        storage.setParticularProduct(productToAdd, NUMBER_OF_ITEMS_TO_ADD);

        assertEquals(storage.getProductsNumber(productToAdd), NUMBER_OF_ITEMS_TO_ADD);
    }

    @Test
    public final void testSetNumberAndZeroProductsAndCheckResult()
            throws StorageException, BadPriceException {
        final Storage storage = new Storage();

        final Product productToAdd = new Product(new ProductType(PRODUCT_TYPE_1), new Price(PRICE));

        storage.setParticularProduct(productToAdd, NUMBER_OF_ITEMS_TO_ADD);
        storage.setParticularProduct(productToAdd, 0);

        assertEquals(storage.getProductsNumber(productToAdd), 0);
    }
}
