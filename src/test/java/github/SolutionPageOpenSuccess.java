package github;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SolutionPageOpenSuccess {

    @Test
    void testThatSolutionPageOpenSuccess(){
        Configuration.browser = "opera";
        open("https://github.com/");
        $$(".HeaderMenu-item").find(Condition.text("Solutions")).hover();
        $(".HeaderMenu-dropdown li [href='/enterprise']").click();
        $(".enterprise-hero h1").shouldHave(Condition.text("Build like the best"));
        Assertions.assertEquals("https://github.com/enterprise",url());

    }

}
