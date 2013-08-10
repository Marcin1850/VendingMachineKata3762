package com.riddimsoft;

import com.riddimsoft.exceptions.ProductDispenserException;
import com.riddimsoft.exceptions.StorageException;


public class ProductDispenser {
    private final Storage storage;

    public ProductDispenser(final Storage storage) throws ProductDispenserException {
        assertStorageNotNull(storage);

        this.storage = storage;
    }

    public final void getProductFromStorage(final Product product)
            throws ProductDispenserException, StorageException {
        assertProductNotNull(product);

        final int productsQuantity = storage.getProductsQuantity(product);

        if (productsQuantity == 0) {
            throw new ProductDispenserException("No such product");
        }

        storage.setParticularProduct(product, productsQuantity - 1);
    }

    private void assertStorageNotNull(final Storage storage)
            throws ProductDispenserException {
        if (storage == null) {
            throw new ProductDispenserException("Storage cannot be null");
        }
    }

    private void assertProductNotNull(final Product product)
            throws ProductDispenserException {
        if (product == null) {
            throw new ProductDispenserException("Product cannot be null");
        }
    }
}
