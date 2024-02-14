package com.solvd.carinapractice.olx.pages;

import com.solvd.carinapractice.olx.components.CardComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AdvertisementsPage {

    @FindBy(xpath = "//div[@data-testid='l-card' and not(div[contains(@class, 'jobs-ad-card')])]")
    private List<CardComponent> advertisements;

    @FindBy(css = "button[data-testid='dismiss-cookies-banner']")
    private ExtendedWebElement dismissCookieButton;

    @FindBy(xpath = "//h2[contains(text(), 'Розділи')]//following-sibling::*//span[text()='Обмін']")
    private ExtendedWebElement barterBanner;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(barterBanner);
    }

    public void dismissCookie() {
        dismissCookieButton.clickIfPresent(10);
    }

    public AdvertisementsPage clickBarterBanner() {
        barterBanner.click();
        return new BarterAdvertisementsPage(getDriver());
    }
}
