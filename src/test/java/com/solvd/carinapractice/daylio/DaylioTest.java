package com.solvd.carinapractice.daylio;

import com.solvd.carinapractice.daylio.pages.common.HomePageBase;
import com.solvd.carinapractice.daylio.pages.common.MoodDetailsPageBase;
import com.solvd.carinapractice.daylio.pages.common.MoodPageBase;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DaylioTest extends AbstractTest implements IMobileUtils {

    @BeforeMethod
    public void startApp() {
        startApp("net.daylio");
    }

    @Test
    public void verifyCreateTodayMoodTest() {
        HomePageBase homePage = initPage(HomePageBase.class);
        homePage.clickPlusButton();
        MoodPageBase moodPage = homePage.clickTodayButton();

        String expectedMoodName = moodPage.getMoodName();
        MoodDetailsPageBase moodDetailsPage = moodPage.clickMood();

        moodDetailsPage.saveMood();

        Assert.assertEquals(homePage.getNewestMoodName(), expectedMoodName, "Some other mood has been created!");
    }

    @Test(dependsOnMethods = "verifyCreateTodayMoodTest")
    public void verifyDeleteMoodTest() {
        HomePageBase homePage = initPage(HomePageBase.class);
        int moodsAmountBefore = homePage.getTodayMoodsAmount();
        homePage.clickNewestMood();
        homePage.clickContextMenuDelete();
        homePage.clickPopupDelete();

        Assert.assertEquals(homePage.getTodayMoodsAmount(), moodsAmountBefore-1, "Amount of moods is different!");

        //TODO create list before -> delete first entry -> create list after -> assertLists ?????
    }
}
