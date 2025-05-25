package io.github.mfaisalkhatri.seleniumgridjenkins.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private final WebDriver driver;

    public RegistrationPage (final WebDriver driver) {
        this.driver = driver;
    }

    private WebElement pageHeader () {
        return this.driver.findElement (By.cssSelector ("mat-card h1"));
    }
}
