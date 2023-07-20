package demoqa.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    public TextBoxPage openPage(){
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String fullName){
        $("#app #userName").setValue(fullName);
        return this;
    }

    public TextBoxPage setEmail(String email){
        $("#app #userEmail").setValue(email);
        return this;
    }

    public TextBoxPage setAddress(String address){
        $("#app #currentAddress").setValue(address);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress){
        $("#app #permanentAddress").setValue(permanentAddress);
        return this;
    }

    public TextBoxPage submitForm(){
        $("#app #submit").click();
        return this;
    }

    public TextBoxPage verifyThatOutputFormPresent(){
        $("#output").shouldBe(Condition.visible);
        return this;
    }
}
