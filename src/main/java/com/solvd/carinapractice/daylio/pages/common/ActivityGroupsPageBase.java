package com.solvd.carinapractice.daylio.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ActivityGroupsPageBase extends AbstractPage {
    protected ActivityGroupsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ActivityFolderPageBase clickFolder(String name);
}
