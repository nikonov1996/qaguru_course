package junit;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import demoqa.pages.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.data.Locale;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest extends TestBase {

    @BeforeAll
    static void before(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    static Stream<Arguments> selenideSiteShouldHaveAllButtonsGivenLocale(){
        return Stream.of(
                Arguments.of(
                        Locale.EN,
                        List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")
                ),
                Arguments.of(
                        Locale.RU,
                        List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы")
                )
        );
    }
    // Параметризованный тест со сложными объектами
    @MethodSource("selenideSiteShouldHaveAllButtonsGivenLocale") // Позволяет передать любые объекты в тест
    @ParameterizedTest(name = "Для локали {0}, отображаются кнопки {1}")
    void selenideSiteShouldHaveAllButtonsGivenLocale(
            Locale locale,
            List<String> buttons
    ){
        open("https://ru.selenide.org/");
        $$("div#languages a").findBy(text(locale.name())).click();
        $$(".main-menu-pages a")
                .filter(visible)
                .shouldHave(texts(buttons));

    }
}
