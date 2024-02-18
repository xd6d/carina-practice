package com.solvd.carinapractice.daylio.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SuggestionDetailsPageBase extends AbstractPage {
    public SuggestionDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract GoalsPageBase clickStartGoal();
}
