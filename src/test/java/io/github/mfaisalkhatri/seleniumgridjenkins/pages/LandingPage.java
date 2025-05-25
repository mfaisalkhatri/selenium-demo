package io.github.mfaisalkhatri.seleniumgridjenkins.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LandingPage {

    private final Actions   actions;
    private final WebDriver driver;

    public LandingPage (final WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions (driver);
    }

    public void acceptCookies () {
        meWantItButton ().click ();
    }

    public void dismissWelcomeBanner () {
        dismissButton ().click ();
    }

    public LoginPage openLoginPage () {
        dismissWelcomeBanner ();
        acceptCookies ();
        this.actions.moveToElement (accountLink ())
            .click ()
            .moveToElement (loginLink ())
            .click ()
            .build ()
            .perform ();
        return new LoginPage ();
    }

    private WebElement accountLink () {
        return this.driver.findElement (By.id ("navbarAccount"));
    }

    private WebElement dismissButton () {
        return this.driver.findElement (By.cssSelector ("button[aria-label = 'Close Welcome Banner']"));
    }

    private WebElement loginLink () {
        return this.driver.findElement (By.id ("navbarLoginButton"));
    }

    private WebElement meWantItButton () {
        return this.driver.findElement (By.cssSelector ("a[aria-label = 'dismiss cookie message']"));
    }
}
