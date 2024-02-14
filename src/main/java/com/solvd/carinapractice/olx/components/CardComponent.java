package com.solvd.carinapractice.olx.components;

import com.solvd.carinapractice.olx.pages.AdvertisementPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CardComponent extends AbstractUIObject {

    @FindBy(xpath = ".//span[@data-testid='adAddToFavorites' or @data-testid='adRemoveFromFavorites']/*")
    private ExtendedWebElement heartIcon;

    @FindBy(css = "div[data-testid=dialog]")
    private ExtendedWebElement dialogWindow;

    @FindBy(xpath = ".//*[self::p or self::h6][2]/preceding-sibling::*")
    private ExtendedWebElement advertisementTitle;

    @FindBy(xpath = ".//*[self::p or self::h6][2]")
    private ExtendedWebElement priceElement;

    @FindBy(xpath = ".")
    private ExtendedWebElement thisCard;

    public CardComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickHeartIcon() {
        heartIcon.click(3);
        waitUntil(ExpectedConditions.visibilityOf(dialogWindow), 1);
        waitUntil(ExpectedConditions.invisibilityOf(dialogWindow), 1);
    }

    public String getId() {
        return thisCard.getAttribute("id");
    }

    public AdvertisementPage clickAdvertisement() {
        thisCard.click();
        return new AdvertisementPage(getDriver());
    }

    public String getHeartIconColor() {
        return heartIcon.getElement().getCssValue("color");
    }

    public String getAdvertisementTitle() {
        return advertisementTitle.getText();
    }

    public String getPrice() {
        return priceElement.getText();
    }
}
