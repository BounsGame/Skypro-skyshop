package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int PRICE = 109;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return name + ": фиксированная цена " + PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
