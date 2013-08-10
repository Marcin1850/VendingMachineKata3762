package com.riddimsoft;

import java.util.HashMap;

import com.riddimsoft.exceptions.PriceListException;

public class PriceList {
    private HashMap<Shelf, Price> list;

    public final HashMap<Shelf, Price> getList() {
        return list;
    }

    public final void setList(final HashMap<Shelf, Price> list) {
        this.list = list;
    }

    public final void addItem(final Shelf shelf, final Price price) throws PriceListException {
        if (list.containsKey(shelf)) {
            throw new PriceListException("Can't add same shelf");
        }

        list.put(shelf, price);
    }

    public final void updateItem(final Shelf shelf, final Price price) throws PriceListException {
        if (!list.containsKey(shelf)) {
            throw new PriceListException("Can't update non-existent shelf");
        }

        list.put(shelf, price);
    }
}
