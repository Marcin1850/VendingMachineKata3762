package com.riddimsoft;

import java.util.HashMap;

import com.riddimsoft.exceptions.PriceListException;


public class PriceList {
    private final HashMap<ProductType, Price> list = new HashMap<ProductType, Price>();

    private void assertProductTypeNotNull(final ProductType productType)
            throws PriceListException {
        if (productType == null) {
            throw new PriceListException("Product type can't be empty");
        }
    }

    private void assertPriceNotNull(final Price price) throws PriceListException {
        if (price == null) {
            throw new PriceListException("Price can't be empty");
        }
    }

    public final void setPrice(final ProductType productType, final Price price)
            throws PriceListException {
        assertProductTypeNotNull(productType);
        assertPriceNotNull(price);

        list.put(productType, price);
    }

    public final boolean isPriceSet(final ProductType productType) throws PriceListException {
        assertProductTypeNotNull(productType);

        return list.containsKey(productType);
    }

    public final Price getPrice(final ProductType productType) throws PriceListException {
        assertProductTypeNotNull(productType);

        if (!isPriceSet(productType)) {
            throw new PriceListException("No price to get");
        }

        return list.get(productType);
    }

    // TODO - can't do it without synchronization with existing products
    /*public final void removePrice(final ProductType productType) throws PriceListException {
        assertProductTypeNotNull(productType);

        if (!isPriceSet(productType)) {
            throw new PriceListException("No price to remove");
        }

        list.remove(productType);
    }*/
}
