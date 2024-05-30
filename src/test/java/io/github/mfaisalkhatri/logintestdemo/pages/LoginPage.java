package io.github.mfaisalkhatri.logintestdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement emailAddressField() {
        return driver.findElement(By.id("input-email"));
    }

    private WebElement passwordField() {
        return driver.findElement(By.id("input-password"));
    }

    private WebElement loginBtn() {
        return driver.findElement(By.cssSelector("input.btn"));
    }

    public void performLogin(String email, String password){
        emailAddressField().clear();
        emailAddressField().sendKeys(email);
        passwordField().clear();
        passwordField().sendKeys(password);
        loginBtn().click();
    }
}
