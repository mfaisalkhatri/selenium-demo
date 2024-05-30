package io.github.mfaisalkhatri.logintestdemo;

import io.github.mfaisalkhatri.logintestdemo.pages.LoginPage;
import io.github.mfaisalkhatri.logintestdemo.pages.MyAccountPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class LoginPageTest extends BaseTest {

    @DataProvider
    public Iterator<Object[]> getLoginData() {
        List<Object[]> loginData = new ArrayList<>();
        loginData.add(new Object[]{"david.thomson@gmail.com", "Password", false});
        loginData.add(new Object[]{"david.thomson@gmail.com", "", false});
        loginData.add(new Object[]{"", "", false});
        loginData.add(new Object[]{"david.thomson@gmail.com", "Secret@123", true});
        return loginData.iterator();
    }

    @Test(dataProvider = "getLoginData")
    public void testLoginFeature(String email, String password, boolean isValidUser) {

        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(email, password);

        if (!isValidUser) {
            assertEquals(loginPage.getErrorMessageText(), "Warning: No match for E-Mail Address and/or Password.");
        } else {
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            assertEquals(myAccountPage.getPageTitle(), "My Account");
        }
    }
}