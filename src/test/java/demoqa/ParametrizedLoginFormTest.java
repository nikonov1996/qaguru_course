package demoqa;

import demoqa.pages.TestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class ParametrizedLoginFormTest extends TestBase {

    @CsvFileSource(resources = "/demoqa/testThatNotLoginIfIncorrectData.csv")
    @ParameterizedTest
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
