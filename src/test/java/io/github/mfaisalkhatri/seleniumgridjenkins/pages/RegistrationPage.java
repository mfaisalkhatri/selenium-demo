package io.github.mfaisalkhatri.seleniumgridjenkins.pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import io.github.mfaisalkhatri.seleniumgridjenkins.testdata.RegistrationData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private final Actions       actions;
    private final WebDriver     driver;
    private final WebDriverWait wait;

    public RegistrationPage (final WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions (driver);
        this.wait = new WebDriverWait (driver, Duration.ofSeconds (30));
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
        this.actions.moveToElement (registerButton ())
            .click ()
            .build ()
            .perform ();
    }

    public String registrationSuccessText () {
        return this.wait.until (ExpectedConditions.visibilityOfElementLocated (By.cssSelector ("simple-snack-bar div")))
            .getText ();
    }

    public void waitForSnackBarToDisappear () {
        this.wait.until (ExpectedConditions.invisibilityOf (snackBar ()));
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
        return this.driver.findElement (By.cssSelector ("#registration-form button#registerButton"));
    }

    private WebElement repeatPasswordField () {
        return this.driver.findElement (By.id ("repeatPasswordControl"));
    }

    private WebElement securityQuestionField () {
        return this.driver.findElement (By.id ("mat-select-1"));
    }

    private void selectSecurityQuestion (final String questionText) {
        securityQuestionField ().click ();
        final List<WebElement> questions = this.driver.findElements (By.cssSelector ("mat-option span"));
        boolean found = false;
        for (final WebElement question : questions) {
            if (questionText.contains (question.getText ())) {
                this.wait.until (ExpectedConditions.elementToBeClickable (question))
                    .click ();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println ("Question not found in the list!");
        }
    }

    private WebElement snackBar () {
        return this.driver.findElement (By.tagName ("simple-snack-bar"));
    }
}