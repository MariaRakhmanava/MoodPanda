package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FeedPage {

    public static final String UPDATE_MOOD_BUTTON_CSS = "#LinkUpdate";

    public RateYourHappinessModalPage clickUpdateMoodButton() {
        $(UPDATE_MOOD_BUTTON_CSS).click();
        return new RateYourHappinessModalPage();
    }

    public FeedPage waitForUpdateMoodButtonIsVisible() {
        $(UPDATE_MOOD_BUTTON_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public WebElement getUpdateMoodButton() {
        return $(UPDATE_MOOD_BUTTON_CSS);
    }
}
