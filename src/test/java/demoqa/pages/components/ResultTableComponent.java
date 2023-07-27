package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    public SelenideElement
            tableResponsive = $(".table-responsive"),
            resultTableHeader = $(".modal-header");

    @Step("Проверить, что значение параметра \"{key}\" соответствует значению - \"{expectedValue}\"")
    public void verifyResultTableParameter(String key, String expectedValue) {
        tableResponsive.$(byText(key)).parent().shouldHave(text(expectedValue));
    }
}
