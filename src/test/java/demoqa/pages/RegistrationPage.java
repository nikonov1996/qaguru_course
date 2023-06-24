package demoqa.pages;

import com.codeborne.selenide.Condition;
import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.ResultTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private CalendarComponent calendar = new CalendarComponent();
    private ResultTableComponent resultTable = new ResultTableComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String firstName){
        $("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName){
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email){
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender){
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhone(String phone){
        $("#userNumber").setValue(phone);
        return this;
    }

    public RegistrationPage setBirthDate(String month,int day,String year){
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $$(".react-datepicker__day").filterBy(Condition.text(Integer.toString(day))).first().click();
        return this;
    }

    public RegistrationPage setSubject(String subject){
        $("#subjectsInput").setValue("English").pressEnter();
        return this;
    }

    public RegistrationPage setHobbie(String hobbie){
        $("#hobbiesWrapper").$(byText(hobbie)).click();
        return this;
    }

    public RegistrationPage setAvatar( String filepath){
        $("#uploadPicture").uploadFromClasspath(filepath);
        return this;
    }

    public RegistrationPage setAddress(String address){
        $("#currentAddress").setValue(address);
        return this;
    }

    public RegistrationPage setStateAndCity(String[] stateAndCity){
        $(byText("Select State")).click();
        $(byText(stateAndCity[0])).click();
        $(byText("Select City")).click();
        $(byText(stateAndCity[1])).click();
        return this;
    }

    public RegistrationPage setDate(String day,String month,String year){
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage submit(){
        $("#submit").click();
        return this;
    }

    public RegistrationPage checkResultPageVisible(){
        resultTable.tableResponsive.shouldBe(Condition.visible);
        resultTable.resultTableHeader.shouldBe(Condition.text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationPage checkResultPageValue(String key,String expectedValue){
        resultTable.verifyResultTableParameter(key,expectedValue);
        return this;
    }


}
