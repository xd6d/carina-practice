package com.solvd.carinapractice.olx.pages;

import com.solvd.carinapractice.olx.components.CardComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class AdvertisementsPage extends BasePage {
    @FindBy(xpath = "//div[@data-testid='l-card']")
    private List<CardComponent> advertisements;

    @FindBy(id = "search")
    private ExtendedWebElement searchInput;

    public AdvertisementsPage(WebDriver driver) {
        super(driver);
    }

    public List<CardComponent> getAdvertisements() {
        return advertisements;
    }

    public void typeSearch(String input) {
        searchInput.type(input);
    }

    public ListAdvertisementsPage executeSearch() {
        searchInput.sendKeys(Keys.ENTER);
        return new ListAdvertisementsPage(getDriver());
    }
}
