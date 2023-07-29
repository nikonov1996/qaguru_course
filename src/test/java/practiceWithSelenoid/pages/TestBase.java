package practiceWithSelenoid.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.remote.DesiredCapabilities;
import practiceWithSelenoid.helpers.AttachHelper;
import practiceWithSelenoid.pages.TextBoxPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import static demoqa.config.ConfigFactory.useConfig;

@Tag("selenoid_tests")
public class TestBase {

    public TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void before(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = System.getProperty("browser","chrome");
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = useConfig().baseUrl();
        Configuration.remote = useConfig().selenoidHub() + "/wd/hub";

        // Добавление настроек для записи видео в селеноиде (по умолчанию запись видео не идет)
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments(){
        AttachHelper.screenshotAs("actual_screenshot");
        AttachHelper.pageSource();
        AttachHelper.browserConsoleLogs();
        AttachHelper.addVideo();
    }
}
