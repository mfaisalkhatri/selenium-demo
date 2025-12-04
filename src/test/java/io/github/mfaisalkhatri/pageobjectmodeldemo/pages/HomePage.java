package io.github.mfaisalkhatri.pageobjectmodeldemo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final By            accountLink         = By.id ("navbarAccount");
    private final Actions       actions;
    private final By            dismissButton       = By.cssSelector ("button[aria-label = 'Close Welcome Banner']");
    private final WebDriver     driver;
    private final By            loginLink           = By.id ("navbarLoginButton");
    private final By            logoutButtonLocator = By.id ("navbarLogoutButton");
    private final By            meWantItButton      = By.cssSelector ("a[aria-label = 'dismiss cookie message']");
    private final By            snackBar            = By.tagName ("simple-snack-bar");
    private final WebDriverWait wait;

    public HomePage (final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver, Duration.ofSeconds (30));
        this.actions = new Actions (driver);
    }

    public boolean isLogoutButtonDisplayed () {
        return this.wait.until (ExpectedConditions.visibilityOfElementLocated (this.logoutButtonLocator))
            .isDisplayed ();

    }

    public LoginPage openLoginPage () {
        this.driver.findElement (this.dismissButton)
            .click ();
        this.driver.findElement (this.meWantItButton)
            .click ();
        this.wait.until (ExpectedConditions.invisibilityOfElementLocated (this.snackBar));
        this.driver.findElement (this.accountLink)
            .click ();
        this.actions.moveToElement (this.driver.findElement (this.loginLink))
            .click ()
            .build ()
            .perform ();
        return new LoginPage (this.driver);
    }
}