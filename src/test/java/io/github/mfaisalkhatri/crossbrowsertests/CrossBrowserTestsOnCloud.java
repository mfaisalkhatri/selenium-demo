package io.github.mfaisalkhatri.crossbrowsertests;

import io.github.mfaisalkhatri.pages.LoginPage;
import io.github.mfaisalkhatri.pages.SecureAreaPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CrossBrowserTestsOnCloud extends BaseTest {

    @Test
    public void testLoginPage() {
        getDriver().navigate().to("https://the-internet.herokuapp.com/login");
        final var loginPage = new LoginPage(getDriver());
        assertEquals(loginPage.pageHeader(), "Login Page");

        final SecureAreaPage secureAreaPage = loginPage.performLogin("tomsmith", "SuperSecretPassword!");
        assertTrue(secureAreaPage.isLogoutBtnDisplayed());
    }


}

