package org.example.patterns.Singlton;

public class Singlton {
    final private static Singlton instance = new Singlton();

    private Singlton() {
    }

    public static Singlton getInstance(){
        if (instance == null){
            return new Singlton();
        }else{
            return instance;
        }
    }
}
