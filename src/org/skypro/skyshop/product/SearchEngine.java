package org.skypro.skyshop.product;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchEngine implements Comparable<Searchable> {
    private Set<Searchable> searchable;

    public SearchEngine() {
        this.searchable = new HashSet<>();
    }

    public Set<Searchable> search(String text) {
        Set<Searchable> find = searchable.stream()
                .filter(searchable1 -> searchable1.getName().contains(text))
                .collect(Collectors.toCollection(() -> new TreeSet<Searchable>(new SearchableComparator())));
        return find;
    }

    public void add(Searchable newElement) {
        searchable.add(newElement);
    }

    public Searchable mostSearchable(String search) {
        int i = 0;
        int order = 0;
        int max = 0;
        Searchable find = null;
        for (Searchable key : searchable) {
            int count = 0;
            int orderSubstring = key.searchTerm().indexOf(search, order);
            while (orderSubstring != -1) {
                count++;
                order = orderSubstring + search.length();
                orderSubstring = key.searchTerm().indexOf(search, order);
            }
            if (max < count) {
                max = count;
                find = key;
            }
        }
        try {
            if (find == null) {
                throw new BestResultNotFound("нету лучшего результата");
            }
        } catch (BestResultNotFound e) {
            System.out.println("для " + search + " не нашлось подходящей статьи");
        }
        return find;
    }

    @Override
    public int compareTo(Searchable o) {
        return o.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        String sum = "";
        for (Searchable key : searchable) {
            sum += key + " " + key + "\n";
        }
        return sum;
    }
}
