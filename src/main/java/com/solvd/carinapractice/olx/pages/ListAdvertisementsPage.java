package com.solvd.carinapractice.olx.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ListAdvertisementsPage extends AdvertisementsPage {

    @FindBy(xpath = "//button[contains(@id, 'category')]")
    private ExtendedWebElement categoryButton;

    public ListAdvertisementsPage(WebDriver driver) {
        super(driver);
        setPageURL("/list/$ignore");
        setUiLoadedMarker(categoryButton);
    }
}
