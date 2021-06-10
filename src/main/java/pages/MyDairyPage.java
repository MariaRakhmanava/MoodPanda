package pages;

import static com.codeborne.selenide.Selenide.$$;

public class MyDairyPage {

    public static final String MOOD_RATE_CSS = ".badge.pull-right";

    public String getMoodRateText(int numberOfMoodRecord) {
        return $$(MOOD_RATE_CSS).get(numberOfMoodRecord).getText();
    }
}
