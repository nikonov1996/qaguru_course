package org.example.patterns.Decorator;

public class SearchPageDecorator implements SearchPage {
    private final SearchPage searchPage;

    public SearchPageDecorator(SearchPage searchPage) {
        this.searchPage = searchPage;
    }

    @Override
    public void openPage() {
        searchPage.openPage();
    }
}
