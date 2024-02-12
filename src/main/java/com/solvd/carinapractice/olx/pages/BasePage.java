package com.solvd.carinapractice.olx.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage extends AbstractPage {

    @FindBy(xpath = "//header//a[text()='Ваш профіль']")
    private ExtendedWebElement profileButton;

    @FindBy(css = "svg[aria-label=\"Виділені\"]")
    private ExtendedWebElement favouritesButton;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public void goToProfile() {
        profileButton.click();
    }

    public void clickFavourites() {
        favouritesButton.click();
    }
}
