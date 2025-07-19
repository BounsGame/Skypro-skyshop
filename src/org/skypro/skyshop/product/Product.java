package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product implements Searchable {
    protected String name;


    public Product(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("название не может быть пустым");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String searchTerm() {
        return "Тип PRODUCT, название " + name;
    }

    @Override
    public String getTypeContent() {
        return "Тип PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
