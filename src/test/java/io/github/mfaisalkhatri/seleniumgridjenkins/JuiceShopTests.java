package io.github.mfaisalkhatri.seleniumgridjenkins;

import static io.github.mfaisalkhatri.seleniumgridjenkins.testdata.RegistrationDataBuilder.getRegistrationData;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.github.mfaisalkhatri.seleniumgridjenkins.pages.HomePage;
import io.github.mfaisalkhatri.seleniumgridjenkins.pages.LoginPage;
import io.github.mfaisalkhatri.seleniumgridjenkins.pages.RegistrationPage;
import io.github.mfaisalkhatri.seleniumgridjenkins.testdata.RegistrationData;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Slf4j
public class JuiceShopTests extends BaseTest {

    private RegistrationData registrationData;

    @BeforeTest
    public void beforeTest () {

        this.registrationData = getRegistrationData ();
    }

    @Test
    public void testRegisterUser () {
        final HomePage homePage = new HomePage (getDriver ());
        final LoginPage loginPage = homePage.openLoginPage ();
        final RegistrationPage registrationPage = loginPage.openRegistrationPage ();
        assertEquals (registrationPage.pageHeaderText (), "User Registration");
        registrationPage.registerNewUser (this.registrationData);
        assertEquals (registrationPage.registrationSuccessText (),
            "Registration completed successfully. You can now log in.");
    }

    @Test
    public void testUserLogin () {
        final LoginPage loginPage = new LoginPage (getDriver ());
        final HomePage homePage = loginPage.userLogin (this.registrationData.getEmail (),
            this.registrationData.getPassword ());
        assertTrue (homePage.isLogoutButtonDisplayed ());
    }

}
