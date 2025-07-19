package org.skypro.skyshop.product;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        if (Integer.compare(s1.getName().length(), s2.getName().length()) == 0) {
            s1.getName().compareTo(s2.getName());
        }
        return Integer.compare(s1.getName().length(), s2.getName().length());
    }
}
