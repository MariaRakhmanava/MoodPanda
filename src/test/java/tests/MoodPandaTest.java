package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {

    public static final String LOGIN = "mrmoodpanda@mailinator.com";
    public static final String PASSWORD = "123456";

    @Test
    public void loginTest() {
        loginPage
                .openPage()
                .login(LOGIN, PASSWORD)
                .waitForUpdateMoodButtonIsVisible()
                .clickUpdateMoodButton()
                .updateMood(9)
                .clickUpdateMoodToNButton();
        Assert.assertEquals(myDairyPage.getMoodRateText(0), "9");
    }

    @Test
    public void setDateTest() {
        loginPage
                .openPage()
                .login(LOGIN, PASSWORD)
                .waitForUpdateMoodButtonIsVisible()
                .clickUpdateMoodButton()
                .setDate("January", "27", "2020")
                .clickUpdateMoodToNButton();
        Assert.assertTrue(moodUpdatedModalPage.getGoToMyDairyButton().isDisplayed());
    }

    @Test
    public void cancelTest() {
        loginPage
                .openPage()
                .login(LOGIN, PASSWORD)
                .clickUpdateMoodButton()
                .clickCancelButton();
        Assert.assertTrue(feedPage.getUpdateMoodButton().isDisplayed());
    }
}
