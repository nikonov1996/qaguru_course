package demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private String PAGE_NAME = "/login";
    @Step("Открыть страницу {this.PAGE_NAME}")
    public LoginPage openPage(){
        open(PAGE_NAME);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Ввести значение \"{username}\" в поле UserName")
    public LoginPage setUserName(String username){
        $("#userName").setValue(username);
        return this;
    }
    @Step("Ввести значение \"{password}\" в поле Password")
    public LoginPage setPassword(String password){
        $("#password").setValue(password);
        return this;
    }
    @Step("Нажать кнопку Log in")
    public LoginPage pressLogin(){
        $("#login").click();
        return this;
    }
    @Step("Перейти на форму создания нового пользователя")
    public RegisterPage registNewUser(){
        $("#newUser").click();
        return new RegisterPage();
    }
    @Step("Проверить, что отображается ошибка \"Invalid username or password!\"")
    public LoginPage checkErrorOutput(){
        $("#output").shouldBe(Condition.visible).shouldHave(Condition.text("Invalid username or password!"));
        return this;
    }
    @Step("Проверить, что отображается ошибка при незаполненном/-ных поле/-ях")
    public LoginPage checkEmptyFieldsIsAlarm(){

        $$("input").forEach(selenideElement -> {
            if (selenideElement.getAttribute("value").isEmpty()){
                Assertions.assertTrue( selenideElement.getAttribute("class").contains("is-invalid"));
            }
        });
        return this;
    }
}
