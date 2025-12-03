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
    private final By            notACustomerLink = By.cssSelector ("#login-form #newCustomerLink");
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
}