package com.solvd.carinapractice.daylio.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ActivityDetailsPageBase extends AbstractPage {
    protected ActivityDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ActivityFolderPageBase clickSave();
}
