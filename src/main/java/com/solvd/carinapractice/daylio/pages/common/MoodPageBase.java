package com.solvd.carinapractice.daylio.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MoodPageBase extends AbstractPage {

    protected MoodPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void setMoodPosition(int position);

    public abstract MoodDetailsPageBase clickMood();

    public abstract String getMoodName();
}
