package com.riddimsoft;

import com.riddimsoft.exceptions.ProductTypeException;

public final class ProductType {
    private final String name;

    public ProductType(final String name) throws ProductTypeException {
        if (name == null) {
            throw new ProductTypeException("Name cannot be null");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
