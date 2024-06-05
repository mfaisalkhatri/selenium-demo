package io.github.mfaisalkhatri.chatapplicationdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement channelToJoinField() {
        return driver.findElement(By.id("channel"));
    }

    private WebElement userNameField() {
        return driver.findElement(By.id("username"));
    }

    private WebElement joinBtn() {
        return driver.findElement(By.id("joinChannel"));
    }

    public ChatPage loginToChat(String channelName, String userName) {
        channelToJoinField().clear();
        channelToJoinField().sendKeys(channelName);
        userNameField().clear();
        userNameField().sendKeys(userName);
        joinBtn().click();
        return new ChatPage(driver);
    }
}
