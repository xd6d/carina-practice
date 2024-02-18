package com.solvd.carinapractice.daylio.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ActivityFolderPageBase extends AbstractPage {
    public ActivityFolderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ActivityPageBase clickCreateNewActivity();

    public abstract boolean isActivityPresentByName(String name);
}
