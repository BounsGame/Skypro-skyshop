package org.skypro.skyshop.product;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine implements Comparable<Searchable> {
    private Map<String, Searchable> searchable;

    public SearchEngine() {
        this.searchable = new TreeMap<>();
    }

    public Map<String, Searchable> search(String text) {
        Map<String, Searchable> find = new TreeMap();
        for (String key : searchable.keySet()) {
            if (searchable.get(key).searchTerm().contains(text)) {
                find.put(key, searchable.get(key));
            }
        }
        return find;
    }

    public void add(Searchable newElement) {
        searchable.put(newElement.getName(), newElement);
    }

    public Searchable mostSearchable(String search) {
        int i = 0;
        int order = 0;
        int max = 0;
        Searchable find = null;
        for (String key : searchable.keySet()) {
            int count = 0;
            int orderSubstring = searchable.get(key).searchTerm().indexOf(search, order);
            while (orderSubstring != -1) {
                count++;
                order = orderSubstring + search.length();
                orderSubstring = searchable.get(key).searchTerm().indexOf(search, order);
            }
            if (max < count) {
                max = count;
                find = searchable.get(key);
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
        for (String key : searchable.keySet()) {
            sum += key + " " + searchable.get(key) + "\n";
        }
        return sum;
    }
}
