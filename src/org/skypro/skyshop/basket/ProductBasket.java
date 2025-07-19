package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private Map<String, ArrayList<Product>> basket = new HashMap();

    public Map<String, ArrayList<Product>> getBasket() {
        return basket;
    }

    public void addProduct(Product newProduct) {
        if (basket.containsKey(newProduct.getName())) {
            basket.get(newProduct.getName()).add(newProduct);
        } else {
            ArrayList<Product> productList = new ArrayList<>();
            productList.add(newProduct);
            basket.put(newProduct.getName(), productList);
        }
    }

    public int sumPrice() {
        return basket.values().stream().flatMap(Collection::stream).mapToInt(Product::getPrice).sum();
    }

    public void printContentsBasket() {
        if (basket.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        basket.values().stream().flatMap(Collection::stream)
                .forEach(product -> System.out.println(product.toString()));
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
        return (int) basket.values().stream().flatMap(Collection::stream).filter(Product::isSpecial).count();
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
