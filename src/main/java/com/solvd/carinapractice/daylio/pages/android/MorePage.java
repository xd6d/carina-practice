package com.solvd.carinapractice.daylio.pages.android;

import com.solvd.carinapractice.daylio.pages.common.ActivityGroupsPageBase;
import com.solvd.carinapractice.daylio.pages.common.MorePageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MorePage extends MorePageBase implements IMobileUtils {

    @FindBy(id = "net.daylio:id/goals_settings_item")
    private ExtendedWebElement goalsButton;

    @FindBy(id = "net.daylio:id/edit_activities_settings_item")
    private ExtendedWebElement editActivitiesButton;

    public MorePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ActivityGroupsPageBase clickEditActivities() {
        swipe(editActivitiesButton);
        editActivitiesButton.click(2);
        return new ActivityGroupsPage(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return goalsButton.isElementPresent(5);
    }
}
