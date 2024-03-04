package io.github.mfaisalkhatri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String pageHeader() {
        return this.driver.findElement(By.tagName("h2")).getText();
    }

    private WebElement userNameField() {
        return this.driver.findElement(By.id("username"));
    }

    private WebElement passwordField() {
        return this.driver.findElement(By.id("password"));
    }

    private WebElement loginBtn() {
        return this.driver.findElement(By.className("radius"));
    }

    public SecureAreaPage performLogin(String userName, String password) {
        this.userNameField().sendKeys(userName);
        this.passwordField().sendKeys(password);
        this.loginBtn().click();
        return new SecureAreaPage(this.driver);
    }
}
