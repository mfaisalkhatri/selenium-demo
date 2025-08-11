package io.github.mfaisalkhatri.seleniumgridjenkins.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver     driver;
    private final WebDriverWait wait;

    public HomePage (final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver, Duration.ofSeconds (30));
    }

    public boolean isLogoutButtonDisplayed () {
        accountLink ().click ();
        return logoutButton ().isDisplayed ();
    }

    public LoginPage openLoginPage () {
        dismissWelcomeBanner ();
        acceptCookies ();
        this.wait.until (ExpectedConditions.invisibilityOf (snackBar ()));
        accountLink ().click ();
        this.wait.until (ExpectedConditions.invisibilityOf (overlay ()));
        loginLink ().click ();
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

    private WebElement overlay () {
        return this.driver.findElement (By.cssSelector (".cdk-overlay-container .cdk-overlay-pane"));
    }

    private WebElement snackBar () {
        return this.driver.findElement (By.tagName ("simple-snack-bar"));
    }
}