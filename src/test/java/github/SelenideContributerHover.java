package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideContributerHover {

    @Test
    void testThatContributerCardOpenWhenHover(){
        // перейти на страницу selenide в github
        open("https://github.com/selenide/selenide");
        // навести курсор на первый элемент в блоке Contributors
        $$(".list-style-none .mb-2").first().hover();
        // в всплывающем окне проверить имя Андрей Солнцев
        $(".Truncate").shouldHave(Condition.text("Andrei Solntsev"));
    }
}
