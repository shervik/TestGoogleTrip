package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import org.example.pages.GooglePlan;
import org.example.pages.ResultPage;
import org.example.pages.StartGoogleTripPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.nio.file.Files;

@Epic("Тестирование планирования путешествий")
public class GoogleTest {
    StartGoogleTripPage googleTrip;
    GooglePlan resultPage;

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{{"Москва"}, {"Мюнхен"}, {"Лондон"},};
    }

    @BeforeMethod(description = "Открытие страницы поиска направления")
    public void setUp() {
        googleTrip = new StartGoogleTripPage();
    }

    @Test(dataProvider = "data", description = "Проверка поиска")
    public void testSearch(String exp) {
        final String result = googleTrip.search(exp).googleTrip().result();

        Assert.assertEquals(result, exp);

        // YYYY-MM-dd
        testAvia("Казань", "2020-01-04", "2020-01-08", 2, 4);
    }

    public void testAvia(String dir, String dateFrom, String dateTo, int countPeople, int countStars) {
        resultPage = new ResultPage().googlePlan();
        resultPage.selectDirection(dir);
        resultPage.visibleCalendar();

        resultPage.googleCalendar().setDate(dateFrom).click();
        resultPage.googleCalendar().setDate(dateTo).click();
        resultPage.googleCalendar().pressBtn();

        resultPage.selectPeople(countPeople);
        resultPage.selectStars(countStars);

        Selenide.sleep(3000);

        Assert.assertTrue(resultPage.getResult().is(Condition.visible));
    }

    @AfterTest
    public void getScreenshot() throws IOException {
        String screen = Selenide.screenshot("screen");
        saveScreenshot(Files.readAllBytes(Selenide.$("body").screenshot().toPath()));

    }

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

}
