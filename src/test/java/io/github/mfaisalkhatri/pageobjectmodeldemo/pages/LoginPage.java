package io.github.mfaisalkhatri.pageobjectmodeldemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public final  By pageHeader         = By.cssSelector ("app-login h1");
    private final By emailLocator       = By.id ("email");
    private final By loginButtonLocator = By.cssSelector ("button#loginButton");
    private final By notACustomerLink   = By.cssSelector ("#login-form #newCustomerLink");
    private final By passwordLocator    = By.id ("password");

    public LoginPage (final WebDriver driver) {
        super (driver);
    }

    public RegistrationPage openRegistrationPage () {
        this.wait.until (ExpectedConditions.elementToBeClickable (this.driver.findElement (this.notACustomerLink)))
            .click ();
        return new RegistrationPage (this.driver);
    }

    public HomePage userLogin (final String email, final String password) {
        final WebElement emailField = this.driver.findElement (this.emailLocator);
        emailField.clear ();
        emailField.sendKeys (email);
        final WebElement passwordField = this.driver.findElement (this.passwordLocator);
        passwordField.clear ();
        passwordField.sendKeys (password);
        final WebElement loginButton = this.driver.findElement (this.loginButtonLocator);
        loginButton.click ();
        return new HomePage (this.driver);
    }

}