package com.solvd.carinapractice.daylio.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MorePageBase extends AbstractPage {
    protected MorePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ActivityGroupsPageBase clickEditActivities();
}
