package io.github.mfaisalkhatri.pageobjectmodeldemo.pages;

import java.time.Duration;

import io.github.mfaisalkhatri.pageobjectmodeldemo.testdata.RegistrationData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private final Actions       actions;
    private final WebDriver     driver;
    private final By            email    = By.id ("emailControl");
    private final By            password = By.id ("passwordControl");
    private final WebDriverWait wait;

    public RegistrationPage (final WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions (driver);
        this.wait = new WebDriverWait (driver, Duration.ofSeconds (30));
    }

    public void registerNewUser (final RegistrationData registrationData) {
        final WebElement emailField = this.driver.findElement (this.email);
        emailField.clear ();
        emailField.sendKeys (registrationData.getEmail ());
        final WebElement passwordField = this.driver.findElement (this.password);
        passwordField.clear ();
        passwordField.sendKeys (registrationData.getPassword ());

    }

}
