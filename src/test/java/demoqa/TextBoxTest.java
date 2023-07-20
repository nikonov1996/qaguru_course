package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import demoqa.model.RegisterUser;
import demoqa.pages.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;
import static demoqa.service.RegisterUserGenerator.generateRegisterUser;
import static java.lang.String.format;

public class TextBoxTest extends TestBase {

    @Test
    void testThatTextBoxSubmitSuccess(){
        RegisterUser expectedUser = generateRegisterUser();

        textBoxPage
                .openPage()
                .setFullName(
                        format("%s %s",
                        expectedUser.getFirstName(),
                        expectedUser.getLastName()))
                .setEmail(expectedUser.getEmail())
                .setAddress(expectedUser.getAddress())
                .setPermanentAddress(expectedUser.getAddress())
                .submitForm()
                .verifyThatOutputFormPresent();
    }
}
