package com.solvd.carinapractice.olx;

import com.solvd.carinapractice.olx.components.CardComponent;
import com.solvd.carinapractice.olx.pages.*;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class WebOlxTest extends AbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(WebOlxTest.class);
    private static final String UNREGISTERED_EMAIL = R.TESTDATA.get("unregistered_email");
    private static final String PASSWORD = R.TESTDATA.get("password");
    private static final String SEARCH_INPUT = "airpods";
    private static final String BARTER = "Обмін";

    @BeforeMethod
    public void openWebPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();
        homePage.dismissCookie();
    }

    @DataProvider
    public Object[][] emailPasswordProvider() {
        return new Object[][]{
                {UNREGISTERED_EMAIL, PASSWORD},
                {"asd@asd.com", "asdasdasd"},
                {"asd", "asdasdasd"}
        };
    }

    @Test(dataProvider = "emailPasswordProvider")
    public void verifyLoginWithUnregisteredEmailTest(String email, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.goToProfile();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.assertPageOpened();
        Assert.assertFalse(loginPage.isUnregisteredEmailErrorMessagePresent(2), "Error message should not be present yet!");

        boolean isLoginSuccess = loginPage.login(email, password);

        Assert.assertTrue(isLoginSuccess, "Login attempt timeout!");
        Assert.assertTrue(loginPage.isUnregisteredEmailErrorMessagePresent(2), "Error message is not present!");
    }

    @Test
    public void verifyAddingFavouritesTest() {
        HomePage homePage = new HomePage(getDriver());

        List<String> exceptedIds = new ArrayList<>();
        homePage.getAdvertisements()
                .stream()
                .limit(3)
                .forEach(c -> {
                    exceptedIds.add(c.getId());
                    String colorBefore = c.getHeartIconColor();
                    c.clickHeartIcon();
                    Assert.assertNotEquals(c.getHeartIconColor(), colorBefore, "Heart icon color has not changed!");
                });

        FavouritesPage favouritesPage = homePage.clickFavourites();
        favouritesPage.clickSelectedAdsTab();
        favouritesPage.assertPageOpened();

        Assert.assertEquals(favouritesPage.getAdvertisements().size(), exceptedIds.size(), "Amount of added ads does not match!");

        Assert.assertTrue(exceptedIds.containsAll(favouritesPage.getAdvertisements().stream().map(CardComponent::getId).toList()),
                "Ads does not match!");
    }

    @Test
    public void verifyBasicAdvertisementInformationTest() {
        SoftAssert softAssert = new SoftAssert();

        HomePage homePage = new HomePage(getDriver());

        int advertisementIndex = new Random().nextInt(homePage.getAdvertisements().size());
        LOGGER.info("Chose advertisement with index %d".formatted(advertisementIndex));

        AdvertisementPage advertisementPage = homePage.getAdvertisements().get(advertisementIndex).clickAdvertisement();
        advertisementPage.assertPageOpened(5);

        softAssert.assertTrue(advertisementPage.isAdvertisementTitlePresent(), "Advertisement title is not present!");
        softAssert.assertTrue(advertisementPage.isContactButtonPresent(), "Contact button is not present!");
        softAssert.assertTrue(advertisementPage.isShowPhoneButtonPresent(), "Show phone button is not present!");
        softAssert.assertTrue(advertisementPage.isSellerNamePresent(), "Seller name is not present!");
        softAssert.assertTrue(advertisementPage.isDescriptionPresent(), "Description is not present!");

        softAssert.assertTrue(advertisementPage.isContactButtonClickable(), "Contact button is not clickable!");
        softAssert.assertTrue(advertisementPage.isShowPhoneButtonClickable(), "Show phone button is not clickable!");

        LOGGER.info("Advertisement title: " + advertisementPage.getAdvertisementTitle());
        LOGGER.info("Seller name: " + advertisementPage.getSellerName());

        softAssert.assertAll();
    }

    @Test
    public void verifySearchResultTest() {
        HomePage homePage = new HomePage(getDriver());

        homePage.typeSearch(SEARCH_INPUT);
        ListAdvertisementsPage advertisementsPage = homePage.executeSearch();
        advertisementsPage.assertPageOpened();

        LOGGER.info("Found %d advertisements".formatted(advertisementsPage.getAdvertisements().size()));
        for (CardComponent advertisement : advertisementsPage.getAdvertisements()) {
            Assert.assertTrue(advertisement.getAdvertisementTitle().toLowerCase(Locale.ROOT).contains(SEARCH_INPUT),
                    "Title does not contain search input: %s. Search input: %s.".formatted(advertisement.getAdvertisementTitle(), SEARCH_INPUT));
        }

    }

    @Test
    public void verifyBarterPriceBannerTest() {
        HomePage homePage = new HomePage(getDriver());

        AdvertisementsPage barterAdvertisementsPage = homePage.clickBarterBanner();
        barterAdvertisementsPage.assertPageOpened();

        LOGGER.info("Found %d advertisements".formatted(barterAdvertisementsPage.getAdvertisements().size()));
        for (CardComponent advertisement : barterAdvertisementsPage.getAdvertisements()) {
            Assert.assertEquals(advertisement.getPrice(), BARTER,
                    "Got %s instead of %s as price.".formatted(advertisement.getPrice(), BARTER));
        }
    }
}
