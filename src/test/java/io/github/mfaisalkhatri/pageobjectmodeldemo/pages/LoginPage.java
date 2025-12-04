package io.github.mfaisalkhatri.pageobjectmodeldemo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final Actions       actions;
    private final WebDriver     driver;
    private final By            emailLocator       = By.id ("email");
    private final By            loginButtonLocator = By.cssSelector ("button#loginButton");
    private final By            notACustomerLink   = By.cssSelector ("#login-form #newCustomerLink");
    private final By            pageHeader         = By.cssSelector ("app-login h1");
    private final By            passwordLocator    = By.id ("password");
    private final WebDriverWait wait;

    public LoginPage (final WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions (driver);
        this.wait = new WebDriverWait (driver, Duration.ofSeconds (30));
    }

    public RegistrationPage openRegistrationPage () {
        final WebElement notACustomer = this.wait.until (
            ExpectedConditions.elementToBeClickable (this.driver.findElement (this.notACustomerLink)));
        this.actions.moveToElement (notACustomer)
            .click ()
            .build ()
            .perform ();
        return new RegistrationPage (this.driver);
    }

    public String pageHeaderText () {
        return this.driver.findElement (this.pageHeader)
            .getText ();
    }

    public HomePage userLogin (final String email, final String password) {
        final WebElement emailField = this.driver.findElement (this.emailLocator);
        emailField.clear ();
        emailField.sendKeys (email);
        final WebElement passwordField = this.driver.findElement (this.passwordLocator);
        passwordField.clear ();
        passwordField.sendKeys (password);
        final WebElement loginButton = this.driver.findElement (this.loginButtonLocator);
        loginButton.clear ();
        return new HomePage (this.driver);
    }

}