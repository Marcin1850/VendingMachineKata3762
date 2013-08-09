package com.riddimsoft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.riddimsoft.exceptions.BadPriceException;

public class PriceTest {
    private static final double FLOAT_COMPARISON_DELTA = 0.001;
    private static final int GREATER_VALUE_MULTIPLIER = 25;
    private static final double BAD_VALUE_MULTIPLIER = 0.5;


    @Test
    public final void testPriceCreateSmallest() {
        Price price;
        try {
            price = new Price(Coin.getMinimalDenomination());

            assertEquals(Coin.getMinimalDenomination(), price.getValue(), FLOAT_COMPARISON_DELTA);
        } catch (final BadPriceException e) {
            fail("BadPriceException thrown");
        }
    }

    @Test
    public final void testPriceCreateGreater() {
        Price price;

        final float value = Coin.getMinimalDenomination() * GREATER_VALUE_MULTIPLIER;
        try {
            price = new Price(value);

            assertEquals(value, price.getValue(), FLOAT_COMPARISON_DELTA);
        } catch (final BadPriceException e) {
            fail("BadPriceException thrown");
        }
    }

    @Test(expected = BadPriceException.class)
    public final void testPriceCreateBad() throws BadPriceException {
        new Price((float) (Coin.getMinimalDenomination() * BAD_VALUE_MULTIPLIER));
    }
}
