package com.solvd.carinapractice.daylio.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ActivityGroupsPageBase extends AbstractPage {
    public ActivityGroupsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ActivityFolderPageBase clickOtherFolder();
}
