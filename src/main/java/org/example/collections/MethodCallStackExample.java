package org.example.collections;

public class MethodCallStackExample {
    public static void main(String[] args) {
        thirdMethod();
    }

    static void firstMethod(){
        System.out.println("First method start");
        System.out.println("First method stop");
    }

    static void secondMethod(){
        System.out.println("Second method start");
        firstMethod();
        System.out.println("Second method stop");
    }

    static void thirdMethod(){
        System.out.println("Third method start");
        secondMethod();
        System.out.println("Third method stop");
    }
}
