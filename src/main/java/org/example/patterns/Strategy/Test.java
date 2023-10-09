package org.example.patterns.Strategy;

public class Test {
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.moveBy(new CarMove());
        driver.moveBy(new FlyMove());
        driver.moveBy(new RailwayMove());
    }
}
