package com.riddimsoft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.riddimsoft.exceptions.ProductDispenserException;
import com.riddimsoft.exceptions.ShelfException;
import com.riddimsoft.exceptions.StorageException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ProductDispenserTest {
    @Autowired
    private final Storage storage = null;
    @Autowired
    private final ProductDispenser productDispenser = null;
    @Autowired
    private final Shelf shelf = null;

    @Test
    public final void testGetNonExistentShelfFromStorage()
            throws ProductDispenserException, StorageException, ShelfException {
        assertFalse(productDispenser.getProductFromStorage(0));
    }

    @Test
    public final void testGetExistentProductFromStorageAndCheckQuantityInStorage()
            throws StorageException, ProductDispenserException, ShelfException {
        storage.setShelf(1, shelf);

        assertTrue(productDispenser.getProductFromStorage(1));

        assertEquals(1, storage.getShelf(1).getQuantity());
    }
}
