package demoqa;

import demoqa.model.RegisterUser;
import demoqa.pages.TestBase;
import demoqa.service.RegisterUserGenerator;
import org.junit.jupiter.api.Test;

import static demoqa.service.RegisterUserGenerator.generateRegisterUser;
import static java.lang.String.format;

public class PracticeFormTest extends TestBase {

    @Test
    void testThatPracticeFormSubmitSuccess(){

        RegisterUser expectedUser = generateRegisterUser();

        registrationPage
                .openPage()
                .setFirstName(expectedUser.getFirstName())
                .setLastName(expectedUser.getLastName())
                .setEmail(expectedUser.getEmail())
                .setGender(expectedUser.getGender())
                .setPhone(expectedUser.getPhone())
                .setDate(
                        expectedUser.getDay(),
                        expectedUser.getMonth(),
                        expectedUser.getYear())
                .setSubject(expectedUser.getSubject())
                .setHobbie(expectedUser.getHobbie())
                .setAvatar(expectedUser.getPicture())
                .setAddress(expectedUser.getAddress())
                .setStateAndCity(expectedUser.getStateAndCity())
                .submit();

        registrationPage
                .checkResultPageVisible()
                .checkResultPageValue(
                        "Student Name",
                        format("%s %s",
                                expectedUser.getFirstName(),
                                expectedUser.getLastName())
                )
                .checkResultPageValue(
                        "Student Email",
                        expectedUser.getEmail())
                .checkResultPageValue(
                        "Mobile",
                        expectedUser.getPhone());

    }
}
