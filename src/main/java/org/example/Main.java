package org.example;

import static org.example.Days.MONDAY;
import static org.example.Days.SUNDAY;

public class Main {
    public static void main(String[] args) {

        String i = "воскресенье";
        System.out.println(Days.valueOf(SUNDAY.name()));

    }
}

enum Days{
    SUNDAY("воскресенье"),
    MONDAY("понедельник");

    private String title;

    Days(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "DayOfWeek{" +
                "title='" + title + '\'' +
                '}';
    }
}