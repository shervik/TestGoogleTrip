package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ResultPage {
    private final static SelenideElement googlePlan =
            $x("//span[text() = 'Планирование " + "поездок']/parent::div" + "/parent::*");

    public ResultPage() {
        $(By.tagName("g-tabs")).shouldBe(Condition.visible);
    }

    public GoogleTrip googleTrip() {
        return new GoogleTrip();
    }

    @Step("Выбор планирования поездок")
    public GooglePlan googlePlan() {
        googlePlan.pressEnter();
        return new GooglePlan();
    }
}
