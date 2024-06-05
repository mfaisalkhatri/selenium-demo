package io.github.mfaisalkhatri.chatapplicationdemo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    protected WebDriver firstUserDriver;
    protected WebDriver secondUserDriver;

    @BeforeTest
    public void setup() {
        firstUserDriver = new ChromeDriver();
        secondUserDriver = new ChromeDriver();

        firstUserDriver.navigate().to("https://chat.appiumpro.com/");
        firstUserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        secondUserDriver.navigate().to("https://chat.appiumpro.com/");
        secondUserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterTest
    public void tearDown() {

        firstUserDriver.quit();
        secondUserDriver.quit();
    }

}
