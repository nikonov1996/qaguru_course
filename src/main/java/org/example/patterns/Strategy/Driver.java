package org.example.patterns.Strategy;

public class Driver{

    Moveble moveble;

    public void moveBy(Moveble moveble) {
        moveble.move();
    }

    public Driver() {
    }
}
