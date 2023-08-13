package org.example.generics;

import org.example.comparation.Man;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.generics.Info.showFirstFromList;

public class GenericClass{

    public static void main(String[] args) {
        /*
        List<Man> list = new ArrayList<>();
        list.add(new Man("Vlad",15));
        list.add(new Man("Vlad",10));
        list.add(new Man("Pol",3));
        list.add(new Man("Sasha",8));

        list.forEach(man -> {
            System.out.println(new Info<>(man));
        });

        System.out.println(showFirstFromList(list));

        List<GoodMan> list2 = new ArrayList<>();
        list2.add(new GoodMan("Vlad",15,true));
        list2.add(new GoodMan("Vlad",10,true));
        list2.add(new GoodMan("Pol",3,false));
        list2.add(new GoodMan("Sasha",8,false));

        list2.forEach(man -> {
            System.out.println(new UserInfo<>(man));
        });

        System.out.println(UserInfo.showFirstFromList(list2));
*/
/*
        List<String> listStr = new ArrayList<>();
        List<Number> listNum = new ArrayList<>();
        List<Man> listMan = new ArrayList<>();
        listStr.add("privet");
        listStr.add("poka");
        listNum.add(12);
        listNum.add(56.5);
        listMan.add(new Man("Vlad",15));
        listMan.add(new GoodMan("Sasha",8,false));

        showList(listStr);
        showList(listNum);
        showList(listMan);
*/
        List<Number> list = new ArrayList<>();

        list.add(11); list.add(12.3); list.add(120);

        List<Integer> list1 = new ArrayList<>();

        list1.add(11); list1.add(12); list1.add(120);

        List<Double> list2 = new ArrayList<>();

        list2.add(11.0); list2.add(12.0); list2.add(120.0);

        System.out.println(summList(list));
        System.out.println(summList(list1));
        System.out.println(summList(list2));



    }

    static void showList(List<?> list){
        System.out.println("List values: " + list + "\n");
    }

    static double summList(List<? extends Number> list){
        double sum = 0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

}
