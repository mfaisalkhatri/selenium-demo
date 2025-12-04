package io.github.mfaisalkhatri.pageobjectmodeldemo.pages;

import java.util.List;

import io.github.mfaisalkhatri.pageobjectmodeldemo.testdata.RegistrationData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    public final  By pageHeader          = By.cssSelector ("mat-card h1");
    private final By answer              = By.id ("securityAnswerControl");
    private final By email               = By.id ("emailControl");
    private final By password            = By.id ("passwordControl");
    private final By questions           = By.cssSelector ("mat-option span");
    private final By register            = By.cssSelector ("#registration-form button#registerButton");
    private final By registrationSuccess = By.cssSelector ("simple-snack-bar div");
    private final By repeatPassword      = By.id ("repeatPasswordControl");
    private final By securityQuestions   = By.id ("mat-select-1");

    public RegistrationPage (final WebDriver driver) {
        super (driver);
    }

    public void registerNewUser (final RegistrationData registrationData) {
        final WebElement emailField = this.driver.findElement (this.email);
        emailField.clear ();
        emailField.sendKeys (registrationData.getEmail ());
        final WebElement passwordField = this.driver.findElement (this.password);
        passwordField.clear ();
        passwordField.sendKeys (registrationData.getPassword ());
        final WebElement repeatPasswordField = this.driver.findElement (this.repeatPassword);
        repeatPasswordField.clear ();
        repeatPasswordField.sendKeys (registrationData.getPassword ());
        selectSecurityQuestion (registrationData.getSecurityQuestion ());
        final WebElement answerField = this.driver.findElement (this.answer);
        answerField.clear ();
        answerField.sendKeys (registrationData.getSecurityAnswer ());
        this.wait.until (ExpectedConditions.elementToBeClickable (this.driver.findElement (this.register)))
            .click ();
    }

    public String registrationSuccessText () {
        return this.wait.until (ExpectedConditions.visibilityOfElementLocated (this.registrationSuccess))
            .getText ();
    }

    private void selectSecurityQuestion (final String questionText) {
        this.driver.findElement (this.securityQuestions)
            .click ();
        final List<WebElement> questionsList = this.wait.until (
            ExpectedConditions.visibilityOfAllElementsLocatedBy (this.questions));
        boolean found = false;
        for (final WebElement question : questionsList) {
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
}