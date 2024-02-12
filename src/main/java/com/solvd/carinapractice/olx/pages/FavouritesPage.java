package com.solvd.carinapractice.olx.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FavouritesPage extends AdsPage {

    @FindBy(css = "button[data-testid=\"select-ads\"]")
    private ExtendedWebElement selectAdsButton;

    public FavouritesPage(WebDriver driver) {
        super(driver);
        setPageURL("favorites/");
    }

    public void clickAds() {
        selectAdsButton.scrollTo();
        if (selectAdsButton.isClickable())
            selectAdsButton.click();
    }
}
