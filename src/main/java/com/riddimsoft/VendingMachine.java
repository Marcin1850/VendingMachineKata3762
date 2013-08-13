package com.riddimsoft;

import java.util.ArrayList;


public class VendingMachine {
    private Storage storage;
    private PriceList priceList;
    private Display display;
    private CoinDispenser coinDispenser;
    private int selectedShelf = 0;
    private float insertedCoinValue = 0f;
    private ArrayList<String> returnedCoins = new ArrayList<String>();


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

    public final int getSelectedShelf() {
        return selectedShelf;
    }

    public final void setSelectedShelf(final int selectedShelf) {
        this.selectedShelf = selectedShelf;
    }

    public final float getInsertedCoinValue() {
        return insertedCoinValue;
    }

    public final void setInsertedCoinValue(final float insertedCoinValue) {
        this.insertedCoinValue = insertedCoinValue;
    }

    public final ArrayList<String> getReturnedCoins() {
        return returnedCoins;
    }

    private void resetReturnedItems() {
        returnedCoins.clear();
    }

    public final String cancelOrder() throws Exception {
        returnedCoins = coinDispenser.resetAndReturnCoins();

        display.resetValue();

        selectedShelf = 0;

        return "success";
    }

    public final String execute() throws Exception {
        resetReturnedItems();

        if (insertedCoinValue != 0f) {
            display.setValue(coinDispenser.addCoinAndReturnSum(new Coin(insertedCoinValue)));

            insertedCoinValue = 0f;
        }

        return "success";
    }
}
