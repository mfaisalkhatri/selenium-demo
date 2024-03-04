package io.github.mfaisalkhatri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class CSSSelectorDemoTests {

    @Test
    public void testPrintColumnValue() {
        final WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/table-data-download-demo");
        final WebElement columnValue = driver.findElement(By.cssSelector("#example > tbody > tr:nth-child(3) > td:nth-child(2)"));
        final String columnText = columnValue.getText();
        System.out.println(columnText);
        driver.quit();
    }

    @Test
    public void testAttributes() {
        final WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        final WebElement pageTitle = driver.findElement(By.cssSelector(".container > div > div > h2"));
        final String innerHtml = pageTitle.getAttribute("innerHTML");
        final String innerText = pageTitle.getAttribute("innerText");
        final String textContent = pageTitle.getAttribute("textContent");

        System.out.println("innerhtml : " + innerHtml);
        System.out.println("innerText :" + innerText);
        System.out.println("text content: " + textContent);


        driver.quit();
    }

    @Test
    public void testSubstring() {
        final WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        final WebElement nameField = driver.findElement(By.cssSelector("input[name^='ti']"));
        final WebElement messageField = driver.findElement(By.cssSelector("textarea[name$='tion']"));

        final String name = "Faisal";
        final String message = "This is a message text";

        nameField.sendKeys(name);
        messageField.sendKeys(message);

        final WebElement submitBtn = driver.findElement(By.cssSelector(".btn.btn-dark"));

//        final String nameValue = nameField.getAttribute("innerHTML");
//        final String messageValue = nameField.getAttribute("innerHTML");
//
//        assertEquals(nameValue, name);
//        assertEquals(messageValue,messageValue);

        submitBtn.click();

        driver.quit();
    }


}
