package io.github.mfaisalkhatri.seleniumgridjenkins.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver     driver;
    private final WebDriverWait wait;

    public LoginPage (final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver, Duration.ofSeconds (30));
    }

    public RegistrationPage openRegistrationPage () {
        this.wait.until (ExpectedConditions.elementToBeClickable (notACustomerLink ()))
            .click ();
        return new RegistrationPage (this.driver);
    }

    public String pageHeaderText () {
        return this.driver.findElement (By.cssSelector ("app-login h1"))
            .getText ();
    }

    public HomePage userLogin (final String email, final String password) {
        emailField ().clear ();
        emailField ().sendKeys (email);
        passwordField ().clear ();
        passwordField ().sendKeys (password);
        loginButton ().click ();
        return new HomePage (this.driver);
    }

    private WebElement emailField () {
        return this.driver.findElement (By.id ("email"));
    }

    private WebElement loginButton () {
        return this.driver.findElement (By.cssSelector ("button#loginButton"));
    }

    private WebElement notACustomerLink () {
        return this.driver.findElement (By.id ("newCustomerLink"));
    }

    private WebElement passwordField () {
        return this.driver.findElement (By.id ("password"));
    }
}