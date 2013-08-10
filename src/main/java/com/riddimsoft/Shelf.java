package com.riddimsoft;

public class Shelf {
    private int number;
    private Product product;

    public Shelf(final int number, final Product product) {
        this.number = number;
        this.product = product;
    }

    public final int getNumber() {
        return number;
    }

    public final void setNumber(final int number) {
        this.number = number;
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(final Product product) {
        this.product = product;
    }
}
