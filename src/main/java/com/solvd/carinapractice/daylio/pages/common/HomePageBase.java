package com.solvd.carinapractice.daylio.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    protected HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickPlusButton();

    public abstract MoodPageBase clickTodayButton();

    public abstract void clickNewestMood();

    public abstract void clickContextMenuDelete();

    public abstract MoodPageBase clickContextMenuEdit();

    public abstract void clickPopupDelete();

    public abstract String getNewestMoodName();

    public abstract String getNewestMoodNote();

    public abstract int getTodayMoodsAmount();

    public abstract ChallengesPageBase clickNewGoalButton();

    public abstract MorePageBase clickMoreButton();
}
