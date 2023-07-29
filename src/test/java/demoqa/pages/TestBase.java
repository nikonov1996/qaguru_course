package demoqa.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import practiceWithSelenoid.helpers.AttachHelper;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static demoqa.config.ConfigFactory.useConfig;

@Tag("demoqa")
public class TestBase {
    public RegistrationPage registrationPage = new RegistrationPage();
    public LoginPage loginPage = new LoginPage();
    public CheckBoxPage checkBoxPage = new CheckBoxPage();
    public TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void before(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl =useConfig().baseUrl();
    }

    @AfterEach
    void addAttachments(){
        AttachHelper.screenshotAs("actual_screenshot");
        AttachHelper.pageSource();
        AttachHelper.browserConsoleLogs();
    }

}
