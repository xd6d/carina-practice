package com.solvd.carinapractice.daylio.pages.android;

import com.solvd.carinapractice.daylio.pages.common.ActivityFolderPageBase;
import com.solvd.carinapractice.daylio.pages.common.ActivityPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ActivityFolderPage extends ActivityFolderPageBase implements IMobileUtils {

    @FindBy(id = "net.daylio:id/button_primary")
    private ExtendedWebElement createNewActivityButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'name') and @text='%s']")
    private ExtendedWebElement activityByNameElement;

    public ActivityFolderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ActivityPageBase clickCreateNewActivity() {
        createNewActivityButton.click(2);
        return new ActivityPage(getDriver());
    }

    @Override
    public boolean isActivityPresentByName(String name) {
        ExtendedWebElement formatted = activityByNameElement.format(name);
        swipe(formatted);
        return formatted.isElementPresent(5);
    }

    @Override
    public boolean isPageOpened() {
        return createNewActivityButton.isElementPresent(5);
    }
}
