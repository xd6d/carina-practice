package com.solvd.carinapractice.olx;

import com.solvd.carinapractice.olx.components.CardComponent;
import com.solvd.carinapractice.olx.pages.FavouritesPage;
import com.solvd.carinapractice.olx.pages.HomePage;
import com.solvd.carinapractice.olx.pages.LoginPage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebOlxTest extends AbstractTest {

    private static final String UNREGISTERED_EMAIL = R.TESTDATA.get("unregisteredEmail");
    private static final String PASSWORD = R.TESTDATA.get("password");

    @Test(description = "test-case 1")
    void verifyLoginWithUnregisteredEmailTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();
        homePage.goToProfile();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.assertPageOpened();
        Assert.assertFalse(loginPage.isUnregisteredEmailErrorMessagePresent(2), "Error message should not be present yet");

        boolean isLoginSuccess = loginPage.login(UNREGISTERED_EMAIL, PASSWORD);
        Assert.assertTrue(isLoginSuccess, "Login attempt timeout");
        Assert.assertTrue(loginPage.isUnregisteredEmailErrorMessagePresent(10), "Error message does not present");
    }

    @Test(description = "test-case 2")
    void verifyAddingFavouritesTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();
        homePage.dismissCookie();

        List<String> exceptedIds = new ArrayList<>();
        homePage.getAdvertisements()
                .stream()
                .limit(3)
                .forEach(c -> {
                    exceptedIds.add(c.getId());
                    String colorBefore = c.getHeartIconColor();
                    c.clickHeartIcon();
                    Assert.assertNotEquals(c.getHeartIconColor(), colorBefore, "Heart icon color has not changed");
                });

        FavouritesPage favouritesPage = homePage.clickFavourites();
        favouritesPage.clickAds();
        favouritesPage.assertPageOpened();

        Assert.assertEquals(favouritesPage.getAdvertisements().size(), exceptedIds.size(), "Amount of added ads does not match.");

        Assert.assertTrue(exceptedIds.containsAll(favouritesPage.getAdvertisements().stream().map(CardComponent::getId).toList()),
                "Ads does not match");
    }
}
