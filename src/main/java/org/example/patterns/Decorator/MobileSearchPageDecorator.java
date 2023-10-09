package org.example.patterns.Decorator;

public class MobileSearchPageDecorator extends SearchPageDecorator{
    public MobileSearchPageDecorator(SearchPage searchPage) {
        super(searchPage);
    }

    public void clickMobileButton(){
        System.out.println("Нажать иконку лупы, чтобы поле поиска развернулось");
    }

    @Override
    public void openPage() {
        System.out.println("Открыть страницу поиска в мобилке");
    }
}
