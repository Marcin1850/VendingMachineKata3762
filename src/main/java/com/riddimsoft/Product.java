package com.riddimsoft;

import com.riddimsoft.exceptions.ProductException;

public class Product {
    private final ProductType productType;
    private final Price price;

    public Product(final ProductType productType, final Price price) throws ProductException {
        if (productType == null) {
            throw new ProductException("Product type cannot be null");
        }
        if (price == null) {
            throw new ProductException("Price cannot be null");
        }

        this.productType = productType;
        this.price = price;
    }

    public final ProductType getProductType() {
        return productType;
    }

    public final Price getPrice() {
        return price;
    }
}
