package demoqa.pages;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBase {

    public RegistrationPage registrationPage = new RegistrationPage();
    public LoginPage loginPage = new LoginPage();

    public CheckBoxPage checkBoxPage = new CheckBoxPage();

    @BeforeAll
    static void before(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl ="https://demoqa.com";
    }

}
