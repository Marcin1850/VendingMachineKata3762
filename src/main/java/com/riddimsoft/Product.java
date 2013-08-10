package com.riddimsoft;

public class Product {
    private final ProductType productType;
    private final Price price;

    public Product(final ProductType productType, final Price price) {
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
