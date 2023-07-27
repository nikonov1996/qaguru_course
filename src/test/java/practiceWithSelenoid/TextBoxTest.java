package practiceWithSelenoid;

import demoqa.model.RegisterUser;
import practiceWithSelenoid.pages.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static demoqa.service.RegisterUserGenerator.generateRegisterUser;
import static java.lang.String.format;
@Links(value = {
        @Link(name = "/text-box form", url = "https://demoqa.com/text-box"),
        @Link(name = "base page", url = "https://demoqa.com")
})
@Story("Заполнение формы /text-box")
@Feature("Форма /text-box")
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
}
