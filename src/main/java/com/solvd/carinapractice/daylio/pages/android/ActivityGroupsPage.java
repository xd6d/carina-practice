package com.solvd.carinapractice.daylio.pages.android;

import com.solvd.carinapractice.daylio.pages.common.ActivityFolderPageBase;
import com.solvd.carinapractice.daylio.pages.common.ActivityGroupsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ActivityGroupsPage extends ActivityGroupsPageBase {

    @FindBy(xpath = "//*[contains(@text, '%s')]")
    private ExtendedWebElement folderByName;

    @FindBy(id = "net.daylio:id/button_primary")
    private ExtendedWebElement addGroupButton;

    public ActivityGroupsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ActivityFolderPageBase clickFolder(String name) {
        folderByName.format(name).click(2);
        return new ActivityFolderPage(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return addGroupButton.isElementPresent(5);
    }
}
