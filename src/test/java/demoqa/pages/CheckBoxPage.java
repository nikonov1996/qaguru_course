package demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class CheckBoxPage{
    private String PAGE_NAME = "/checkbox";
    @Step("Открыть страницу {this.PAGE_NAME}")
    public CheckBoxPage openPage(){
        open(PAGE_NAME);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Развернуть дерево директорий на странице")
    public CheckBoxPage expandAllCheckBoxes(){
        $(".rct-option-expand-all").click();
        return this;
    }
    @Step("Свернуть дерево директорий на странице")
    public CheckBoxPage collapseAllCheckBoxes(){
        $(".rct-option-collapse-all").click();
        return this;
    }
    @Step("Выбрать все чекбоксы внутри директории \"{folderName}\"")
    public CheckBoxPage checkAllInFolder(String folderName){
        String rootLabelLocatorText = format("#tree-node-%s",folderName).toLowerCase();
        List<SelenideElement> elementList = $(rootLabelLocatorText)
                .parent().parent().parent()
                .shouldHave(Condition.cssClass("rct-node-parent"))
                .$("ol")
                .$$(".rct-title");
        elementList.forEach(selenideElement -> {
            selenideElement.hover().click();
        });
        return this;
    }
    @Step("Выбрать чекбокс по названию файла/папки - \"{title}\"")
    public CheckBoxPage checkByTitle(String title){
        $(format("#tree-node-%s",title).toLowerCase()).parent().hover().click();
        return this;
    }
    @Step("Выбрать чекбоксы по названиям из списка заголовков: {titles} ")
    public CheckBoxPage checkByTitlesInList(List<String> titles){
        titles.stream().forEach(title ->{
            $(format("#tree-node-%s",title).toLowerCase()).parent().hover().click();
        });
        return this;
    }

    public List<String> getInsideFilesAndFoldersTitlesByRootFolderName(String rootDirectoryTitle){
        String rootLabelLocatorText = format("#tree-node-%s",rootDirectoryTitle).toLowerCase();
        List<SelenideElement> elementList = $(rootLabelLocatorText)
                .parent().parent().parent()
                .shouldHave(Condition.cssClass("rct-node-parent"))
                .$("ol")
                .$$(".rct-title"); // toDO Нужно заменить три parent на чтото более локаничное, может xpath
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < elementList.size(); i++) {
            titles.add( elementList.get(i).getText());
        }
        return titles;
    }
    @Step("Проверить, что значения: \"{checkedValues}\" присутсвуют в выбранных результатах")
    public CheckBoxPage verifyThatValuesInResultSelected(List<String> checkedValues){

        List<String> expectedValues = checkedValues.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
        Assertions.assertTrue(
        getResultSelectedValues().containsAll(expectedValues),
                "Список заголовков в результате: " + getResultSelectedValues() + "\n не содержит ожидаемые заголовки: " + expectedValues);
        return this;
    }
    @Step("Проверить, что значение \"{checkedValue}\" присутствует в выбранных результатах")
    public CheckBoxPage verifyThatValueInResultSelected(String checkedValue){

        Assertions.assertTrue(
                getResultSelectedValues().stream().anyMatch(value -> value.equals(checkedValue.toLowerCase())),
                "Список заголовков в результате: " + getResultSelectedValues() + "\n не содержит ожидаемый заголовок: " + checkedValue);
        return this;
    }
    @Step("Проверить, что чекбокс с заголовком \"{title}\" был успешно выбран")
    public CheckBoxPage verifyThatCheckedByTitle(String title){
        $(format("#tree-node-%s", title.toLowerCase())).shouldBe(Condition.checked);
        return this;
    }
    @Step("Проверить, что чекбокс с заголовком \"{title}\" не выбран")
    public CheckBoxPage verifyThatUncheckedByTitle(String title){
        $(format("#tree-node-%s", title.toLowerCase())).shouldNotBe(Condition.checked);
        return this;
    }
    @Step("Проверить, что элементы с заголовками: \"{titles}\" были успешно выбраны")
    public CheckBoxPage verifyThatElementsCheckedByTitles(List<String> titles){
        titles.forEach(s -> {
            verifyThatCheckedByTitle(s);
        });
        return this;
    }

    public List<String> getResultSelectedValues(){
        List<SelenideElement> elementList = $$("#result .text-success");
        List<String> resultSelectedValues = new ArrayList<>();
        for (int i = 0; i < elementList.size(); i++) {
            resultSelectedValues.add(elementList.get(i).getText());
        }
        return resultSelectedValues;
    }

}
