package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        DiscountedProduct product1 = new DiscountedProduct("Lays", 140, 50);
        DiscountedProduct product2 = new DiscountedProduct("Saint Spring", 60, 10);
        SimpleProduct product3 = new SimpleProduct(99, "Monster");
        SimpleProduct product4 = new SimpleProduct(129, "Yogurt");
        FixPriceProduct product5 = new FixPriceProduct("Milk");
        ProductBasket basket1 = new ProductBasket();
        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product4);
        basket1.addProduct(product5);
        basket1.printContentsBasket();

        if (basket1.checkProduct("Monster")) {
            System.out.println("Тавар есть в корзине");
        } else {
            System.out.println("Тавара нет в корзине");
        }

        if (basket1.checkProduct("Perfume")) {
            System.out.println("Тавар есть в корзине");
        } else {
            System.out.println("Тавара нет в корзине");
        }

        SearchEngine catalog = new SearchEngine();
        for (Product basket : basket1.getBasket()) {
            catalog.add(basket);
        }
        Article Monster = new Article("Monster", "Energetic drink with taste of peach");
        Article Lays = new Article("Lays", "chips with taste of salt");
        catalog.add(Lays);
        catalog.add(Monster);

        System.out.println("Удалённые продукты \n" + basket1.removeProduct("Saint Spring"));
        System.out.println("\nначал выводить продукты после удаления");
        basket1.printContentsBasket();

        System.out.println("Удалённые продукты \n" + basket1.removeProduct("Saint Spring"));
        System.out.println("\nначал выводить продукты после удаления");
        basket1.printContentsBasket();

        basket1.clearBasket();
        basket1.printContentsBasket();

        if (basket1.checkProduct("Monster")) {
            System.out.println("Тавар есть в корзине");
        } else {
            System.out.println("Тавара нет в корзине");
        }

        System.out.println(Arrays.toString(catalog.search("Lays").toArray()));
        System.out.println(Arrays.toString(catalog.search("Monster").toArray()));
        System.out.println(Arrays.toString(catalog.search("PRODUCT").toArray()));

        try {
            DiscountedProduct russianPotato = new DiscountedProduct("Russian potato", 100, 130);
        } catch (Exception e) {
            System.out.println("Ошибка создания продукта: " + e.getMessage());
        }
        try {
            SimpleProduct chicken = new SimpleProduct(230, "");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания продукта: " + e.getMessage());
        }
        try {
            SimpleProduct bubbleGum = new SimpleProduct(-30, "Huba Buba");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания продукта: " + e.getMessage());
        }
        System.out.println(catalog.mostSearchable("Lays"));
        System.out.println(catalog.mostSearchable("fafasd"));

    }
}