package io.github.mfaisalkhatri.dropdowndemo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
        //driver.get("https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}