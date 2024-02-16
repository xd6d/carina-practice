package com.solvd.carinapractice.daylio.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MoodDetailsPageBase extends AbstractPage {
    public MoodDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HomePageBase saveMood();

    public abstract void addNote(String note);
}
