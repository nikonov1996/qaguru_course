package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DrugAndDrop {

    @Test
    void testThatDrugAndDropSuccess(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(Condition.text("A"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-b").shouldHave(Condition.text("A"));
        $("#column-b").dragAndDropTo("#column-a");
        //actions().moveToElement($("#column-b")).clickAndHold().moveToElement($("#column-a")).release().perform();
        $("#column-a").shouldHave(Condition.text("A"));
        $("#column-b").shouldHave(Condition.text("B"));
    }
}
