package com.solvd.carinapractice.olx.pages;

import com.solvd.carinapractice.olx.components.CardComponent;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class AdsPage extends BasePage {

    @Getter
    @FindBy(xpath = "//div[@data-testid=\"l-card\"]")
    private List<CardComponent> ads;

    public AdsPage(WebDriver driver) {
        super(driver);
    }
}
