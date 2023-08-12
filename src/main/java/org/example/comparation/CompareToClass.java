package org.example.comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareToClass {

    public static void main(String[] args) {
        List<Man> list = new ArrayList<>();
        list.add(new Man("Vlad",15));
        list.add(new Man("Vlad",10));
        list.add(new Man("Pol",3));
        list.add(new Man("Sasha",8));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}



