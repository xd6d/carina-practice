package com.solvd.carinapractice.olx;

import com.solvd.carinapractice.olx.components.CardComponent;
import com.solvd.carinapractice.olx.pages.FavouritesPage;
import com.solvd.carinapractice.olx.pages.HomePage;
import com.solvd.carinapractice.olx.pages.LoginPage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WebOlxTest extends AbstractTest {

    @Test(description = "test-case 1")
    void verifyLoginWithUnregisteredEmailTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();
        homePage.goToProfile();

        String unregisteredEmail = R.TESTDATA.get("unregisteredEmail");
        String password = R.TESTDATA.get("password");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.assertPageOpened();
        Assert.assertFalse(loginPage.isUnregisteredEmailErrorMessagePresent(2), "Error message should not be present yet");

        loginPage.login(unregisteredEmail, password);

        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .withMessage("Login attempt timeout")
                .until(d -> loginPage.isLoginButtonClickable());

        Assert.assertTrue(loginPage.isUnregisteredEmailErrorMessagePresent(10), "Error message must occur");
    }

    @Test(description = "test-case 2")
    void verifyAddingFavouritesTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();
        homePage.dismissCookie();

        List<String> exceptedIds = new ArrayList<>();
        homePage.getAds()
                .stream()
                .limit(3)
                .forEach(c -> {
                    exceptedIds.add(c.getId());
                    String colorBefore = c.getHeartIconColor();
                    c.clickHeartIcon();
                    Assert.assertNotEquals(c.getHeartIconColor(), colorBefore, "Heart icon color has not changed");
                });

        homePage.clickFavourites();

        FavouritesPage favouritesPage = new FavouritesPage(getDriver());
        favouritesPage.clickAds();

        Assert.assertEquals(favouritesPage.getAds().size(), exceptedIds.size(), "Amount of added ads does not match.");

        Assert.assertTrue(exceptedIds.containsAll(favouritesPage.getAds().stream().map(CardComponent::getId).toList()),
                "Ads does not match");
    }
}
