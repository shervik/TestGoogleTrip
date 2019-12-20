package org.example.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class StartGoogleTripPage {
    public StartGoogleTripPage() {
        open("https://www.google.com/travel");
    }

    @Step("Поиск рейса или отеля: \"{s}\"")
    public void search(String s) {
        $x("//input[@placeholder = 'Искать рейсы и отели']").val(s).pressEnter();
    }

    public ResultPage newPage() {
        return new ResultPage();
    }
}
