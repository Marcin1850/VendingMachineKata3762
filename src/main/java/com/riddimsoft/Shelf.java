package com.riddimsoft;

import com.riddimsoft.exceptions.ShelfException;

public class Shelf {
    private Product product;
    private int quantity;

    public Shelf(final Product product, final int quantity) throws ShelfException {
        assertProductNotNull(product);
        assertProductQuantity(quantity);

        this.product = product;
        this.quantity = quantity;
    }

    private void assertProductQuantity(final int quantity) throws ShelfException {
        if (quantity < 0) {
            throw new ShelfException("Quantiy cannot be negative");
        }
    }

    private void assertProductNotNull(final Product product)
            throws ShelfException {
        if (product == null) {
            throw new ShelfException("Product cannot be null");
        }
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(final Product product) throws ShelfException {
        assertProductNotNull(product);

        this.product = product;
    }

    public final int getQuantity() {
        return quantity;
    }

    public final void setQuantity(final int quantity) throws ShelfException {
        assertProductQuantity(quantity);

        this.quantity = quantity;
    }
}
