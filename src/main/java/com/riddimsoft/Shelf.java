package com.riddimsoft;

import com.riddimsoft.exceptions.BadShelfNumberException;
import com.riddimsoft.exceptions.ShelfException;

public class Shelf {
    private int number;
    private Product product;

    public Shelf(final int number, final Product product)
            throws BadShelfNumberException, ShelfException {
        assertShelfNumber(number);
        assertProductNotNull(product);

        this.number = number;
        this.product = product;
    }

    private void assertShelfNumber(final int number)
            throws BadShelfNumberException {
        if (number <= 0) {
            throw new BadShelfNumberException();
        }
    }

    private void assertProductNotNull(final Product product)
            throws ShelfException {
        if (product == null) {
            throw new ShelfException("Product cannot be null");
        }
    }

    public final int getNumber() {
        return number;
    }

    public final void setNumber(final int number) throws BadShelfNumberException {
        assertShelfNumber(number);

        this.number = number;
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(final Product product) throws ShelfException {
        assertProductNotNull(product);

        this.product = product;
    }
}
