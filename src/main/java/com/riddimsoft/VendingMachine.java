package com.riddimsoft;

import java.util.ArrayList;

import com.riddimsoft.exceptions.CoinDispenserException;
import com.riddimsoft.exceptions.NoProperCoinsException;
import com.riddimsoft.exceptions.ProductDispenserException;
import com.riddimsoft.exceptions.ShelfException;
import com.riddimsoft.exceptions.StorageException;


public class VendingMachine {
    private static final String CANT_SPEND_CHANGE_MESSAGE = "SORRY! CAN'T SPEND CHANGE!";

    private Storage storage;
    private PriceList priceList;
    private Display display;
    private CoinDispenser coinDispenser;
    private ProductDispenser productDispenser;

    private int selectedShelf = 0;
    private float insertedCoinValue = 0f;

    private ArrayList<String> returnedCoins = new ArrayList<String>();
    private String returnedProduct = "";


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

    public final void setProductDispenser(final ProductDispenser productDispenser) {
        this.productDispenser = productDispenser;
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

    public final String getReturnedProduct() {
        return returnedProduct;
    }

    private void resetReturnedItems() {
        returnedCoins.clear();
        returnedProduct = "";
    }

    private ArrayList<String> convertCoinsListToStringList(final ArrayList<Coin> coins) {
        final ArrayList<String> retValues = new ArrayList<String>();
        for (final Coin coin : coins) {
            retValues.add(String.format("%.2f", coin.getValue()));
        }

        return retValues;
    }

    public final String cancelOrder() throws Exception {
        returnedCoins = convertCoinsListToStringList(coinDispenser.resetAndReturnCoins());

        display.resetValue();

        selectedShelf = 0;

        return "success";
    }

    public final String throwCoin() throws Exception {
        final Float coinsAmount = coinDispenser.addCoinAndReturnSum(new Coin(insertedCoinValue));
        insertedCoinValue = 0f;

        final ProductType selectedProductType =
                storage.getShelf(selectedShelf - 1).getProduct().getProductType();

        final Float selectedProductPrice = priceList.getPrice(selectedProductType).getValue();

        if (coinsAmount >= selectedProductPrice) {
            bringOutProductAndChange(coinsAmount, selectedProductType, selectedProductPrice);
        } else {
            display.setValue(coinsAmount);
        }

        return "success";
    }

    private void bringOutProductAndChange(final Float coinsAmount,
            final ProductType selectedProductType, final Float selectedProductPrice)
            throws NoProperCoinsException, CoinDispenserException, StorageException,
            ProductDispenserException, ShelfException {
        final ArrayList<Coin> coinsToReturn = new ArrayList<Coin>();
        final boolean canSpendChange = coinDispenser.getChangeFromStorage(coinsToReturn,
                coinsAmount - selectedProductPrice);

        if (canSpendChange) {
            returnedProduct = selectedProductType.getName();
            returnedCoins = convertCoinsListToStringList(coinsToReturn);

            productDispenser.getProductFromStorage(selectedShelf - 1);
            coinDispenser.resetAndAddCoinsToStorage();
        } else {
            returnedProduct = CANT_SPEND_CHANGE_MESSAGE;

            returnedCoins = convertCoinsListToStringList(coinDispenser.resetAndReturnCoins());
        }

        selectedShelf = 0;
        display.resetValue();
    }

    public final String execute() throws Exception {
        resetReturnedItems();

        return "success";
    }
}
