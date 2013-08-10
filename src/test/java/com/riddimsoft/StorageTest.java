package com.riddimsoft;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.riddimsoft.exceptions.BadPriceException;
import com.riddimsoft.exceptions.NonExistentCoinException;
import com.riddimsoft.exceptions.ProductException;
import com.riddimsoft.exceptions.ProductTypeException;
import com.riddimsoft.exceptions.StorageException;

public class StorageTest {
    private static final int NUMBER_OF_ITEMS_TO_ADD = 5;

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

        assertEquals(2, storage.getCoins().size());
        assertEquals(NUMBER_OF_ITEMS_TO_ADD + 1, storage.getCoinsNumber(firstCoinToAdd));
        assertEquals(NUMBER_OF_ITEMS_TO_ADD, storage.getCoinsNumber(secondCoinToAdd));
    }

    @Test
    public final void testAddZeroCoinsAndCheckResult()
            throws StorageException, NonExistentCoinException {
        final Storage storage = new Storage();

        final Coin coinToAdd = new Coin(Coin.getMinimalDenomination());

        storage.setParticularCoin(coinToAdd, 0);

        assertEquals(0, storage.getCoinsNumber(coinToAdd));
    }

    @Test
    public final void testOverrideCoinsAndCheckResult()
            throws StorageException, NonExistentCoinException {
        final Storage storage = new Storage();

        final Coin coinToAdd = new Coin(Coin.getMinimalDenomination());

        storage.setParticularCoin(coinToAdd, NUMBER_OF_ITEMS_TO_ADD);
        storage.setParticularCoin(coinToAdd, NUMBER_OF_ITEMS_TO_ADD + 1);

        assertEquals(NUMBER_OF_ITEMS_TO_ADD + 1, storage.getCoinsNumber(coinToAdd));
    }

    @Test
    public final void testSetNumberAndZeroCoinsAndCheckResult()
            throws StorageException, NonExistentCoinException {
        final Storage storage = new Storage();

        final Coin coinToAdd = new Coin(Coin.getMinimalDenomination());

        storage.setParticularCoin(coinToAdd, NUMBER_OF_ITEMS_TO_ADD);
        storage.setParticularCoin(coinToAdd, 0);

        assertEquals(0, storage.getCoinsNumber(coinToAdd));
    }

    @Test(expected = StorageException.class)
    public final void testSetNullProduct()
            throws StorageException {
        (new Storage()).setParticularProduct(null, 0);
    }

    @Test(expected = StorageException.class)
    public final void testSetNagativeNumberOfProduct()
            throws StorageException, BadPriceException, ProductTypeException, ProductException {
        (new Storage()).setParticularProduct(new Product(
                new ProductType(TestConstants.PRODUCT_TYPE_1),
                new Price(TestConstants.PRODUCT_PRICE)), -1);
    }

    @Test
    public final void testSetDifferentProductsAndCheckResults()
            throws StorageException, BadPriceException, ProductTypeException, ProductException {
        final Storage storage = new Storage();

        final Product firstProductToAdd = new Product(new ProductType(
                TestConstants.PRODUCT_TYPE_1), new Price(TestConstants.PRODUCT_PRICE));
        final Product secondProductToAdd = new Product(new ProductType(
                TestConstants.PRODUCT_TYPE_2), new Price(TestConstants.PRODUCT_PRICE));

        storage.setParticularProduct(firstProductToAdd, NUMBER_OF_ITEMS_TO_ADD);
        storage.setParticularProduct(secondProductToAdd, NUMBER_OF_ITEMS_TO_ADD + 1);

        assertEquals(2, storage.getProducts().size());
        assertEquals(NUMBER_OF_ITEMS_TO_ADD, storage.getProductsNumber(firstProductToAdd));
        assertEquals(NUMBER_OF_ITEMS_TO_ADD + 1, storage.getProductsNumber(secondProductToAdd));
    }

    @Test
    public final void testAddZeroProductsAndCheckResult()
            throws StorageException, BadPriceException, ProductTypeException, ProductException {
        final Storage storage = new Storage();

        final Product productToAdd = new Product(new ProductType(TestConstants.PRODUCT_TYPE_1),
                new Price(TestConstants.PRODUCT_PRICE));

        storage.setParticularProduct(productToAdd, 0);

        assertEquals(0, storage.getProductsNumber(productToAdd));
    }

    @Test
    public final void testOverrideProductAndCheckResult()
            throws StorageException, BadPriceException, ProductTypeException, ProductException {
        final Storage storage = new Storage();

        final Product productToAdd = new Product(new ProductType(TestConstants.PRODUCT_TYPE_1),
                new Price(TestConstants.PRODUCT_PRICE));

        storage.setParticularProduct(productToAdd, NUMBER_OF_ITEMS_TO_ADD + 1);
        storage.setParticularProduct(productToAdd, NUMBER_OF_ITEMS_TO_ADD);

        assertEquals(NUMBER_OF_ITEMS_TO_ADD, storage.getProductsNumber(productToAdd));
    }

    @Test
    public final void testSetNumberAndZeroProductsAndCheckResult()
            throws StorageException, BadPriceException, ProductTypeException, ProductException {
        final Storage storage = new Storage();

        final Product productToAdd = new Product(new ProductType(TestConstants.PRODUCT_TYPE_1),
                new Price(TestConstants.PRODUCT_PRICE));

        storage.setParticularProduct(productToAdd, NUMBER_OF_ITEMS_TO_ADD);
        storage.setParticularProduct(productToAdd, 0);

        assertEquals(0, storage.getProductsNumber(productToAdd));
    }
}
