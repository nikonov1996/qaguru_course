package org.example.generics.game;

public abstract class Participant {

    public String getName() {
        return name;
    }

    private String name;

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                '}';
    }

    protected Participant(String name) {
        this.name = name;
    }
}
