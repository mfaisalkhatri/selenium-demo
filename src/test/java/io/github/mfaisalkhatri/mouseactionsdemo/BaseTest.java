package io.github.mfaisalkhatri.mouseactionsdemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup () {
        this.driver = new ChromeDriver ();
        this.driver.manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (30));
        this.driver.manage ()
            .window ()
            .maximize ();
    }

    @AfterTest
    public void tearDown () {
        this.driver.quit ();
    }
}
