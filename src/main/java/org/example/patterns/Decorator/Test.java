package org.example.patterns.Decorator;

public class Test {
    public static void main(String[] args) {
        BasicSearchPage basicSearchPage = new BasicSearchPage();
        SearchPage mobileSearchPage = new MobileSearchPageDecorator(basicSearchPage);
            basicSearchPage.openPage();
            mobileSearchPage.openPage();
        ((MobileSearchPageDecorator)mobileSearchPage).clickMobileButton();
    }
}
