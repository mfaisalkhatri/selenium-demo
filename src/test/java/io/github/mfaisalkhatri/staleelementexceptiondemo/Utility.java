package io.github.mfaisalkhatri.staleelementexceptiondemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

    private final WebDriver driver;

    public Utility (final WebDriver driver) {
        this.driver = driver;
    }

    public void chainMultipleExpectedConditions (final By locator, final String value) {
        final WebDriverWait wait = new WebDriverWait (this.driver, Duration.ofSeconds (5));
        wait.until (ExpectedConditions.refreshed (ExpectedConditions.presenceOfElementLocated (locator)));
        this.driver.findElement (locator)
            .sendKeys (value);
    }

    public boolean retryUsingForLoopTryCatch (final By locator, final String value) {
        boolean outcome = false;
        for (int repeat = 0; repeat <= 3; repeat++) {
            try {
                this.driver.findElement (locator)
                    .sendKeys (value);
                outcome = true;
                break;
            } catch (final StaleElementReferenceException exc) {
                exc.printStackTrace ();
            }
        }
        return outcome;
    }

    public boolean retryUsingWhileLoopTryCatch (final By locator, final String value) {
        boolean outcome = false;
        int repeat = 0;
        while (repeat <= 3) {
            try {
                this.driver.findElement (locator)
                    .sendKeys (value);
                outcome = true;
                break;
            } catch (final StaleElementReferenceException exc) {
                exc.printStackTrace ();
            }
            repeat++;
        }
        return outcome;
    }

}