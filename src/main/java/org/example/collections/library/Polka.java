package org.example.collections.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Polka {
    private List<Book> polka = new ArrayList<>();

    public List<Book> getPolka() {
        return polka;
    }

    public Integer getNumber() {
        return number;
    }

    Integer number;

    public Polka(Integer number) {
        this.number = number;
    }

    public void addBook(Book book){
        this.polka.add(book);

    }

    @Override
    public String toString() {
        return "Polka{" +
                "polka=" + polka +
                ", number=" + number +
                '}';
    }
}
