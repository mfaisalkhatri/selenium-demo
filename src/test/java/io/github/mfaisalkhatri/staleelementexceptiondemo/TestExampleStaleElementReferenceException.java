package io.github.mfaisalkhatri.staleelementexceptiondemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestExampleStaleElementReferenceException {

    private WebDriver driver;
    private Utility   utility;

    @Test
    public void createStaleElementReferenceException () {
        final WebElement pageLink = this.driver.findElement (By.linkText ("Table Data Search"));
        pageLink.click ();
        WebElement filterByField = this.driver.findElement (By.id ("task-table-filter"));

        filterByField.sendKeys ("in progress");
        this.driver.navigate ()
            .back ();
        pageLink.click ();

        filterByField = this.driver.findElement (By.id ("task-table-filter"));
        filterByField.sendKeys ("completed");
    }

    @BeforeTest
    public void setup () {
        this.driver = new ChromeDriver ();
        this.utility = new Utility (this.driver);
        this.driver.manage ()
            .window ()
            .maximize ();
        this.driver.manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (30));
        this.driver.get ("https://www.lambdatest.com/selenium-playground/");
    }

    @AfterTest
    public void tearDown () {
        this.driver.quit ();
    }

    @Test
    public void testChainExpectedConditionsToHandleStaleException () {
        WebElement pageLink = this.driver.findElement (By.linkText ("Table Data Search"));
        pageLink.click ();
        final By filterByField = By.id ("task-table-filter");

        this.utility.chainMultipleExpectedConditions (filterByField, "in progress");
        this.driver.navigate ()
            .back ();
        pageLink = this.driver.findElement (By.linkText ("Table Data Search"));
        pageLink.click ();
        this.utility.chainMultipleExpectedConditions (filterByField, "completed");
    }

    @Test
    public void testRetryUsingForLoopToHandleStaleException () {
        WebElement pageLink = this.driver.findElement (By.linkText ("Table Data Search"));
        pageLink.click ();
        final By filterByField = By.id ("task-table-filter");

        this.utility.retryUsingForLoopTryCatch (filterByField, "in progress");
        this.driver.navigate ()
            .back ();
        pageLink = this.driver.findElement (By.linkText ("Table Data Search"));
        pageLink.click ();
        this.utility.retryUsingForLoopTryCatch (filterByField, "completed");
    }

    @Test
    public void testRetryUsingWhileLoopTryCatch () {
        WebElement pageLink = this.driver.findElement (By.linkText ("Table Data Search"));
        pageLink.click ();
        final By filterByField = By.id ("task-table-filter");

        this.utility.retryUsingWhileLoopTryCatch (filterByField, "in progress");
        this.driver.navigate ()
            .back ();
        pageLink = this.driver.findElement (By.linkText ("Table Data Search"));
        pageLink.click ();
        this.utility.retryUsingWhileLoopTryCatch (filterByField, "completed");
    }
}
