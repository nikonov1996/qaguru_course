package org.example.generics;

import org.example.comparation.Man;

public class GoodMan extends Man {

    @Override
    public String toString() {
        return "GoodMan{" +
                "goodness=" + goodness +
                '}';
    }

    public Boolean getGoodness() {
        return goodness;
    }

    public void setGoodness(Boolean goodness) {
        this.goodness = goodness;
    }

    Boolean goodness;
    public GoodMan(String username, Integer id,Boolean goodness) {
        super(username, id);
        this.goodness = goodness;
    }
}
