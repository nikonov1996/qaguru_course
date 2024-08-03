package demoqa;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Feature("Форма /login")
@Story("Заполнение формы /login")
@Links(value = {
        @Link(name = "/login form", url = "https://demoqa.com/login"),
        @Link(name = "base page", url = "https://demoqa.com")
})
public class ParametrizedLoginFormTest extends TestBase {

    @CsvFileSource(resources = "/demoqa/testThatNotLoginIfIncorrectData.csv")
    @ParameterizedTest
    @Owner("Никонов В.А. @qanva")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверить, что регистрация не осуществляется с некорректным логином / паролем")
    public void testThatNotLoginIfIncorrectData(String userName, String pass){

        loginPage
                .openPage()
                .setUserName(userName)
                .setPassword(pass)
                .pressLogin();

        loginPage
                .checkErrorOutput();
    }

    @CsvFileSource(resources = "/demoqa/testThatEmptyFieldIsAlarm.csv")
    @ParameterizedTest
    @Owner("Никонов В.А. @qanva")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверить, что регистрация не осуществляется если не заполнен логин/пароль")
    public void testThatEmptyFieldIsAlarm(String userName, String pass){

        loginPage
                .openPage()
                .setUserName(userName)
                .setPassword(pass)
                .pressLogin();

        loginPage
                .checkEmptyFieldsIsAlarm();
    }
}
