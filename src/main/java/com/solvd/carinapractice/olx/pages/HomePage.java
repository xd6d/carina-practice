package com.solvd.carinapractice.olx.pages;

import com.solvd.carinapractice.olx.components.CardComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AdvertisementsPage {

    @Getter
    @FindBy(xpath = "//div[@data-testid='l-card']")
    private List<CardComponent> ads;

    @FindBy(css = "button[data-testid='dismiss-cookies-banner']")
    private ExtendedWebElement dismissCookieButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void dismissCookie() {
        dismissCookieButton.clickIfPresent(10);
    }
}
