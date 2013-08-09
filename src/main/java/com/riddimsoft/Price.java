package com.riddimsoft;

import com.riddimsoft.exceptions.BadPriceException;

public final class Price {
    private final float value;

    public Price(final float value) throws BadPriceException {
        if (!Coin.canExpressValueWithAvailableDenominations(value)) {
            throw new BadPriceException();
        }

        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
