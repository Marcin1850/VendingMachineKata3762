package com.riddimsoft;

public class Product {
    private ProductType productType;
    private int quantity;

    public final ProductType getProductType() {
        return productType;
    }
    public final void setProductType(final ProductType productType) {
        this.productType = productType;
    }
    public final int getQuantity() {
        return quantity;
    }
    public final void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}
