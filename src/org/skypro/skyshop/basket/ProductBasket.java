package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, ArrayList<Product>> basket = new HashMap();

    public Map<String, ArrayList<Product>> getBasket() {
        return basket;
    }

    public void addProduct(Product newProduct) {
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(newProduct);
        basket.put(newProduct.getName(), productList);
    }

    public int sumPrice() {
        int sum = 0;
        for (String kay : basket.keySet()) {
            for (int i = 0; i < basket.get(kay).size(); i++) {
                sum += basket.get(kay).get(i).getPrice();
            }
        }
        return sum;
    }

    public void printContentsBasket() {
        if (basket.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        for (String kay : basket.keySet()) {
            for (int i = 0; i < basket.get(kay).size(); i++) {
                System.out.println(basket.get(kay).get(i).toString());
            }
        }
        System.out.println("Итого: " + sumPrice());
        System.out.println("Специальных товаров: " + calculateSpecial());
    }

    public boolean checkProduct(String product) {
        if (basket.isEmpty()) {
            return false;
        }
        if (basket.containsKey(product)) {
            return true;
        }
        return false;
    }

    public void clearBasket() {
        basket.clear();
    }

    public int calculateSpecial() {
        int sum = 0;
        for (String key : basket.keySet()) {
            for (int i = 0; i < basket.get(key).size(); i++) {
                if (basket.get(key).get(i).isSpecial()) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public List<Product> removeProduct(String delete) {
        List<Product> removed = new ArrayList<>();
        if (basket.get(delete) == null) {
            System.out.println("Список пуст");
            return removed;
        }
        removed = basket.get(delete);
        basket.remove(delete);
        return removed;
    }
}
