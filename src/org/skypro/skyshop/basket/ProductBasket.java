package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private HashMap<String, ArrayList<Product>> basket = new HashMap();

    public HashMap<String, ArrayList<Product>> getBasket() {
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
        for (String kay : basket.keySet()) {
            for (int i = 0; i < basket.get(kay).size(); i++) {
                if (product.equals(basket.get(kay).get(i).getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearBasket() {
        basket.clear();
    }

    public int calculateSpecial() {
        int sum = 0;
        for (String kay : basket.keySet()) {
            for (int i = 0; i < basket.get(kay).size(); i++) {
                if (basket.get(kay).get(i).isSpecial()) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public List removeProduct(String delete) {
        List<Product> removed = new ArrayList<>();
        for (String kay : basket.keySet()) {
            Iterator<Product> iterator = basket.get(kay).iterator();
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
        }
        return removed;
    }
}
