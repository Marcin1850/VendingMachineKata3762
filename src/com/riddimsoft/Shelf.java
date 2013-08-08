package com.riddimsoft;

public class Shelf {
    private String productName;
    private int quantity;

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(final String productName) {
        this.productName = productName;
    }

    public final int getQuantity() {
        return quantity;
    }

    public final void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}
