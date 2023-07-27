package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    SelenideElement
        monthInput = $("#dateOfBirth-wrapper").$(".react-datepicker__month-select"),
        yearInput = $("#dateOfBirth-wrapper").$(".react-datepicker__year-select");
    @Step("Установить значение даты: День: {day}/ Месяц: {month}/ Год: {year}\" в календаре")
    public void setDate(String day, String month, String year) {
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        $$(".react-datepicker__day").get(Integer.parseInt(day)).click();
//        $(".react-datepicker__day--0" + day +
//                ":not(.react-datepicker__day--outside-month)").click();
    }
}
