package io.github.mfaisalkhatri;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SeleniumDemoTests {


    @Test
    public void testOnChrome() {
        final WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.selenium.dev/");
        assertEquals (driver.getTitle(), "Selenium");
      //  driver.quit();
    }

    @Test
    public void testOnFirefox() {
        final WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.selenium.dev/");
        assertEquals (driver.getTitle(), "Selenium");
        driver.quit();
    }


}
