package threadQA;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {

    @BeforeAll
    static void before(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.baseUrl ="http://85.192.34.140:8081";
    }

    @Test
    void testThatTextBoxSubmitSuccess(){
        open("/");
        $(byTagAndText("h5","Elements")).click();
        $("#item-0").click();
        // $("#app div.main-header").shouldBe(Condition.text("Text Box"));
        $("#userName").setValue("Vladislav");
        $("#app #userEmail").setValue("Vladislav@mail.ru");
        $("#app #currentAddress").setValue("Big Podgornaya 42, flat 44");
        $("#app #permanentAddress").setValue("Big Podgornaya 42, flat 44");
        $("#app #submit").click();
    }
}
