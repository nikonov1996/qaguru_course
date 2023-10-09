package org.example.patterns.Strategy;

public class RailwayMove implements Moveble {
    @Override
    public void move() {
        System.out.println("Driver moves by train!");
    }
}
