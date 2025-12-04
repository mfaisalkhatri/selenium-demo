package io.github.mfaisalkhatri.pageobjectmodeldemo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass (alwaysRun = true)
    public void setup () {
        this.driver = new ChromeDriver ();
        this.driver.manage ()
            .window ()
            .maximize ();
    }

    @AfterClass (alwaysRun = true)
    public void tearDown () {
        this.driver.quit ();
    }
}
