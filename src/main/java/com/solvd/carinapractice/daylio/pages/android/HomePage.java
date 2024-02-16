package com.solvd.carinapractice.daylio.pages.android;

import com.solvd.carinapractice.daylio.components.android.MoodComponent;
import com.solvd.carinapractice.daylio.pages.common.ChallengesPageBase;
import com.solvd.carinapractice.daylio.pages.common.HomePageBase;
import com.solvd.carinapractice.daylio.pages.common.MoodPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//*[contains(@resource-id, 'plus_button_icon')]")
    private ExtendedWebElement plusButton;

    private ExtendedWebElement moreButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'btn_today')]")
    private ExtendedWebElement todayButton;

    @FindBy(id = "net.daylio:id/btn_new_goal")
    private ExtendedWebElement newGoalButton;

    @FindBy(xpath = "(//*[contains(@resource-id, 'container_entries')])[1]/child::*")
    private List<MoodComponent> newestMoods;

    @FindBy(xpath = "//*[contains(@resource-id, 'context_menu_container')]//*[child::*[@text='Delete']]")
    private ExtendedWebElement contextMenuDeleteButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'buttonDefaultNeutral')]")
    private ExtendedWebElement popupDeleteButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'context_menu_container')]//*[child::*[@text='Edit']]")
    private ExtendedWebElement contextMenuEditButton;

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
    public void clickNewestMood() {
        newestMoods.get(0).clickMood();
    }

    @Override
    public void clickContextMenuDelete() {
        contextMenuDeleteButton.click(2);
    }

    @Override
    public MoodPageBase clickContextMenuEdit() {
        contextMenuEditButton.click(2);
        return new MoodPage(getDriver());
    }

    @Override
    public void clickPopupDelete() {
        popupDeleteButton.click(2);
    }

    @Override
    public String getNewestMoodName() {
        return newestMoods.get(0).getMoodName();
    }

    @Override
    public String getNewestMoodNote() {
        return newestMoods.get(0).getNote();
    }

    @Override
    public int getTodayMoodsAmount() {
        waitUntil(ExpectedConditions.visibilityOf(plusButton), 2);
        return newestMoods.size();
    }

    @Override
    public ChallengesPageBase clickNewGoalButton() {
        newGoalButton.click(2);
        return new ChallengesPage(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return plusButton.isElementPresent(5);
    }
}
