package com.solvd.carinapractice.daylio.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ChallengesPageBase extends AbstractPage {
    protected ChallengesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ChallengeDetailsPageBase clickFirstChallenge();
}
