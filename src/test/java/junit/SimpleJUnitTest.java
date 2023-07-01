package junit;

import com.codeborne.selenide.Condition;
import junit.data.Locale;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//@Disabled() // Можно задизейблить все тесты в классе
public class SimpleJUnitTest {

    @DisplayName("Демонстрационный тест") // Аннотация дя названия тестов, отображается в Allure
    // @Disabled("Тут причина отключения теста или issue") // Если необходимо чтобы тест не запускался
    @Tags({
            @Tag("UI"),
            @Tag("BLOCKER"),
            @Tag("SMOKE")
    })
    @Test
    void simpleTest(){
        Assertions.assertTrue(3 > 2);
    }

    // Параметризованный тест
    /*@CsvSource({
            "Allure, https://docs.qameta.io",
            "Habr, https://habr.com"
    })*/
    @CsvFileSource(resources = "/forGoogleSearchTest/googleSearchTestValues.csv")
    @ParameterizedTest(name="Проверить, что Google выдает корректный результат поиска {1} по значению поиска {0}")
    void testThatGoogleGetCorrectSearchResult(
            String searchValue,
            String expectedResultValue
    ){
        open("https://www.google.com/");
        $("[title='Поиск']").setValue(searchValue).pressEnter();
        $(byText(expectedResultValue)).shouldBe(Condition.visible);


    }

    // Параметризованный тест если один аргумент
    @ValueSource(
            strings = {"Allure", "Google", "Habr"}
    )
    @ParameterizedTest(name="Проверить, что Google выдает результат поиска по значению поиска {0}")
    void testThatGoogleGetCorrectSearchResult(
            String searchValue
    ){
        open("https://www.google.com/");
        $("[title='Поиск']").setValue(searchValue).pressEnter();


    }


}
