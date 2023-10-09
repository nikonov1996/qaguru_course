package org.example.collections.library;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Polka polka1 = new Polka(1);
        Polka polka2 = new Polka(2);
        polka2.addBook(new Book("Пушкин", "Сказка о царе Салтане"));
        polka2.addBook(new Book("Глебов", "Энциклопедия ножей"));
        polka2.addBook(new Book("Блок", "Стихи"));
        polka1.addBook(new Book("Артистов", "Ночь в праге"));
        polka1.addBook(new Book("Аметистов", "Королева ночи"));
        polka1.addBook(new Book("Арутюнов", "Руководство по самообороне"));

        Library library = new Library();
        library.addPolka(1,polka1);
        library.addPolka(2,polka2);

        library.showBookList();
        System.out.println(library.findBook(new Book("Аметистов", "Королева ночи")));

    }
}
