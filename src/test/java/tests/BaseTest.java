package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    LoginPage loginPage;
    FeedPage feedPage;
    RateYourHappinessModalPage rateYourHappinessModalPage;
    MyDairyPage myDairyPage;
    MoodUpdatedModalPage moodUpdatedModalPage;

    @BeforeMethod
    public void setUp() {
        Configuration.browser="chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;
        loginPage = new LoginPage();
        feedPage = new FeedPage();
        rateYourHappinessModalPage = new RateYourHappinessModalPage();
        myDairyPage = new MyDairyPage();
        moodUpdatedModalPage = new MoodUpdatedModalPage();
    }

    /*@AfterMethod
    public void closeBrowser() {
        getWebDriver().quit();
    }*/
}
