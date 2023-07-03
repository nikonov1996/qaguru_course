package demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class CheckBoxPage{

    public CheckBoxPage openPage(){
        open("/checkbox");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public CheckBoxPage expandAllCheckBoxes(){
        $(".rct-option-expand-all").click();
        return this;
    }

    public CheckBoxPage collapseAllCheckBoxes(){
        $(".rct-option-collapse-all").click();
        return this;
    }

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

    public CheckBoxPage checkByTitle(String folderTitle){
        $(format("#tree-node-%s",folderTitle).toLowerCase()).parent().hover().click();
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

    public CheckBoxPage verifyThatValuesInResultSelected(List<String> checkedValues){

        List<String> expectedValues = checkedValues.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
        Assertions.assertTrue(
        getResultSelectedValues().containsAll(expectedValues),
                "Список заголовков в результате: " + getResultSelectedValues() + "\n не содержит ожидаемые заголовки: " + expectedValues);
        return this;
    }

    public CheckBoxPage verifyThatCheckedByTitle(String title){
        $(format("#tree-node-%s", title.toLowerCase())).shouldBe(Condition.checked);
        return this;
    }

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
