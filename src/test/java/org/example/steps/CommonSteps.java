package org.example.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.ru.*;
import org.example.pages.GooglePlan;
import org.example.pages.ResultPage;
import org.example.pages.StartGoogleTripPage;
import org.testng.Assert;

import java.time.LocalDate;

public class CommonSteps {
    StartGoogleTripPage googleTrip;
    GooglePlan resultPage;
    String nameTrip;

    @Дано("страница Гугл с поиском направления путешествия")
    public void страницаГуглСПоискомНаправленияПутешествия() {
        googleTrip = new StartGoogleTripPage();
    }

    @Если("набрать на клавиатуре {string}")
    public void набратьНаКлавиатуре(String exp) {
        nameTrip = exp;
        googleTrip.search(exp);
    }

    @Тогда("откроется страница с описанием путешествия")
    public void откроетсяСтраницаСОписаниемНаправления() {
        final String result = googleTrip.newPage().googleTrip().result();
        Assert.assertEquals(result, nameTrip, "Не соответствует запросу!");
    }

    @Если("нажать на кнопку [Планирование поездок]")
    public void нажатьНаКнопкуПланированиеПоездок() {
        resultPage = new ResultPage().googlePlan();
    }

    @Тогда("можно выбрать отправную точку: {string}")
    public void можноВыбратьОтправнуюТочку(String dir) {
        resultPage.selectDirection(dir);
    }

    @Также("установить даты путешествия: {stringDate} и {stringDate}")
    public void установитьДатыПутешествия(LocalDate dateFrom, LocalDate dateTo) {
        resultPage.visibleCalendar();

        resultPage.googleCalendar().setDate(dateFrom).click();
        resultPage.googleCalendar().setDate(dateTo).click();
        resultPage.googleCalendar().pressBtn();
    }

    @И("другие критерии: {int} и {int}")
    public void другиеКритерии(int countPeople, int countStars) {
        resultPage.selectPeople(countPeople);
        resultPage.selectStars(countStars);
        Selenide.sleep(2000);
        Assert.assertTrue(resultPage.getResult().is(Condition.visible));
    }
}
