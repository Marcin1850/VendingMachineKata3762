package com.riddimsoft;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;


public class VendingMachineAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    private ArrayList<Shelf> shelves;
    private String otherValue;

    public final String getOtherValue() {
        return otherValue;
    }

    public final void setOtherValue(final String otherValue) {
        this.otherValue = otherValue;
    }

    public final ArrayList<Shelf> getShelves() {
        return shelves;
    }

    public final void setShelves(final ArrayList<Shelf> shelves) {
        this.shelves = shelves;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
