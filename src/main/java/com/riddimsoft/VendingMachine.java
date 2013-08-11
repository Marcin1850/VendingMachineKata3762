package com.riddimsoft;

import com.opensymphony.xwork2.ActionSupport;


public class VendingMachine extends ActionSupport {
    private static final long serialVersionUID = 1L;

    private Storage storage;
    private String otherValue;

    public final Storage getStorage() {
        return storage;
    }

    public final void setStorage(final Storage storage) {
        this.storage = storage;
    }

    public final String getOtherValue() {
        return otherValue;
    }

    public final void setOtherValue(final String otherValue) {
        this.otherValue = otherValue;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
