package com.solvd.carinapractice.olx.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AdvertisementPage extends BasePage {

    @FindBy(css = "div[data-cy='ad_title'] h4")
    private ExtendedWebElement advertisementTitle;

    @FindBy(xpath = "//button[text()='Повідомлення']")
    private ExtendedWebElement contactButton;

    @FindBy(xpath = "//button[contains(text(), 'показати')]")
    private ExtendedWebElement showPhoneButton;

    @FindBy(css = "a[name='user_ads'] h4")
    private ExtendedWebElement sellerName;

    @FindBy(xpath = "//h3[text()='Опис']//following-sibling::*")
    private ExtendedWebElement description;

    public AdvertisementPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(description);
    }

    public boolean isAdvertisementTitlePresent() {
        return advertisementTitle.isElementPresent(5);
    }
    
    public String getAdvertisementTitle() {
        return advertisementTitle.getText();
    }

    public boolean isContactButtonPresent() {
        return contactButton.isElementPresent(5);
    }

    public boolean isContactButtonClickable() {
        return contactButton.isClickable(5);
    }

    public boolean isShowPhoneButtonPresent() {
        return showPhoneButton.isElementPresent(5);
    }

    public boolean isShowPhoneButtonClickable() {
        return showPhoneButton.isClickable(5);
    }

    public boolean isSellerNamePresent() {
        return sellerName.isElementPresent(5);
    }

    public String getSellerName() {
        return sellerName.getText();
    }

    public boolean isDescriptionPresent() {
        return description.isElementPresent(5);
    }
}
