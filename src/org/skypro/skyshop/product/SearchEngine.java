package org.skypro.skyshop.product;

import java.util.ArrayList;
import java.util.TreeMap;

public class SearchEngine implements Comparable<Searchable> {
    private TreeMap<String, Searchable> searchable;

    public SearchEngine() {
        this.searchable = new TreeMap<>();
    }

    public ArrayList<Searchable> search(String text) {
        ArrayList<Searchable> find = new ArrayList<>();
        for (String kay : searchable.keySet()) {
            if (searchable.get(kay).searchTerm().contains(text)) {
                find.add(searchable.get(kay));
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
        for (String kay : searchable.keySet()) {
            int count = 0;
            int orderSubstring = searchable.get(kay).searchTerm().indexOf(search, order);
            while (orderSubstring != -1) {
                count++;
                order = orderSubstring + search.length();
                orderSubstring = searchable.get(kay).searchTerm().indexOf(search, order);
            }
            if (max < count) {
                max = count;
                find = searchable.get(kay);
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
}
