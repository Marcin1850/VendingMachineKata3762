package com.riddimsoft;

import com.riddimsoft.exceptions.NoPriceException;
import com.riddimsoft.exceptions.PriceListException;
import com.riddimsoft.exceptions.ProductException;

public class Product {
    private final ProductType productType;

    public Product(final ProductType productType, final PriceList priceList)
            throws ProductException, PriceListException, NoPriceException {
        if (productType == null) {
            throw new ProductException("Product type cannot be null");
        }

        if (!priceList.isPriceSet(productType)) {
            throw new NoPriceException();
        }

        this.productType = productType;
    }

    public final ProductType getProductType() {
        return productType;
    }
}
