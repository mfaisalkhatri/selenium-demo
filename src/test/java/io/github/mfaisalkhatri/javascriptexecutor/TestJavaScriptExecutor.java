package io.github.mfaisalkhatri.javascriptexecutor;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestJavaScriptExecutor {

    private WebDriver driver;

    @BeforeTest
    public void setup () {
        driver = new ChromeDriver ();
        driver.manage ()
            .window ()
            .maximize ();
        driver.manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (30));
    }

    @AfterTest
    public void tearDown () {
        driver.quit ();
    }

    @Test
    public void testJavaScriptExecutorCommand () {
        driver.get ("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement emailAddressField = driver.findElement (By.id ("input-email"));
        js.executeScript ("arguments[0].style.border='3px solid red'", emailAddressField);
        emailAddressField.sendKeys ("davidjacob@demo.com");
        js.executeScript ("arguments[0].style.border='2px solid #ced4da'", emailAddressField);

        WebElement passwordField = driver.findElement (By.id ("input-password"));
        js.executeScript ("arguments[0].style.border='3px solid red'", passwordField);
        passwordField.sendKeys ("Password123");
        js.executeScript ("arguments[0].style.border='2px solid #ced4da'", passwordField);

        WebElement loginBtn = driver.findElement (By.cssSelector ("input.btn"));
        js.executeScript ("arguments[0].style.border='3px solid red'", loginBtn);
        js.executeScript ("arguments[0].click();", loginBtn);

        String titleText = js.executeScript ("return document.title;")
            .toString ();
        System.out.println ("Page Title is: " + titleText);

        String domainName = js.executeScript ("return document.domain;")
            .toString ();
        System.out.println ("Domain is: " + domainName);

        String myAccountHeader = driver.findElement (By.cssSelector ("#content h2"))
            .getText ();
        assertEquals (myAccountHeader, "My Account");
    }

    @Test
    public void testExecuteAsyncScript() {
        driver.get("https://ecommerce-playground.lambdatest.io");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript("var callback = arguments[arguments.length - 1];" + "window.scrollBy(0,document.body.scrollHeight); + callback()");

        String fromTheBlogText = driver.findElement(By.cssSelector("#entry_217991 > h3")).getText();
        assertEquals(fromTheBlogText, "FROM THE BLOG");
    }
}