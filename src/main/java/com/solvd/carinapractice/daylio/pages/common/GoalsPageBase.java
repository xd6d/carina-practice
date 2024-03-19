package com.solvd.carinapractice.daylio.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GoalsPageBase extends AbstractPage {
    protected GoalsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getFirstGoalTitle();
}
