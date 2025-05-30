package io.github.mfaisalkhatri.seleniumgridjenkins.pages;

import static org.testng.Assert.assertTrue;

import io.github.mfaisalkhatri.seleniumgridjenkins.testdata.RegistrationData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    private final WebDriver driver;

    public RegistrationPage (final WebDriver driver) {
        this.driver = driver;
    }

    public String pageHeaderText () {
        return this.driver.findElement (By.cssSelector ("mat-card h1"))
            .getText ();
    }

    public void registerNewUser (final RegistrationData registrationData) {
        emailField ().clear ();
        emailField ().sendKeys (registrationData.getEmail ());
        passwordField ().clear ();
        passwordField ().sendKeys (registrationData.getPassword ());
        repeatPasswordField ().clear ();
        repeatPasswordField ().sendKeys (registrationData.getPassword ());
        selectSecurityQuestion (registrationData.getSecurityQuestion ());
        answerToSecurityQuestionField ().clear ();
        answerToSecurityQuestionField ().sendKeys (registrationData.getSecurityAnswer ());
        assertTrue (registerButton ().isEnabled ());
        registerButton ().click ();
    }

    public String registrationSuccessText () {
        return this.driver.findElement (By.cssSelector ("simple-snack-bar div"))
            .getText ();
    }

    private WebElement answerToSecurityQuestionField () {
        return this.driver.findElement (By.id ("securityAnswerControl"));
    }

    private WebElement emailField () {
        return this.driver.findElement (By.id ("emailControl"));
    }

    private WebElement passwordField () {
        return this.driver.findElement (By.id ("passwordControl"));
    }

    private WebElement registerButton () {
        return this.driver.findElement (By.id ("registerButton"));
    }

    private WebElement repeatPasswordField () {
        return this.driver.findElement (By.id ("repeatPasswordControl"));
    }

    private WebElement securityQuestionField () {
        return this.driver.findElement (By.id ("mat-select-1"));
    }

    private void selectSecurityQuestion (final String question) {
        new Select (securityQuestionField ()).selectByVisibleText (question);
    }
}
