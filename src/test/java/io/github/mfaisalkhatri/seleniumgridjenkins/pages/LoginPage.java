package io.github.mfaisalkhatri.seleniumgridjenkins.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage (final WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage openRegistrationPage () {
        notACustomerLink ().click ();
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
