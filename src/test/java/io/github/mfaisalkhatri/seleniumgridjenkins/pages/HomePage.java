package io.github.mfaisalkhatri.seleniumgridjenkins.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private final Actions   actions;
    private final WebDriver driver;

    public HomePage (final WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions (driver);
    }

    public boolean isLogoutButtonDisplayed () {
        accountLink ().click ();
        return logoutButton ().isDisplayed ();
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
        return new LoginPage (this.driver);
    }

    private void acceptCookies () {
        meWantItButton ().click ();
    }

    private WebElement accountLink () {
        return this.driver.findElement (By.id ("navbarAccount"));
    }

    private WebElement dismissButton () {
        return this.driver.findElement (By.cssSelector ("button[aria-label = 'Close Welcome Banner']"));
    }

    private void dismissWelcomeBanner () {
        dismissButton ().click ();
    }

    private WebElement loginLink () {
        return this.driver.findElement (By.id ("navbarLoginButton"));
    }

    private WebElement logoutButton () {
        return this.driver.findElement (By.id ("navbarLogoutButton"));
    }

    private WebElement meWantItButton () {
        return this.driver.findElement (By.cssSelector ("a[aria-label = 'dismiss cookie message']"));
    }

}
