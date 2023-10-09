package org.example.patterns.Decorator;

public class BasicSearchPage implements SearchPage {
    @Override
    public void openPage() {
        System.out.println("Открыть страницу поиска");
    }
}
