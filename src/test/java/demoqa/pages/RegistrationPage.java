package demoqa.pages;

import com.codeborne.selenide.Condition;
import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.ResultTableComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private String PAGE_NAME = "/automation-practice-form";
    private CalendarComponent calendar = new CalendarComponent();
    private ResultTableComponent resultTable = new ResultTableComponent();

    @Step("Открыть страницу {this.PAGE_NAME}")
    public RegistrationPage openPage(){
        open(PAGE_NAME);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Ввести значение \"{firstName}\" в поле FirstName")
    public RegistrationPage setFirstName(String firstName){
        $("#firstName").setValue(firstName);
        return this;
    }

    @Step("Ввести значение \"{lastName}\" в поле LastName")
    public RegistrationPage setLastName(String lastName){
        $("#lastName").setValue(lastName);
        return this;
    }
    @Step("Ввести значение \"{email}\" в поле Email")
    public RegistrationPage setEmail(String email){
        $("#userEmail").setValue(email);
        return this;
    }
    @Step("Выбрать значение гендера \"{gender}\"")
    public RegistrationPage setGender(String gender){
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }
    @Step("Ввести значение \"{phone}\" в поле Phone")
    public RegistrationPage setPhone(String phone){
        $("#userNumber").setValue(phone);
        return this;
    }
    @Step("Установить значение даты: Месяц: {month} День: {day} Год: {year} в календаре")
    public RegistrationPage setBirthDate(String month,int day,String year){
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $$(".react-datepicker__day").filterBy(Condition.text(Integer.toString(day))).first().click();
        return this;
    }
    @Step("Выбрать значение \"{subject}\" в поле Subject")
    public RegistrationPage setSubject(String subject){
        $("#subjectsInput").setValue("English").pressEnter();
        return this;
    }
    @Step("Выбрать значение \"{hobbie}\" в поле Hobby")
    public RegistrationPage setHobbie(String hobbie){
        $("#hobbiesWrapper").$(byText(hobbie)).click();
        return this;
    }
    @Step("Выбрать изображение \"{filepath}\" для аватара профиля")
    public RegistrationPage setAvatar( String filepath){
        $("#uploadPicture").uploadFromClasspath(filepath);
        return this;
    }
    @Step("Ввести значение \"{address}\" в поле Address")
    public RegistrationPage setAddress(String address){
        $("#currentAddress").setValue(address);
        return this;
    }
    @Step("Выбрать значение/-я \"{stateAndCity}\"")
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
    @Step("Подтвердить отправку формы")
    public RegistrationPage submit(){
        $("#submit").click();
        return this;
    }
    @Step("Проверить, что после отправки формы, отображается модальное окно с результатами")
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
