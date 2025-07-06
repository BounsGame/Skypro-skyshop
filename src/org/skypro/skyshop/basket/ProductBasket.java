package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private ArrayList<Product> basket = new ArrayList<>();

    public ArrayList<Product> getBasket() {
        return basket;
    }

    public void addProduct(Product newProduct) {
        basket.add(newProduct);
    }

    public int sumPrice() {
        int sum = 0;
        for (int i = 0; i < quantityProduct(); i++) {
            sum += basket.get(i).getPrice();
        }
        return sum;
    }

    public int quantityProduct() {
        int quantity = 0;
        for (int i = 0; i < basket.size(); i++) {
            if (basket.get(i) != null) {
                quantity++;
            }
        }

        return quantity;
    }

    public void printContentsBasket() {
        if (basket.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        for (int i = 0; i < quantityProduct(); i++) {
            System.out.println(basket.get(i).toString());
        }
        System.out.println("Итого: " + sumPrice());
        System.out.println("Специальных товаров: " + calculateSpecial());
    }

    public boolean checkProduct(String product) {
        if (basket.isEmpty()) {
            return false;
        }
        for (int i = 0; i < quantityProduct(); i++) {
            if (product.equals(basket.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        basket.clear();
    }

    public int calculateSpecial() {
        int sum = 0;
        for (int i = 0; i < quantityProduct(); i++) {
            if (basket.get(i).isSpecial()) {
                sum++;
            }
        }
        return sum;
    }

    public List removeProduct(String delete) {
        Iterator<Product> iterator = basket.iterator();
        List<Product> removed = new ArrayList<>();
        while (iterator.hasNext()) {
            Product nowProduct = iterator.next();
            if (nowProduct.getName().contains(delete)) {
                removed.add(nowProduct);
                iterator.remove();
            }
        }
        if (removed.isEmpty()) {
            System.out.println("Список пуст");
            return removed;
        }
        return removed;
    }
}
