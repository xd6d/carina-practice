package com.solvd.carinapractice.daylio.pages.android;

import com.solvd.carinapractice.daylio.pages.common.HomePageBase;
import com.solvd.carinapractice.daylio.pages.common.MoodDetailsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MoodDetailsPageBase.class)
public class MoodDetailsPage extends MoodDetailsPageBase implements IMobileUtils {

    @FindBy(xpath = "//*[contains(@resource-id, 'layout_bottom_save')]")
    private ExtendedWebElement saveButton;

    public MoodDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePageBase saveMood() {
        swipe(saveButton);
        saveButton.click(3);
        return new HomePage(getDriver());
    }
}
