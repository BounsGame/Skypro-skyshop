package org.skypro.skyshop.product;

import java.util.Objects;

public class Article implements Searchable {
    private String name;
    private String text;

    public Article(String title, String text) {
        this.text = text;
        this.name = title;
    }

    @Override
    public String toString() {
        return name + "\n" + text;
    }


    @Override
    public String searchTerm() {
        return "Тип ARTICLE \n" + toString();
    }

    @Override
    public String getTypeContent() {
        return "Тип ARTICLE";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

interface Searchable {
    String searchTerm();

    String getTypeContent();

    String getName();

    default String getStringRepresentation() {
        return "Имя " + "-объекта—тип " + "-объекта";
    }

}
