package com.solvd.carinapractice.olx.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    @FindBy(css = "input[name='username']")
    private ExtendedWebElement usernameInput;

    @FindBy(css = "input[name='password']")
    private ExtendedWebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//p[contains(text(), 'Ми не знайшли профіль із цією адресою електронної пошти.')]")
    private ExtendedWebElement unregisteredEmailErrorMessage;

    @FindBy(css = "button[type='submit'] .button-text-wrapper div")
    private ExtendedWebElement loadingAnimation;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://ua.login.olx.com/$ignore");
        setUiLoadedMarker(loginButton);
    }

    public boolean login(String username, String password) {
        usernameInput.type(username);
        passwordInput.type(password);
        loginButton.click();
        return waitUntil(ExpectedConditions.invisibilityOf(loadingAnimation), 10);
    }

    public boolean isUnregisteredEmailErrorMessagePresent(long timeout) {
        return unregisteredEmailErrorMessage.isElementPresent(timeout);
    }
}
