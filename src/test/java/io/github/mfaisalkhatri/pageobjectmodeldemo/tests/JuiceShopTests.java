package io.github.mfaisalkhatri.pageobjectmodeldemo.tests;

import static io.github.mfaisalkhatri.pageobjectmodeldemo.testdata.RegistrationDataBuilder.getRegistrationData;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.github.mfaisalkhatri.pageobjectmodeldemo.pages.HomePage;
import io.github.mfaisalkhatri.pageobjectmodeldemo.pages.LoginPage;
import io.github.mfaisalkhatri.pageobjectmodeldemo.pages.RegistrationPage;
import io.github.mfaisalkhatri.pageobjectmodeldemo.testdata.RegistrationData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JuiceShopTests extends BaseTest {

    private RegistrationData registrationData;

    @BeforeTest
    public void beforeTest () {
        this.registrationData = getRegistrationData ();
    }

    @Test
    public void testRegisterUser () {
        this.driver.get ("http://localhost:3000");
        final HomePage homePage = new HomePage (this.driver);
        final LoginPage loginPage = homePage.openLoginPage ();
        assertEquals (loginPage.pageHeaderText (), "Login");

        final RegistrationPage registrationPage = loginPage.openRegistrationPage ();
        assertEquals (registrationPage.pageHeaderText (), "User Registration");

        registrationPage.registerNewUser (this.registrationData);
        assertEquals (registrationPage.registrationSuccessText (),
            "Registration completed successfully. You can now log in.");
    }

    @Test
    public void testUserLogin () {
        final LoginPage loginPage = new LoginPage (this.driver);
        assertEquals (loginPage.pageHeaderText (), "Login");

        final HomePage homePage = loginPage.userLogin (this.registrationData.getEmail (),
            this.registrationData.getPassword ());
        assertTrue (homePage.isLogoutButtonDisplayed ());
    }
}