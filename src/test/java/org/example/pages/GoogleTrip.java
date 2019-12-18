package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class GoogleTrip {
    private final static SelenideElement googleAvia =
            $x("//div[@class= \"gws-travel-header__main-content " + "Npuxu" + "\"]/div[2]/div/div[2]/div/div");

    public GoogleTrip() {
        googleAvia.shouldBe(Condition.visible);
    }

    @Step("Получение результата")
    public String result() {
        return googleAvia.getText();
    }
}
