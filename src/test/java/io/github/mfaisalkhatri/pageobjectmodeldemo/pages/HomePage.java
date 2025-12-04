package io.github.mfaisalkhatri.pageobjectmodeldemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private final By accountLink           = By.id ("navbarAccount");
    private final By dismissButtonLocator  = By.cssSelector ("button[aria-label = 'Close Welcome Banner']");
    private final By loginLinkLocator      = By.id ("navbarLoginButton");
    private final By logoutButtonLocator   = By.id ("navbarLogoutButton");
    private final By meWantItButtonLocator = By.cssSelector ("a[aria-label = 'dismiss cookie message']");

    public HomePage (final WebDriver driver) {
        super (driver);
    }

    public boolean isLogoutButtonDisplayed () {
        this.wait.until (ExpectedConditions.visibilityOfElementLocated (this.accountLink))
            .click ();
        return this.wait.until (ExpectedConditions.visibilityOfElementLocated (this.logoutButtonLocator))
            .isDisplayed ();
    }

    public LoginPage openLoginPage () {
        final WebElement dismissButton = this.wait.until (
            ExpectedConditions.visibilityOfElementLocated (this.dismissButtonLocator));
        if (dismissButton.isDisplayed ()) {
            dismissButton.click ();
        }
        final WebElement meWantItButton = this.wait.until (
            ExpectedConditions.visibilityOfElementLocated (this.meWantItButtonLocator));
        if (meWantItButton.isDisplayed ()) {
            meWantItButton.click ();
        }
        this.wait.until (ExpectedConditions.invisibilityOfElementLocated (this.snackBar));
        this.driver.findElement (this.accountLink)
            .click ();
        this.wait.until (ExpectedConditions.elementToBeClickable (this.loginLinkLocator))
            .click ();
        return new LoginPage (this.driver);
    }
}