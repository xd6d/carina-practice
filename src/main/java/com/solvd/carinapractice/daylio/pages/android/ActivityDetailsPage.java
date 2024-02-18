package com.solvd.carinapractice.daylio.pages.android;

import com.solvd.carinapractice.daylio.pages.common.ActivityDetailsPageBase;
import com.solvd.carinapractice.daylio.pages.common.ActivityFolderPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ActivityDetailsPage extends ActivityDetailsPageBase {

    @FindBy(id = "net.daylio:id/primary_button")
    private ExtendedWebElement saveButton;

    public ActivityDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ActivityFolderPageBase clickSave() {
        saveButton.click(2);
        return new ActivityFolderPage(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return saveButton.isElementPresent(5);
    }
}
