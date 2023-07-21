package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import demoqa.model.RegisterUser;
import demoqa.pages.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;
import static demoqa.service.RegisterUserGenerator.generateRegisterUser;
import static java.lang.String.format;

public class TextBoxTest extends TestBase {

    @Test
    @Owner("Никонов В.А. @qanva")
    @Severity(SeverityLevel.BLOCKER)
    @Links(value = {
            @Link(name = "/text-box form", url = "https://demoqa.com/text-box"),
            @Link(name = "base page", url = "https://demoqa.com")
    })
    @Story("Заполнение формы /text-box")
    @Feature("Форма /text-box")
    @DisplayName("Заполнение формы /text-box корректными данными")
    void testThatTextBoxSubmitSuccess() {
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

    @Test
    /*
       Данный тест, показывает возможность работы с Allure
       без использования аннотаций.
       Динамические тэги, нужны для расширения возможностей: например,
       добавить общий story или feature для группы тестов.
    */
    void testDinamicAllureAnnotation() {
        Allure.getLifecycle().updateTestCase(
                testResult ->
                        testResult.setName("Тест, демонстрирующий работу Allure без аннотаций"));
        Allure.feature("Allure описание тест кейса");
        Allure.story("Описание тест кейса в Allure без использования аннотаций");
        Allure.label("owner", "Никонов В.А nikonov1996");
        Allure.label("severity", SeverityLevel.NORMAL.value());
        Allure.link("Форма /text-box", "https://demoqa.com/text-box");
        Allure.description("Данный тест не содержит шагов, только  Allure описание ");
    }
}
