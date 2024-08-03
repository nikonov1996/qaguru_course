package demoqa;

import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.proxy.CaptureType;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class DevToolsTest extends TestBase {

    @Test
    @Owner("Никонов В.А. @qanva")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Получение списка запросов из DevTools Network")
    void getRequestsListFromNetwork() {
        open("https://fakestoreapi.com/");
        $("#fetch_btn").scrollIntoView(true);
        $("#fetch_btn").click();
        Selenide.sleep(2000);
        BrowserUpProxy proxy = WebDriverRunner.getSelenideProxy().getProxy();
        proxy.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
        proxy.enableHarCaptureTypes(CaptureType.RESPONSE_CONTENT);
        var requests1 = proxy.getHar().getLog().getEntries().stream().map(harEntry -> harEntry.getRequest().getUrl()).collect(Collectors.toList());
        $("#fetch_btn").click();
        Selenide.sleep(2000);
        var requests2 = proxy.getHar().getLog().getEntries().stream().map(harEntry -> harEntry.getRequest().getUrl()).collect(Collectors.toList());
        $("#fetch_btn").click();
        Selenide.sleep(2000);
        $("#fetch_btn").click();
        Selenide.sleep(2000);
        $("#fetch_btn").click();
        Selenide.sleep(2000);
        var requests3 = proxy.getHar().getLog().getEntries().stream().map(harEntry -> harEntry.getRequest().getUrl()).collect(Collectors.toList());
        Selenide.sleep(2000);
        Selenide.refresh();

        var requests4 = proxy.getHar().getLog().getEntries().stream().map(harEntry -> harEntry.getRequest().getUrl()).collect(Collectors.toList());

        var a = 1;
    }
}
