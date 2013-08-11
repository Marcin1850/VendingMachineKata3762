package com.riddimsoft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.riddimsoft.exceptions.NoPriceException;
import com.riddimsoft.exceptions.PriceListException;
import com.riddimsoft.exceptions.ProductException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ProductTest {

    @Autowired
    private final ProductType productType1 = null;
    @Autowired
    private final ProductType productType2 = null;
    @Autowired
    private final PriceList priceList = null;

    @Test
    public final void testProductCreationSuccesful()
            throws ProductException, PriceListException, NoPriceException {
        new Product(productType1, priceList);
    }

    @Test(expected = NoPriceException.class)
    public final void testProductCreationFail()
            throws ProductException, PriceListException, NoPriceException {
        new Product(productType2, priceList);
    }
}
