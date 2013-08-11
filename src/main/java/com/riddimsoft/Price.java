package com.riddimsoft;

import com.riddimsoft.exceptions.BadPriceException;


public final class Price {
    private float value;

    public Price(final float value) throws BadPriceException {
        if (!Coin.canExpressValueWithAvailableDenominations(value)) {
            throw new BadPriceException();
        }

        this.value = value;
    }

    // TODO - setter don't calls Coin.canExpressValueWithAvailableDenominations()
    public void setValue(final float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
