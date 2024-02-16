package com.solvd.carinapractice.daylio.pages.android;

import com.solvd.carinapractice.daylio.pages.common.HomePageBase;
import com.solvd.carinapractice.daylio.pages.common.MoodPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//*[contains(@resource-id, 'plus_button_icon')]")
    private ExtendedWebElement plusButton;

    private ExtendedWebElement moreButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'btn_today')]")
    private ExtendedWebElement todayButton;

    private ExtendedWebElement newGoalButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'container_entries')]/child::*[1]//*[contains(@resource-id, 'text_mood')]")
    private ExtendedWebElement newestMoodName;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickPlusButton() {
        plusButton.click(2);
    }

    @Override
    public MoodPageBase clickTodayButton() {
        todayButton.click(2);
        return new MoodPage(getDriver());
    }

    @Override
    public String getNewestMoodName() {
        return newestMoodName.getText();
    }
}
