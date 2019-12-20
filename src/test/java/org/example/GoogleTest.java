package org.example;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(glue = {"org.example.steps", "org.example.hooks"}, features = "src/test/resources/features"
//        tags = {"@mul"}
)

public class GoogleTest extends AbstractTestNGCucumberTests {
//    @AfterTest
//    public void getScreenshot() throws IOException {
//        saveScreenshot(Files.readAllBytes(Selenide.$("body").screenshot().toPath()));
//
//    }
//
//    @Attachment(value = "Скриншот", type = "image/png")
//    public byte[] saveScreenshot(byte[] screenShot) {
//        return screenShot;
//    }

}
