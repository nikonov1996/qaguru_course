package org.example.comparation;

import java.util.Comparator;

public class NameComparator implements Comparator<Man> {
    @Override
    public int compare(Man o1, Man o2) {
        return o1.getUsername().compareTo(o2.getUsername());
    }
}
