package com.solvd.carinapractice.daylio.pages.android;

import com.solvd.carinapractice.daylio.pages.common.ActivityDetailsPageBase;
import com.solvd.carinapractice.daylio.pages.common.ActivityPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ActivityPage extends ActivityPageBase {

    @FindBy(id = "net.daylio:id/text_name")
    private ExtendedWebElement textInput;

    @FindBy(id = "net.daylio:id/button_primary")
    private ExtendedWebElement nextButton;

    public ActivityPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeName(String name) {
        textInput.type(name);
    }

    @Override
    public ActivityDetailsPageBase clickNext() {
        nextButton.click(2);
        return new ActivityDetailsPage(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return nextButton.isElementPresent(5);
    }
}
