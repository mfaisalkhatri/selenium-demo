package io.github.mfaisalkhatri;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BrowserManagementTests {

    @Test
    public void testFirefoxVersion() {
        final FirefoxOptions options = new FirefoxOptions();
        options.setBrowserVersion("112");
        // dev, beta, nightly
        final WebDriver driver = new FirefoxDriver(options);
        driver.navigate().to("https://www.selenium.dev/");
        assertEquals (driver.getTitle(), "Selenium");
        driver.quit();
    }

    @Test
    public void testChromeVersion() {
        final ChromeOptions options = new ChromeOptions();
        // stable, dev, beta, canary
        options.setBrowserVersion("114");
        final WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.selenium.dev/");
        assertEquals (driver.getTitle(), "Selenium");
        driver.quit();
    }

}
