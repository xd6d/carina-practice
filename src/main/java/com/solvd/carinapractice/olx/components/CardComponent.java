package com.solvd.carinapractice.olx.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CardComponent extends AbstractUIObject {

    @FindBy(xpath = ".//span[@data-testid=\"adAddToFavorites\"]")
    private ExtendedWebElement addToFavouritesButton;

    @FindBy(xpath = ".//span[@data-testid=\"adAddToFavorites\" or @data-testid=\"adRemoveFromFavorites\"]/*")
    private ExtendedWebElement heartIcon;

    @FindBy(xpath = ".")
    private ExtendedWebElement thisCard;

    public CardComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickHeartIcon() {
        addToFavouritesButton.click();
    }

    public String getId() {
        return thisCard.getAttribute("id");
    }

    public String getHeartIconColor() {
        return heartIcon.getElement().getCssValue("color");
    }
}
