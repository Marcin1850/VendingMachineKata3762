package com.riddimsoft;

import org.junit.Test;

import com.riddimsoft.exceptions.BadPriceException;
import com.riddimsoft.exceptions.BadShelfNumberException;
import com.riddimsoft.exceptions.ProductException;
import com.riddimsoft.exceptions.ProductTypeException;
import com.riddimsoft.exceptions.ShelfException;

public class ShelfTest {
    @Test(expected = BadShelfNumberException.class)
    public final void testShelfCreateWithNegativeNumber()
            throws BadShelfNumberException, ShelfException, ProductException, ProductTypeException,
            BadPriceException {
        new Shelf(-1, new Product(new ProductType(TestConstants.PRODUCT_TYPE_1),
                new Price(TestConstants.PRODUCT_PRICE)));
    }

    @Test(expected = BadShelfNumberException.class)
    public final void testShelfCreateWithZeroNumber()
            throws BadShelfNumberException, ShelfException, ProductException, ProductTypeException,
            BadPriceException {
        new Shelf(0, new Product(new ProductType(TestConstants.PRODUCT_TYPE_1),
                new Price(TestConstants.PRODUCT_PRICE)));
    }
}
