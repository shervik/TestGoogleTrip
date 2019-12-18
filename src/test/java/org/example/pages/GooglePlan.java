package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GooglePlan {
    private static SelenideElement direction = $(By.tagName("travel-filter-bar"));
    private static SelenideElement dates = $x("//*[@id=\"t-date-selector\"]");

    private static SelenideElement whenceLink = $x("//div[text()='Укажите пункт отправления']");
    private static SelenideElement whenceInput = $x("//input[@placeholder='Укажите пункт отправления']");
    private static SelenideElement whenceList = $x("//ul[@role = 'listbox']/li[1]");

    private static SelenideElement countPeople = $x("//label[text() = 'Туристов']/following-sibling::g-dropdown-menu");
    private static SelenideElement transplant = $x("//label[text() = 'Пересадки (самолет)" + "']/following-sibling::g"
            + "-dropdown-menu");
    private static SelenideElement duration =
            $x("//label[text() = 'Длительность " + "пребывания']/following-sibling" + "::g-dropdown-menu");
    private static SelenideElement stars = $x("//label[text() = 'Класс гостиницы']/following-sibling::g-dropdown-menu");

    private static String setCount(int i) {
        return String.format("//*[@id=\"lb\"]/div/g-menu/g-menu-item[@data-val='%s']", i);
    }

    public GooglePlan() {
        direction.shouldBe(Condition.visible);
    }

    public GoogleCalendar googleCalendar() {
        return new GoogleCalendar();
    }

    @Step("Выбор направления: \"{s}\"")
    public void selectDirection(String s) {
        whenceLink.click();
        whenceInput.val(s);
        whenceList.click();
    }

    @Step("Выбор даты")
    public void visibleCalendar() {
        dates.click();
    }

    public SelenideElement getResult() {
        return $(By.className("gws-trips-desktop__bar-summary-box"));
    }

    @Step("Выбор количества туристов: \"{i}\"")
    public void selectPeople(int i) {
        countPeople.click();
        $x(setCount(i)).click();
    }

    @Step("Выбор количества пересадок: \"{i}\"")
    public void selectTrans(int i) {
        transplant.click();
        $x(setCount(i)).click();
    }

    @Step("Выбор длительности пребывания: \"{i}\"")
    public void selectDuration(int i) {
        duration.click();
        $x(setCount(i)).click();
    }

    @Step("Выбор класса гостиниц: \"{i}\"")
    public void selectStars(int i) {
        stars.click();
        $x(setCount(i)).click();
    }
}
