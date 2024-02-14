package com.solvd.carinapractice.olx.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FavouritesPage extends AdvertisementsPage {

    @FindBy(xpath = "//button[contains(text(), 'Вибрані оголошення')]")
    private ExtendedWebElement selectedAdsButton;

    public FavouritesPage(WebDriver driver) {
        super(driver);
        setPageURL("/favorites");
        setUiLoadedMarker(selectedAdsButton);
    }

    public void clickSelectedAdsTab() {
        selectedAdsButton.scrollTo();
        if (selectedAdsButton.isClickable()) {
            selectedAdsButton.click();
        }
    }
}
