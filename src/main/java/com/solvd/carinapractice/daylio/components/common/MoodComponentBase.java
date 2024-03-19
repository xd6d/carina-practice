package com.solvd.carinapractice.daylio.components.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class MoodComponentBase extends AbstractUIObject {
    protected MoodComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void clickMood();

    public abstract String getMoodName();

    public abstract String getNote();
}
