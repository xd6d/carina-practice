package com.solvd.carinapractice.daylio.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ChallengeDetailsPageBase extends AbstractPage {
    public ChallengeDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SuggestionDetailsPageBase clickFirstSuggestion();

    public abstract String getFirstSuggestionName();
}
