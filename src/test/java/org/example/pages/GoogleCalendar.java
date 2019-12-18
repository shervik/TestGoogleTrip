package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class GoogleCalendar {
    private static SelenideElement calendar = $(By.tagName("two-month-calendar"));
    private static SelenideElement doneBtn = $x("//*[text() = 'Готово']/parent::*");

    public GoogleCalendar() {
        calendar.shouldBe(Condition.visible);
    }

    @Step("Установить дату")
    public SelenideElement setDate(String date) {
        String s = String.format("//calendar-day[@data-day = '%s']", date);
        return $x(s);
    }

    @Step("Нажатие на кнопку \"Готово\"")
    public void pressBtn() {
        doneBtn.click();
    }
}
