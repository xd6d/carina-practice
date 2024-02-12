package com.solvd.carinapractice.olx.pages;

import com.solvd.carinapractice.olx.components.CardComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AdvertisementsPage {

    @FindBy(xpath = "//div[@data-testid='l-card' and not(div[contains(@class, 'jobs-ad-card')])]")
    private List<CardComponent> advertisements;

    @FindBy(css = "button[data-testid='dismiss-cookies-banner']")
    private ExtendedWebElement dismissCookieButton;

    @FindBy(id = "search")
    private ExtendedWebElement searchInput;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchInput);
    }

    public void dismissCookie() {
        dismissCookieButton.clickIfPresent(10);
    }

    public void typeSearch(String input) {
        searchInput.type(input);
    }

    public ListAdvertisementsPage executeSearch() {
        searchInput.sendKeys(Keys.ENTER);
        return new ListAdvertisementsPage(getDriver());
    }

    @Override
    public List<CardComponent> getAdvertisements() {
        return advertisements;
    }
}
