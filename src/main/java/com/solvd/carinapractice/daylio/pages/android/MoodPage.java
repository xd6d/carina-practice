package com.solvd.carinapractice.daylio.pages.android;

import com.solvd.carinapractice.daylio.pages.common.MoodDetailsPageBase;
import com.solvd.carinapractice.daylio.pages.common.MoodPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MoodPageBase.class)
public class MoodPage extends MoodPageBase {

    @FindBy(xpath = "//*[contains(@resource-id, 'mood_picker')]/child::*[%d]")
    private ExtendedWebElement moodButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'mood_picker')]/child::*[%d]/android.widget.TextView")
    private ExtendedWebElement moodName;

    private int position = 1;

    public MoodPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void setMoodPosition(int position) {
        this.position = position;
    }

    @Override
    public MoodDetailsPageBase clickMood() {
        moodButton.format(position).click();
        return new MoodDetailsPage(getDriver());
    }

    @Override
    public String getMoodName() {
        return moodName.format(position).getText();
    }
}
