package com.riddimsoft;

import java.util.HashMap;

import com.riddimsoft.exceptions.StorageException;

public class Storage {
    private final HashMap<Coin, Integer> coins = new HashMap<Coin, Integer>();
    private final HashMap<Product, Integer> products = new HashMap<Product, Integer>();

    public final HashMap<Coin, Integer> getCoins() {
        return coins;
    }

    private void checkForNullCoin(final Coin coin) throws StorageException {
        if (coin == null) {
            throw new StorageException("Coin can't be empty");
        }
    }

    public final int getCoinsNumber(final Coin coin) throws StorageException {
        checkForNullCoin(coin);

        if (coins.containsKey(coin)) {
            return coins.get(coin);
        } else {
            return 0;
        }
    }

    public final void setParticularCoin(final Coin coin, final int quantity)
            throws StorageException {
        checkForNullCoin(coin);

        if (quantity < 0) {
            throw new StorageException("Coin quantity cannot be negative");
        }

        coins.put(coin, quantity);
    }

    public final void addCoin(final Coin coin) throws StorageException {
        checkForNullCoin(coin);

        if (coins.containsKey(coin)) {
            coins.put(coin, coins.get(coin) + 1);
        } else {
            coins.put(coin, 1);
        }
    }

    public final HashMap<Product, Integer> getProducts() {
        return products;
    }

    private void checkForNullProduct(final Product product) throws StorageException {
        if (product == null) {
            throw new StorageException("Product can't be empty");
        }
    }

    public final int getProductsNumber(final Product product) throws StorageException {
        checkForNullProduct(product);

        if (products.containsKey(product)) {
            return products.get(product);
        } else {
            return 0;
        }
    }

    public final void setParticularProduct(final Product product, final int quantity)
            throws StorageException {
        checkForNullProduct(product);

        if (quantity < 0) {
            throw new StorageException("Product quantity cannot be negative");
        }

        if (quantity == 0) {
            products.remove(product);
        } else {
            products.put(product, quantity);
        }
    }
}
