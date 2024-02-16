package com.solvd.carinapractice.daylio.pages.android;

import com.solvd.carinapractice.daylio.pages.common.ChallengeDetailsPageBase;
import com.solvd.carinapractice.daylio.pages.common.SuggestionDetailsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ChallengeDetailsPage extends ChallengeDetailsPageBase {

    @FindBy(xpath = "(//*[contains(@resource-id, 'container')]//*[contains(@resource-id, 'card_goal')])[1]")
    private ExtendedWebElement firstSuggestionElement;

    @FindBy(xpath = "(//*[contains(@resource-id, 'container')]//*[contains(@resource-id, 'card_goal')])[1]//android.widget.TextView")
    private ExtendedWebElement firstSuggestionName;

    public ChallengeDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SuggestionDetailsPageBase clickFirstSuggestion() {
        firstSuggestionElement.click(2);
        return new SuggestionDetailsPage(getDriver());
    }

    @Override
    public String getFirstSuggestionName() {
        return firstSuggestionName.getText();
    }

    @Override
    public boolean isPageOpened() {
        return firstSuggestionElement.isElementPresent(5);
    }
}
