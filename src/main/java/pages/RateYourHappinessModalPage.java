package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RateYourHappinessModalPage {

    public static final String SLIDER_CSS = ".ui-slider-handle";
    public static final String UPDATE_MOOD_BUTTON = ".ButtonUpdate";
    public static final String CALENDAR_CSS = ".ui-datepicker-trigger";
    public static final String YEAR_IN_CALENDAR_CSS = ".ui-datepicker-year";
    public static final String MONTH_IN_CALENDAR_CSS = "[data-handler='selectMonth']";
    public static final String DAY_IN_CALENDAR_XPATH = "//a[contains(text(),'%s')]";
    public static final String HOURS_CSS = "#ddlHistoricHour";
    public static final String MINUTES_CSS = "#ddlHistoricMinute";
    public static final String CANCEL_BUTTON_XPATH = "//*[contains(text(),'Cancel')]";
    public static final String HUG_BUTTON_CSS = ".ButtonHug";

    public RateYourHappinessModalPage updateMood(int moodValue) {
        $(SLIDER_CSS).click();
        int defaultMoodValue = 5;
        Keys direction = null;
        if (moodValue > defaultMoodValue) {
            direction = Keys.ARROW_RIGHT;
        } else if (moodValue < defaultMoodValue){
            direction = Keys.ARROW_LEFT;
        }
        if (moodValue != defaultMoodValue) {
            for (int i = 0; i < Math.abs(moodValue - defaultMoodValue); i++) {
                $(SLIDER_CSS).sendKeys(direction);
            }
        }
        return this;
    }

    public RateYourHappinessModalPage setDate(String month, String day, String year) {
        $(CALENDAR_CSS).click();
        $(YEAR_IN_CALENDAR_CSS).selectOptionByValue(year);
        $(MONTH_IN_CALENDAR_CSS).selectOptionContainingText(month.substring(0, 3));
        $(By.xpath(String.format(DAY_IN_CALENDAR_XPATH, day))).click();
        return this;
    }

    public MoodUpdatedModalPage clickUpdateMoodToNButton() {
        $(UPDATE_MOOD_BUTTON).click();
        return new MoodUpdatedModalPage();
    }

    public FeedPage clickCancelButton() {
        $(By.xpath(CANCEL_BUTTON_XPATH)).click();
        return new FeedPage();
    }

    public FeedPage sendHug(int addressee) {
        $$(HUG_BUTTON_CSS).get(addressee).click();
        return new FeedPage();
    }

}
