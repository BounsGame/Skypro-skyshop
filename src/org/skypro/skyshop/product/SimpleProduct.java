package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(int price, String name) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("цена должна быть больше нуля");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + price;
    }

}
