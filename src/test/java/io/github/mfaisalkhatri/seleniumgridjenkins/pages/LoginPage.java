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

    private WebElement notACustomerLink () {
        return this.driver.findElement (By.id ("newCustomerLink"));
    }

}
