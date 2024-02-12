package com.solvd.carinapractice.olx.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(css = "input[name=\"username\"]")
    private ExtendedWebElement usernameInput;

    @FindBy(css = "input[name=\"password\"]")
    private ExtendedWebElement passwordInput;

    @FindBy(css = "button[data-testid=\"login-submit-button\"]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//p[contains(text(), 'Ми не знайшли профіль із цією адресою електронної пошти.')]")
    private ExtendedWebElement unregisteredEmailErrorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        usernameInput.type(username);
        passwordInput.type(password);
        loginButton.click();
    }

    public boolean isLoginButtonClickable() {
        return loginButton.isClickable();
    }

    public boolean isUnregisteredEmailErrorMessagePresent() {
        return unregisteredEmailErrorMessage.isElementPresent();
    }

    public boolean isUnregisteredEmailErrorMessagePresent(long timeout) {
        return unregisteredEmailErrorMessage.isElementPresent(timeout);
    }
}
