package io.github.mfaisalkhatri;

import io.github.mfaisalkhatri.pages.LoginPage;
import io.github.mfaisalkhatri.pages.SecureAreaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CrossBrowserTests {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(final String browser) {
        if (browser.equalsIgnoreCase("CHROME")) {
            this.driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("EDGE")) {
            this.driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("FIREFOX")) {
            this.driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("SAFARI")) {
            this.driver = new SafariDriver();
        } else {
            throw new Error("Browser name is not specified correctly. It should be either chrome, firefox, edge or safari!!");
        }
    }

    @Test
    public void testLoginPage() {
        this.driver.get("https://the-internet.herokuapp.com/login");
        var loginPage = new LoginPage(this.driver);
        assertEquals(loginPage.pageHeader(), "Login Page");

        SecureAreaPage secureAreaPage = loginPage.performLogin("tomsmith", "SuperSecretPassword!");
        assertTrue(secureAreaPage.isLogoutBtnDisplayed());

    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

}
