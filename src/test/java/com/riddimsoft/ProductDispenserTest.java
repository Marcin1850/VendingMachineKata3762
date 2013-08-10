package com.riddimsoft;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.riddimsoft.exceptions.BadPriceException;
import com.riddimsoft.exceptions.CoinDispenserException;
import com.riddimsoft.exceptions.NonExistentCoinException;
import com.riddimsoft.exceptions.ProductDispenserException;
import com.riddimsoft.exceptions.ProductException;
import com.riddimsoft.exceptions.ProductTypeException;
import com.riddimsoft.exceptions.StorageException;

public class ProductDispenserTest {
    private static final int NUMBER_OF_PRODUCTS_TO_ADD = 3;

    @Test(expected = ProductDispenserException.class)
    public final void testGetNonExistentProductFromStorage()
            throws CoinDispenserException, NonExistentCoinException, ProductException,
            ProductTypeException, BadPriceException, ProductDispenserException, StorageException {
        final Storage storage = new Storage();
        final ProductDispenser productDispenser = new ProductDispenser(storage);
        final Product product = new Product(new ProductType(TestConstants.PRODUCT_TYPE_1),
                new Price(TestConstants.PRODUCT_PRICE));

        productDispenser.getProductFromStorage(product);
    }

    @Test
    public final void testGetExistentProductFromStorageAndCheckState()
            throws CoinDispenserException, NonExistentCoinException, ProductException,
            ProductTypeException, BadPriceException, ProductDispenserException, StorageException {
        final Storage storage = new Storage();
        final ProductDispenser productDispenser = new ProductDispenser(storage);
        final Product product = new Product(new ProductType(TestConstants.PRODUCT_TYPE_1),
                new Price(TestConstants.PRODUCT_PRICE));

        storage.setParticularProduct(product, NUMBER_OF_PRODUCTS_TO_ADD);

        productDispenser.getProductFromStorage(product);

        assertEquals(NUMBER_OF_PRODUCTS_TO_ADD - 1, storage.getProductsQuantity(product));
    }
}
