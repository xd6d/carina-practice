package com.solvd.carinapractice.daylio.pages.android;

import com.solvd.carinapractice.daylio.pages.common.ChallengeDetailsPageBase;
import com.solvd.carinapractice.daylio.pages.common.ChallengesPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ChallengesPage extends ChallengesPageBase {

    @FindBy(id = "net.daylio:id/challenge_1")
    private ExtendedWebElement firstChallengeElement;

    public ChallengesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ChallengeDetailsPageBase clickFirstChallenge() {
        firstChallengeElement.click(2);
        return new ChallengeDetailsPage(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return firstChallengeElement.isElementPresent(5);
    }
}
