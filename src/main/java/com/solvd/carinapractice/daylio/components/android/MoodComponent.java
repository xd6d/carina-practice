package com.solvd.carinapractice.daylio.components.android;

import com.solvd.carinapractice.daylio.components.common.MoodComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MoodComponent extends MoodComponentBase {

    @FindBy(xpath = ".//*[contains(@resource-id, 'text_mood')]")
    private ExtendedWebElement moodName;

    @FindBy(xpath = ".//*[contains(@resource-id, 'text_time')]")
    private ExtendedWebElement moodTime;

    @FindBy(xpath = ".//*[contains(@resource-id, 'text_note')]")
    private ExtendedWebElement noteElement;

    public MoodComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void clickMood() {
        moodName.click(2);
    }

    @Override
    public String getMoodName() {
        return moodName.getText();
    }

    @Override
    public String getTime() {
        return moodTime.getText();
    }

    @Override
    public String getNote() {
        return noteElement.getText();
    }
}
