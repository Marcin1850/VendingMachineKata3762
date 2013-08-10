package com.riddimsoft;

import java.util.ArrayList;

import com.riddimsoft.exceptions.PriceListException;

public class PriceList {
    private ArrayList<Shelf> shelves;

    public final ArrayList<Shelf> getShelves() {
        return shelves;
    }

    public final void setShelves(final ArrayList<Shelf> shelves) throws PriceListException {
        if (shelves == null) {
            throw new PriceListException("Shelves cannot be null");
        }

        this.shelves = shelves;
    }
}
