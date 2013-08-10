package com.riddimsoft;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.riddimsoft.exceptions.VendingMachineException;


public class VendingMachine extends ActionSupport {
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

    public final void setShelves(final ArrayList<Shelf> shelves) throws VendingMachineException {
        if (shelves == null) {
            throw new VendingMachineException("Shelves can not be null");
        }
        this.shelves = shelves;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
