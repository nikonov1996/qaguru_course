package demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    public LoginPage openPage(){
        open("/login");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public LoginPage setUserName(String username){
        $("#userName").setValue(username);
        return this;
    }

    public LoginPage setPassword(String password){
        $("#password").setValue(password);
        return this;
    }

    public LoginPage pressLogin(){
        $("#login").click();
        return this;
    }

    public RegisterPage registNewUser(){
        $("#newUser").click();
        return new RegisterPage();
    }

    public LoginPage checkErrorOutput(){
        $("#output").shouldBe(Condition.visible).shouldHave(Condition.text("Invalid username or password!"));
        return this;
    }

    public LoginPage checkEmptyFieldsIsAlarm(){

        $$("input").forEach(selenideElement -> {
            if (selenideElement.getAttribute("value").isEmpty()){
                Assertions.assertTrue( selenideElement.getAttribute("class").contains("is-invalid"));
            }
        });
        return this;
    }
}
