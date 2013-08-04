package com.riddimsoft;

import com.opensymphony.xwork2.ActionSupport;


public class VendingMachineAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    private String name;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
