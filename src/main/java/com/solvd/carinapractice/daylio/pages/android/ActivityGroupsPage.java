package com.solvd.carinapractice.daylio.pages.android;

import com.solvd.carinapractice.daylio.pages.common.ActivityFolderPageBase;
import com.solvd.carinapractice.daylio.pages.common.ActivityGroupsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ActivityGroupsPage extends ActivityGroupsPageBase {

    @FindBy(xpath = "//*[contains(@text, 'Other')]")
    private ExtendedWebElement otherFolder;

    public ActivityGroupsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ActivityFolderPageBase clickOtherFolder() {
        otherFolder.click(2);
        return new ActivityFolderPage(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return otherFolder.isElementPresent(5);
    }
}
