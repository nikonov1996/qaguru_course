package demoqa.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class RegisterPage {
    private String PAGE_NAME = "/register";
    @Step("Открыть страницу {this.PAGE_NAME}")
    public RegisterPage openPage(){
        open(PAGE_NAME);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
}
