package io.github.mfaisalkhatri.expectedconditionsdemo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExpectedConditionsTest extends BaseTest {

    @Test
    public void testElementToBeClickableCondition () {
        this.driver.get ("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        final WebElement enterMessageField = this.driver.findElement (By.id ("user-message"));
        final String inputMessage = "This is a test";
        enterMessageField.sendKeys (inputMessage);

        final WebDriverWait wait = new WebDriverWait (this.driver, Duration.ofSeconds (30));
        wait.until (ExpectedConditions.elementToBeClickable (By.id ("showInput")))
            .click ();

        final String messageText = this.driver.findElement (By.id ("message"))
            .getText ();
        assertEquals (messageText, inputMessage);
    }

    @Test
    public void testElementToBeSelected () {
        this.driver.get ("https://www.lambdatest.com/selenium-playground/checkbox-demo");
        final WebElement checkAllBtn = this.driver.findElement (By.cssSelector ("button.mt-20"));
        checkAllBtn.click ();
        final WebDriverWait wait = new WebDriverWait (this.driver, Duration.ofSeconds (20));

        final WebElement checkboxOne = this.driver.findElement (By.cssSelector ("input[name='option1']"));
        assertTrue (wait.until (ExpectedConditions.elementToBeSelected (checkboxOne)));

        final WebElement checkboxTwo = this.driver.findElement (By.cssSelector ("input[name='option2']"));
        assertTrue (wait.until (ExpectedConditions.elementToBeSelected (checkboxTwo)));
    }

    @Test
    public void testFrameToBeAvailableAndSwitch () {
        this.driver.get ("https://www.lambdatest.com/selenium-playground/iframe-demo/");

        final WebDriverWait wait = new WebDriverWait (this.driver, Duration.ofSeconds (30));
        final WebElement iFrame = this.driver.findElement (By.id ("iFrame1"));
        wait.until (ExpectedConditions.frameToBeAvailableAndSwitchToIt (iFrame));

        final WebElement iFrameEditor = this.driver.findElement (By.cssSelector ("#__next > div > div.rsw-ce"));
        final String text = "switched to iframe";
        iFrameEditor.clear ();
        iFrameEditor.sendKeys (text);
        System.out.println ("Text entered in iFrame");
    }

    @Test
    public void testTextToBePresent () {
        this.driver.get ("https://www.lambdatest.com/selenium-playground/dynamic-data-loading-demo");
        final WebElement getRandomUserBtn = this.driver.findElement (By.id ("save"));
        getRandomUserBtn.click ();

        final WebDriverWait wait = new WebDriverWait (this.driver, Duration.ofSeconds (30));
        assertTrue (wait.until (ExpectedConditions.textToBePresentInElementLocated (By.id ("loading"), "First Name")));

    }

    @Test
    public void testVisibilityOfElementLocated () {
        this.driver.get ("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        final WebElement draggableOne = this.driver.findElement (By.cssSelector ("#todrag > span:nth-child(2)"));
        final WebElement dropBox = this.driver.findElement (By.id ("mydropzone"));

        final Actions actions = new Actions (this.driver);
        actions.dragAndDrop (draggableOne, dropBox)
            .build ()
            .perform ();

        final WebDriverWait wait = new WebDriverWait (this.driver, Duration.ofSeconds (30));
        final WebElement dropListItemOne = wait.until (
            ExpectedConditions.visibilityOfElementLocated (By.cssSelector ("#droppedlist > span")));
        final String dropListItemName = dropListItemOne.getText ();
        assertEquals (dropListItemName, "Draggable 1");
    }
}
