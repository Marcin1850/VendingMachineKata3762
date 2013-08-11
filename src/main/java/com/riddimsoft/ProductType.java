package com.riddimsoft;

import com.riddimsoft.exceptions.ProductTypeException;


public final class ProductType {
    private String name;

    public ProductType(final String name) throws ProductTypeException {
        assertNameNotEmpty(name);

        this.name = name;
    }

    private void assertNameNotEmpty(final String name)
            throws ProductTypeException {
        if ((name == null) || "".equals(name)) {
            throw new ProductTypeException("Name cannot be null");
        }
    }

    public void setName(final String name) throws ProductTypeException {
        assertNameNotEmpty(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
