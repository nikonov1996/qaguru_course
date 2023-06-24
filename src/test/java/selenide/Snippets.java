package selenide;

import com.codeborne.selenide.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Snippets {

    void browser_common_examples(){
        // браузер по умолчанию открывается в режиме инкогнито
        open("https://www.ozon.ru/");
        open("/category/elektronika-15500"); // -Dselenide.baseUrl=https://www.ozon.ru/
        open("/", AuthenticationType.BASIC, new BasicAuthCredentials("","user","pass"));


        Selenide.back(); // вернуться на предыдущую страницу
        Selenide.refresh(); // обновление страницы

        // После выполнения этих команд нужно обновить страницу
        Selenide.clearBrowserCookies(); // почистить куки
        Selenide.clearBrowserLocalStorage(); // почистить локальное хранилище
        executeJavaScript("sessionStorage.clear();"); // почистить сессию с помощью javascript

        Selenide.confirm(); // алерт диалоговое окно, нажать подтвердить
        Selenide.dismiss(); // алерт диалоговое окно , нажать отменить

        // Работа с окнами и фреймами (страничка в страничке, может быть вложенность) Если просто искать по странице , то элемент не будет найден, нужно перейти во фрейм сначала
        Selenide.closeWindow(); // закрыть текущее окно на котором находимся в данный момент
        Selenide.closeWebDriver(); // закрыть драйвер
        Selenide.switchTo().frame("new"); // переход на фрейм
        Selenide.switchTo().defaultContent(); // возвращает обратно из фрейма,на основную страницу DOM
        Selenide.switchTo().window("New window"); // переход на окно по названию заголовка окна

        // Как передать куки в браузер. После установки надо перезагрузить страницу
        Cookie cookie = new Cookie("foo","bar");
        Cookie cookie1 = new Cookie("foo","bar","",new Date(2023,7,20));
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("foo"); // удаление куки по названию

    }

    void selectors_examples() {

        $("div").click();
        element("div").click();
        $("div",2).click(); // кликнуть третий найденный элемент с локатором див

        $x("//h1/div"); // xpath
        $(byXpath("//h1/div")).click();

        $(byText("text")).click(); // текст должен совпадать
        $(withText("text")).click(); // текст должен содержаться

        $(byTagAndText("div","text")); // текст в указанном элементе должен совпадать
        $(withTagAndText("div", "text")); // элемент должен содержать в себе текст

        // ldb;t
        $("").parent(); // родитель
        $("").sibling(0); // выбор следующего элемента стоящего рядом
        $("").preceding(0); // выбор предыдущего элемента стоящего рядом
        $("").closest("div"); // ближайший указаный элемент выше по иерархии
        $("").ancestor("div"); // ближайший указаный элемент выше по иерархии
        $("").ancestor("div",1); // ближайший указаный элемент выше по иерархии
        $("div:last-child"); // последний элемент внутри элемента

        // Можно строить цепочки. $ == find , но с find нельзя начинать
        $("div").$x(".//h2").find(byText("text")).click(); // смешаный поиск

        // По атрибутам
        $(byAttribute("tag","text")).click();
        $("div [tag=text]").click();

        // By ID
        $(byId("text")).click();
        $("#id_name").click();

        // By class
        $(byClassName("text")).click();
        $(".class_name").click();
    }

    void actions_examples(){
        $("").click();
        $("").doubleClick();
        $("").contextClick(); // правая клавиша мыши

        $("").hover();

        $("").setValue("text");
        $("").append("text"); // добавит текст в конец
        $("").clear(); // не всегда срабатывает
        $("").setValue(""); // поле очищается и добавляется текст

        $("div").sendKeys("c"); // нажать клавишу 'с' на элементе
        actions().sendKeys("c").perform(); // нажать клавишу 'с' на всю страницу
        actions().sendKeys(Keys.chord(Keys.CONTROL,"f")).perform(); // CTRL+F
        $("html").sendKeys(Keys.chord(Keys.CONTROL,"f")); // CTRL+F

        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();

        // Цепочка действий DrugAndDrop:
        // 1. Передвинуть мышку к элементу
        // 2. Кликнуть и не отпускать
        // 3. Передвинуть элемент по координатам 300 вправо и 200 вниз
        // 4. Отпустить клавишу мыши
        // Такие действия важно начинать с actions() и заканчивать perform()
        actions().moveToElement($("div")).clickAndHold().moveByOffset(300,200).release().perform();

        // Для выбора элемента выпадающего списка и радиокнопки
        $("").selectOption("");
        $("").selectRadio("");
    }

    void assertions_examples(){

        $("").shouldBe(Condition.visible);
        $("").shouldNotBe(Condition.visible);
        $("").shouldHave(Condition.text("text"));
        $("").shouldNotHave(Condition.text("text"));
        $("").should(Condition.appear);
        $("").shouldNot(Condition.appear);

        // таймаут 4 секунды по дефолту
        // элемент должен быть видимым через 30 секунд:
        $("").shouldBe(Condition.visible, Duration.ofSeconds(30));

    }

    void conditions_examples(){

        // Видимость
        $("").shouldBe(Condition.visible);
        $("").shouldBe(Condition.hidden);

        // Условия с текстом
        $("").shouldHave(Condition.text("")); // подстрока
        $("").shouldHave(Condition.exactText("")); // полное совпадение
        $("").shouldHave(Condition.textCaseSensitive("")); // содержит подстроку с учетом регистра
        $("").shouldHave(Condition.exactTextCaseSensitive("")); // полное совпадение текста с учетом регистра
        $("").should(Condition.matchText("[0-9]abc$")); // проверка с регуляркой


        $("").shouldHave(Condition.cssClass("red"));
        $("").shouldHave(Condition.cssValue("font-size","12"));

        // Значение в поле
        $("").shouldHave(Condition.value("25"));
        $("").shouldHave(Condition.exactValue("25"));
        $("").shouldBe(Condition.empty);

        $("").shouldHave(Condition.attribute("disabled"));
        $("").shouldHave(Condition.attribute("name","example"));
        $("").shouldHave(Condition.attributeMatching("name","[0-9]abc$")); // првоерка что атрибут соответвствует регулярному выражению

        $("").shouldBe(Condition.checked); // для чекбокса

        $("").should(Condition.exist); // проверяет что элемент есть в DOM, не обязательно видимый

        // Для проверки задизейбленного элемента. НО если элемент дизейблится без disabled, то проверка не сработает!
        $("").shouldBe(Condition.disabled);
        $("").shouldBe(Condition.enabled);

    }
}
