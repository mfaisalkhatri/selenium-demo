package io.github.mfaisalkhatri.crossbrowsertests;

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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CrossBrowserTestsWithThreadLocal {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    @BeforeTest
    @Parameters("browser")
    public void setup(final String browser) {
        if (browser.equalsIgnoreCase("CHROME")) {
            DRIVER.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("EDGE")) {
            DRIVER.set(new EdgeDriver());
        } else if (browser.equalsIgnoreCase("FIREFOX")) {
            DRIVER.set(new FirefoxDriver());
        } else if (browser.equalsIgnoreCase("SAFARI")) {
            DRIVER.set(new SafariDriver());
        } else {
            throw new Error("Browser name is not specified correctly. It should be either chrome, firefox, edge or safari!!");
        }
    }

    @Test
    public void testLoginPage() {
        DRIVER.get().navigate().to("https://the-internet.herokuapp.com/login");
        final var loginPage = new LoginPage(DRIVER.get());
        assertEquals(loginPage.pageHeader(), "Login Page");

        final SecureAreaPage secureAreaPage = loginPage.performLogin("tomsmith", "SuperSecretPassword!");
        assertTrue(secureAreaPage.isLogoutBtnDisplayed());
    }

    @AfterTest
    public void tearDown() {
        DRIVER.get().quit();
    }
}
