package practiceWithSelenoid.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static demoqa.config.ConfigFactory.useConfig;

public class TextBoxPage {
    private String PAGE_NAME = useConfig().textBoxEndpoint();

    @Step("Открыть страницу {this.PAGE_NAME}")
    public TextBoxPage openPage(){
        open(PAGE_NAME);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Ввести значение \"{fullName}\" в поле UserName")
    public TextBoxPage setFullName(String fullName){
        $("#app #userName").setValue(fullName);
        return this;
    }
    @Step("Ввести значение \"{email}\" в поле UserEmail")
    public TextBoxPage setEmail(String email){
        $("#app #userEmail").setValue(email);
        return this;
    }
    @Step("Ввести значение \"{address}\" в поле UserAddress")
    public TextBoxPage setAddress(String address){
        $("#app #currentAddress").setValue(address);
        return this;
    }
    @Step("Ввести значение \"{permanentAddress}\" в поле UserPermanentAddress")
    public TextBoxPage setPermanentAddress(String permanentAddress){
        $("#app #permanentAddress").setValue(permanentAddress);
        return this;
    }
    @Step("Кликнуть на кнопку отправки формы")
    public TextBoxPage submitForm(){
        $("#app #submit").click();
        return this;
    }
    @Step("Проверить, что после отправки формы отображается область с информацией о введенных ранее данных")
    public TextBoxPage verifyThatOutputFormPresent(){
        $("#output").shouldBe(Condition.visible);
        return this;
    }
}
