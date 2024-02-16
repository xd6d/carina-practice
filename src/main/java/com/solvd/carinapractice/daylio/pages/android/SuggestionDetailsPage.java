package com.solvd.carinapractice.daylio.pages.android;

import com.solvd.carinapractice.daylio.pages.common.GoalsPageBase;
import com.solvd.carinapractice.daylio.pages.common.SuggestionDetailsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SuggestionDetailsPage extends SuggestionDetailsPageBase {

    @FindBy(id = "net.daylio:id/button_rectangle_content")
    private ExtendedWebElement startGoalButton;

    public SuggestionDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoalsPageBase clickStartGoal() {
        startGoalButton.click(2);
        return new GoalsPage(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return startGoalButton.isElementPresent(5);
    }
}
