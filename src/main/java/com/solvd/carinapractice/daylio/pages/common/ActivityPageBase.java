package com.solvd.carinapractice.daylio.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ActivityPageBase extends AbstractPage {
    public ActivityPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeName(String name);

    public abstract ActivityDetailsPageBase clickNext();
}
