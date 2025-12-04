package io.github.mfaisalkhatri.pageobjectmodeldemo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected final WebDriver     driver;
    protected final By            snackBar = By.tagName ("simple-snack-bar");
    protected final WebDriverWait wait;

    public BasePage (final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver, Duration.ofSeconds (30));
    }

    public String pageHeaderText (final By headerLocator) {
        return this.wait.until (ExpectedConditions.visibilityOfElementLocated (headerLocator))
            .getText ();
    }

    public void waitForSnackBarToDisappear () {
        this.wait.until (ExpectedConditions.invisibilityOfElementLocated (this.snackBar));
    }

}
