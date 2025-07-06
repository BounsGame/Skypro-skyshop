package org.skypro.skyshop.product;

import java.util.ArrayList;

public class SearchEngine {
    private ArrayList<Searchable> searchable;

    public SearchEngine() {
        this.searchable = new ArrayList<>();
    }

    public ArrayList<Searchable> search(String text) {
        ArrayList<Searchable> find = new ArrayList<>();
        for (Searchable searchable1 : searchable) {
            if (searchable1.searchTerm().contains(text)) {
                find.add(searchable1);
            }
        }
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
        for (; i < searchable.size(); i++) {
            int count = 0;
            int orderSubstring = searchable.get(i).searchTerm().indexOf(search, order);
            while (orderSubstring != -1) {
                count++;
                order = orderSubstring + search.length();
                orderSubstring = searchable.get(i).searchTerm().indexOf(search, order);
            }
            if (max < count) {
                max = count;
                find = searchable.get(i);
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
}
