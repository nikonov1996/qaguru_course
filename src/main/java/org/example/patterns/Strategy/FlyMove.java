package org.example.patterns.Strategy;

public class FlyMove implements Moveble {
    @Override
    public void move() {
        System.out.println("Driver moves by plain!");
    }
}
