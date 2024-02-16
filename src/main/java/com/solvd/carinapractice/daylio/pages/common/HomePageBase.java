package com.solvd.carinapractice.daylio.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickPlusButton();

    public abstract MoodPageBase clickTodayButton();

    public abstract void clickNewestMood();

    public abstract void clickContextMenuDelete();

    public abstract void clickPopupDelete();

    public abstract String getNewestMoodName();

    public abstract int getTodayMoodsAmount();
}
