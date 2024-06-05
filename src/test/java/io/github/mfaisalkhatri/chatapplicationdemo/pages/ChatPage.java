package io.github.mfaisalkhatri.chatapplicationdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChatPage {

    protected WebDriver driver;

    public ChatPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement sendMessageField() {
        return driver.findElement(By.id("sendMessageInput"));
    }

    private WebElement sendBtn() {
        return driver.findElement(By.id("sendMessageBtn"));
    }

    public void sendMessage(String message) {
        sendMessageField().clear();
        sendMessageField().sendKeys(message);
        sendBtn().click();
    }

    public String getChatLog () {
        return driver.findElement(By.id("messages")).getText();
    }

    public String getLastChatMessage() {
        return driver.findElement(By.cssSelector("#messages > div:last-child > span.msgText")).getText();
    }
}
