package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void testThatFinedSelenideRepositoryAtTheTop(){
        // открыть главную страницу
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $(".js-site-search-form input").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из списка найденных
        $(".repo-list li:first-child a").click();
        // Можно так:
        // $$(".repo-list .text-normal a").first().click();
        // $$(".repo-list .text-normal a").get(0).click();
        // проверка заголовка
        $("#repository-container-header .text-normal").shouldHave(Condition.text("selenide"));
    }
}
