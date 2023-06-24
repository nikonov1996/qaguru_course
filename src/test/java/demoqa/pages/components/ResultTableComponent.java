package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    public SelenideElement
            tableResponsive = $(".table-responsive"),
            resultTableHeader = $(".modal-header");


    public void verifyResultTableParameter(String key, String expectedValue) {
        tableResponsive.$(byText(key)).parent().shouldHave(text(expectedValue));
    }
}
