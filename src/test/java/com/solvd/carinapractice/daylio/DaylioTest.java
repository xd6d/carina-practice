package com.solvd.carinapractice.daylio;

import com.solvd.carinapractice.daylio.pages.common.HomePageBase;
import com.solvd.carinapractice.daylio.pages.common.MoodDetailsPageBase;
import com.solvd.carinapractice.daylio.pages.common.MoodPageBase;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DaylioTest extends AbstractTest implements IMobileUtils {

    private static final Logger LOGGER = LogManager.getLogger(DaylioTest.class);
    private static final String PACKAGE_NAME = "net.daylio";
    private static final int MOOD_TO_CREATE = 1;
    private static final int MOOD_TO_EDIT = 3;
    private static final String NOTE = "Some note";

    @BeforeMethod
    public void startApp() {
        startApp(PACKAGE_NAME);
    }

    @Test
    public void verifyCreateTodayMoodTest() {
        HomePageBase homePage = initPage(HomePageBase.class);
        homePage.clickPlusButton();
        MoodPageBase moodPage = homePage.clickTodayButton();

        moodPage.setMoodPosition(MOOD_TO_CREATE);
        String expectedMoodName = moodPage.getMoodName();
        MoodDetailsPageBase moodDetailsPage = moodPage.clickMood();
        LOGGER.info("Mood with position %d and name '%s' has been chosen".formatted(MOOD_TO_CREATE, expectedMoodName));

        moodDetailsPage.saveMood();

        Assert.assertEquals(homePage.getNewestMoodName(), expectedMoodName, "Some other mood has been created!");
    }

    @Test(dependsOnMethods = "verifyCreateTodayMoodTest")
    public void verifyEditMoodTest() {
        HomePageBase homePage = initPage(HomePageBase.class);
        homePage.clickNewestMood();
        MoodPageBase moodPage = homePage.clickContextMenuEdit();

        moodPage.setMoodPosition(MOOD_TO_EDIT);
        String expectedMoodName = moodPage.getMoodName();
        MoodDetailsPageBase moodDetailsPage = moodPage.clickMood();
        LOGGER.info("Mood with position %d and name '%s' has been chosen".formatted(MOOD_TO_EDIT, expectedMoodName));
        moodDetailsPage.addNote(NOTE);
        hideKeyboard();

        moodDetailsPage.saveMood();

        Assert.assertEquals(homePage.getNewestMoodName(), expectedMoodName, "Some other mood has been saved!");
        Assert.assertEquals(homePage.getNewestMoodNote(), NOTE, "Mood's note is not as typed!");
    }

    @Test(dependsOnMethods = "verifyCreateTodayMoodTest", priority = 1)
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
