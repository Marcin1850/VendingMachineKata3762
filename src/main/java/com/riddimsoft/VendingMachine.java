package com.riddimsoft;


public class VendingMachine {
    private static final long serialVersionUID = 1L;

    private Storage storage;
    private PriceList priceList;
    private Display display;
    private CoinDispenser coinDispenser;
    private float insertedCoinValue = 0f;


    public final Storage getStorage() {
        return storage;
    }

    public final void setStorage(final Storage storage) {
        this.storage = storage;
    }

    public final PriceList getPriceList() {
        return priceList;
    }

    public final void setPriceList(final PriceList priceList) {
        this.priceList = priceList;
    }

    public final Display getDisplay() {
        return display;
    }

    public final void setDisplay(final Display display) {
        this.display = display;
    }

    public final void setCoinDispenser(final CoinDispenser coinDispenser) {
        this.coinDispenser = coinDispenser;
    }

    public final float getInsertedCoinValue() {
        return insertedCoinValue;
    }

    public final void setInsertedCoinValue(final float insertedCoinValue) {
        this.insertedCoinValue = insertedCoinValue;
    }

    public final String execute() throws Exception {
        if (insertedCoinValue != 0f) {
            display.addValue(coinDispenser.addCoinAndReturnSum(new Coin(insertedCoinValue)));

            insertedCoinValue = 0f;
        }

        return "success";
    }
}
