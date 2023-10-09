package org.example.patterns.Singlton;

public class Test {
    public static void main(String[] args) {
        Singlton singlton1 = Singlton.getInstance();
        System.out.println(singlton1);
        Singlton singlton2 = Singlton.getInstance();
        System.out.println(singlton2);
    }

}
