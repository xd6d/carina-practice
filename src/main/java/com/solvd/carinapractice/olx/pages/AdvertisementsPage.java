package com.solvd.carinapractice.olx.pages;

import com.solvd.carinapractice.olx.components.CardComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class AdvertisementsPage extends BasePage {
    @FindBy(xpath = "//div[@data-testid='l-card']")
    private List<CardComponent> advertisements;

    public AdvertisementsPage(WebDriver driver) {
        super(driver);
    }

    public List<CardComponent> getAdvertisements() {
        return advertisements;
    }
}
