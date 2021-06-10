package pages;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class MoodUpdatedModalPage {

    public static final String GO_TO_MY_DAIRY_BUTTON_CSS = ".ButtonMyDiary";

    public MyDairyPage clickGoToMyDairyButton() {
        $(GO_TO_MY_DAIRY_BUTTON_CSS).click();
        return new MyDairyPage();
    }

    public WebElement getGoToMyDairyButton() {
        return $(GO_TO_MY_DAIRY_BUTTON_CSS);
    }
}
