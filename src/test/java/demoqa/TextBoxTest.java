package demoqa;

import demoqa.model.RegisterUser;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static demoqa.service.RegisterUserGenerator.generateRegisterUser;
import static java.lang.String.format;

@Feature("Форма /text-box")
@Story("Заполнение формы /text-box")
@Links(value = {
        @Link(name = "/text-box form", url = "https://demoqa.com/text-box"),
        @Link(name = "base page", url = "https://demoqa.com")
})
public class TextBoxTest extends TestBase {

    @Test
    @Owner("Никонов В.А. @qanva")
    @Severity(SeverityLevel.BLOCKER)
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
        textBoxPage.openPage();
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
