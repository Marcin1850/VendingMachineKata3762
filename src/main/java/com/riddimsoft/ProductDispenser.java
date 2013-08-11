package com.riddimsoft;

import com.riddimsoft.exceptions.ProductDispenserException;
import com.riddimsoft.exceptions.ShelfException;
import com.riddimsoft.exceptions.StorageException;


public class ProductDispenser {
    private final Storage storage;

    public ProductDispenser(final Storage storage) throws ProductDispenserException {
        assertStorageNotNull(storage);

        this.storage = storage;
    }

    public final boolean getProductFromStorage(final int shelfNumber)
            throws ProductDispenserException, StorageException, ShelfException {
        if (!storage.isShelfSet(shelfNumber)) {
            return false;
        }
        final Shelf shelf = storage.getShelf(shelfNumber);

        if (shelf.getQuantity() < 1) {
            return false;
        }

        shelf.setQuantity(shelf.getQuantity() - 1);

        return true;
    }

    private void assertStorageNotNull(final Storage storage)
            throws ProductDispenserException {
        if (storage == null) {
            throw new ProductDispenserException("Storage cannot be null");
        }
    }
}
