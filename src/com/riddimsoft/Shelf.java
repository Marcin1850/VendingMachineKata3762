package com.riddimsoft;

public class Shelf {
    private int number;
    private ProductType productType;
    private int quantity;

    public final int getNumber() {
        return number;
    }

    public final void setNumber(final int number) {
        this.number = number;
    }

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
