package com.riddimsoft;

import java.util.ArrayList;
import java.util.HashMap;

public class PriceList {
    private ArrayList<Shelf> shelves;

    public final ArrayList<Shelf> getShelves() {
        return shelves;
    }

    public final void setShelves(final ArrayList<Shelf> shelves) {
        this.shelves = shelves;
    }
}
