package org.example.streams;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        // Получаем только четные числа из списка

       /* List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            intList.add(new Random().nextInt(25));
        }
        System.out.println(intList);
        List<Integer> result = intList.stream().filter(integer -> integer%2==0).collect(Collectors.toList());
        System.out.println(result);*/

        // Считаем количество слов, которые начинаются на определенную букву

       /* List<String> names = new ArrayList<>();
        names.add("Penelopa");
        names.add("Oleg");
        names.add("Pavel");
        names.add("Oksana");
        names.add("Polly");
        names.add("Aleksey");
        names.add("Andrey");
        names.add("Patrick");

        System.out.println(names);
        long nameCount = names.stream().filter(s -> s.toUpperCase().startsWith("P")).count();
        System.out.println(nameCount);*/

        // Сортировка массива строк в лексиграфическом порядке

     /*   String[] words = new String[]{
                "jjmdkd","adwadwd","abfg","bdfdf","drew","crfss","wadwa","avfvf"
        };

        System.out.println(Arrays.toString(words));

        List<String> sortedWords = Arrays.asList(words)
                .stream()
                .sorted(((o1, o2) -> o1.compareTo(o2)))
                .collect(Collectors.toList());

        System.out.println(sortedWords);*/

        // Создание списка котов и отображение информации о них

        List<Cat> catBand = new ArrayList<>();
        catBand.add(new Cat("Pop",2,"Emily Rich",15,"USA"));
        catBand.add(new Cat("Ivan",5,"Antonina Vasilevna",55,"RUS"));
        catBand.add(new Cat("Ivan",5,"Antonina Vasilevna",55,"RUS"));
        catBand.add(new Cat("Eva",4,"Sergey Malov",25,"RUS"));
        catBand.add(new Cat("Semen",5,"Sergey Malov",25,"RUS"));
        catBand.add(new Cat("Lusy",1,"Clark Kent",17,"USA"));
        catBand.add(new Cat("Patrisio",7,"Andriano Vendetty",35,"ITALY"));

        catBand.stream().forEach(System.out::println);
        System.out.println("\n");

        // Для каждого кота в вывод модифицировать информацию

      /*  catBand.stream().map(cat -> {
            return new Cat(
                    "Котика зовут: " + cat.getName(),
                    cat.getAge(),
                    "Владельца котика зовут: " + cat.getCatOwner(),
                    cat.getOwnerAge(),
                    "Котик и хозяин живут в " + cat.getLocation()
            );
        }).forEach(System.out::println); */

        // Сортируем по возрасту котиков
     /*   catBand.stream().sorted(new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.getAge()- o2.getAge();
            }
        }).forEach(System.out::println); */

        // Сортируем по возрасту хозяев
    /*    catBand.stream().sorted(new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.getOwnerAge()- o2.getOwnerAge();
            }
        }).forEach(System.out::println); */

        // Сортировка по нескольким полям
      /*  catBand.stream()
                .sorted(Comparator.comparing(Cat::getName)
                .thenComparing(Cat::getAge))
                .forEach(System.out::println); */

        // Вычислим средний возраст котиков и максимальный возраст котика из списка

     /*   double avgCatAge = catBand.stream().mapToInt(Cat::getAge).summaryStatistics().getAverage();
        System.out.println("Средний возраст котиков: " + avgCatAge);

        int maxCatAge = catBand.stream().mapToInt(Cat::getAge).summaryStatistics().getMax();
        System.out.println("Самый старший котик имеет возраст: " + maxCatAge); */

        // Проверка, что у всех хозяев котиков возвраст не больше 60ти

   /*     System.out.println(
                catBand.stream().allMatch(cat -> cat.getOwnerAge()<60)
        ); */

        // Проверить есть ли хозяива с именем Сlark

 /*       String name = "Clark";
        System.out.println(
                "Есть ли хозяин с именем " + name + " - " +
                catBand.stream().anyMatch(cat -> {
                    return cat.getCatOwner().contains(name);
                })
        ); */

        // Проверить начинается ли имя какого нибудь котика на определенную букву

   /*     String firstNameChar = "P";
        System.out.println(
                "Есть ли котик у которого имя начинается на " + firstNameChar +
                " = " +
                catBand.stream().anyMatch(cat -> {
                    return cat.getName().startsWith(firstNameChar);
                })
        );
        System.out.println(
                "Коти -к/-ки у которого/-ых имя начинается на " + firstNameChar +
                        " это " +
                        catBand.stream()
                                .filter(cat -> cat.getName().startsWith(firstNameChar))
                                .collect(Collectors.toList())
        ); */

        // Преобразование list в set (записи с Антониной Васильевной в сете будет одна)
       /* System.out.println(catBand.stream().collect(Collectors.toSet())); */

        // Вывести кол-во разных локаций
    /*    System.out.println(
                "Кол-во уникальных локаций в списке - " +
                catBand.stream()
                        .map(Cat::getLocation)
                        .distinct()
                        .count()
        );
        System.out.println(
                "Уникальные локации: " +
                        catBand.stream()
                                .map(Cat::getLocation)
                                .distinct()
                                .collect(Collectors.toList())
        ); */

        // Котик старше 3 лет и у которого имя начинается не с "I"
     /*   catBand.stream()
                .filter(cat -> cat.getAge()>=3)
                .filter(cat -> !cat.getName().startsWith("I"))
                .forEach(System.out::println); */
    }
}
