package com.solvd.carinapractice.daylio.pages.android;

import com.solvd.carinapractice.daylio.pages.common.GoalsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GoalsPage extends GoalsPageBase {

    @FindBy(xpath = "//*[@text='Start a New Challenge']")
    private ExtendedWebElement challengesTitle;

    @FindBy(xpath = "(//*[contains(@resource-id, 'text_name')])[1]")
    private ExtendedWebElement firstGoalTitle;

    public GoalsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getFirstGoalTitle() {
        return firstGoalTitle.getText();
    }

    @Override
    public boolean isPageOpened() {
        return challengesTitle.isElementPresent(5);
    }
}
