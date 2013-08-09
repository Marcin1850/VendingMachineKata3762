package com.riddimsoft;

import com.riddimsoft.exceptions.BadPriceException;

public final class Price {
    private static final double MAX_ALLOWED_FLOAT_DIFFERENCE = 0.00001;

    private final float value;

    public Price(final float value) throws BadPriceException {
        if ((value / Coin.getMinimalDenomination()) > MAX_ALLOWED_FLOAT_DIFFERENCE) {
            throw new BadPriceException();
        }

        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
