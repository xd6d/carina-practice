package com.solvd.carinapractice.daylio;

import com.solvd.carinapractice.daylio.pages.common.*;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DaylioTest extends AbstractTest implements IMobileUtils {

    private static final Logger LOGGER = LogManager.getLogger(DaylioTest.class);
    private static final String APP_PACKAGE = "net.daylio";
    private static final int MOOD_TO_CREATE = 1;
    private static final int MOOD_TO_EDIT = 3;
    private static final String NOTE = "Some note";
    private static final String NEW_ACTIVITY_NAME = "New activity name";

    @BeforeMethod
    public void startApp() {
        startApp(APP_PACKAGE);
    }

    @Test
    public void verifyCreateTodayMoodTest() {
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.clickPlusButton();
        MoodPageBase moodPage = homePage.clickTodayButton();
        Assert.assertTrue(moodPage.isPageOpened(), "Mood page is not opened!");

        moodPage.setMoodPosition(MOOD_TO_CREATE);
        String expectedMoodName = moodPage.getMoodName();
        MoodDetailsPageBase moodDetailsPage = moodPage.clickMood();
        Assert.assertTrue(moodDetailsPage.isPageOpened(), "Mood details page is not opened!");

        LOGGER.info("Mood with position %d and name '%s' has been chosen".formatted(MOOD_TO_CREATE, expectedMoodName));

        moodDetailsPage.saveMood();

        Assert.assertEquals(homePage.getNewestMoodName(), expectedMoodName, "Some other mood has been created!");
    }

    @Test(dependsOnMethods = "verifyCreateTodayMoodTest")
    public void verifyEditMoodTest() {
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.clickNewestMood();
        MoodPageBase moodPage = homePage.clickContextMenuEdit();
        Assert.assertTrue(moodPage.isPageOpened(), "Mood page is not opened!");

        moodPage.setMoodPosition(MOOD_TO_EDIT);
        String expectedMoodName = moodPage.getMoodName();
        MoodDetailsPageBase moodDetailsPage = moodPage.clickMood();
        Assert.assertTrue(moodDetailsPage.isPageOpened(), "Mood details page is not opened!");
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
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        int moodsAmountBefore = homePage.getTodayMoodsAmount();
        homePage.clickNewestMood();
        homePage.clickContextMenuDelete();
        homePage.clickPopupDelete();

        Assert.assertEquals(homePage.getTodayMoodsAmount(), moodsAmountBefore - 1, "Amount of moods is different!");
    }

    @Test
    public void verifyCreateGoal() {
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.clickPlusButton();
        ChallengesPageBase challengesPage = homePage.clickNewGoalButton();
        Assert.assertTrue(challengesPage.isPageOpened(), "Challenges page is not opened!");

        ChallengeDetailsPageBase challengeDetailsPage = challengesPage.clickFirstChallenge();
        Assert.assertTrue(challengeDetailsPage.isPageOpened(), "Challenges details page is not opened!");

        String expectedChallengeName = challengeDetailsPage.getFirstSuggestionName();
        SuggestionDetailsPageBase suggestionDetailsPage = challengeDetailsPage.clickFirstSuggestion();
        Assert.assertTrue(suggestionDetailsPage.isPageOpened(), "Suggestion page is not opened!");

        GoalsPageBase goalsPage = suggestionDetailsPage.clickStartGoal();
        Assert.assertTrue(goalsPage.isPageOpened(), "Goals page is not opened!");

        Assert.assertEquals(goalsPage.getFirstGoalTitle(), expectedChallengeName, "Expected challenge has not been created!");
    }

    @Test
    public void verifyCreateActivity() {
        HomePageBase homePage = initPage(HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        MorePageBase morePage = homePage.clickMoreButton();
        Assert.assertTrue(morePage.isPageOpened(), "More page is not opened!");

        ActivityGroupsPageBase activityGroupsPage = morePage.clickEditActivities();
        Assert.assertTrue(activityGroupsPage.isPageOpened(), "Activity groups page is not opened!");

        ActivityFolderPageBase otherFolderPage = activityGroupsPage.clickOtherFolder();
        Assert.assertTrue(otherFolderPage.isPageOpened(), "Other folder page is not opened!");

        ActivityPageBase activityPage = otherFolderPage.clickCreateNewActivity();
        Assert.assertTrue(activityPage.isPageOpened(), "Activity page is not opened!");

        activityPage.typeName(NEW_ACTIVITY_NAME);
        hideKeyboard();

        ActivityDetailsPageBase activityDetailsPage = activityPage.clickNext();
        Assert.assertTrue(activityDetailsPage.isPageOpened(), "Activity details page is not opened!");

        activityDetailsPage.clickSave();

        Assert.assertTrue(otherFolderPage.isActivityPresentByName(NEW_ACTIVITY_NAME), "New activity is not present!");
    }
}
