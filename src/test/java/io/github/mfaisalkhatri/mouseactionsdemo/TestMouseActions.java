package io.github.mfaisalkhatri.mouseactionsdemo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestMouseActions extends BaseTest {

    @Test
    public void testContextClickAction () {
        this.driver.get ("https://www.lambdatest.com/selenium-playground/context-menu");
        final WebElement contextClickBox = this.driver.findElement (By.id ("hot-spot"));
        final Actions actions = new Actions (this.driver);
        actions.contextClick (contextClickBox)
            .build ()
            .perform ();

        final Alert alert = this.driver.switchTo ()
            .alert ();

        final String alertText = alert.getText ();
        assertEquals (alertText, "You selected a context menu");
        alert.accept ();
    }

    @Test
    public void testDoubleClickAction () {
        this.driver.get ("https://unixpapa.com/js/testmouse.html");
        final WebElement clickHereText = this.driver.findElement (By.linkText ("click here to test"));
        final Actions actions = new Actions (this.driver);
        actions.doubleClick (clickHereText)
            .build ()
            .perform ();

        final WebElement textBox = this.driver.findElement (By.tagName ("textarea"));
        final String textBoxValue = textBox.getAttribute ("value");

        assertTrue (textBoxValue.contains ("dblclick"));
    }

    @Test
    public void testDragDrop () {
        this.driver.get ("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");

        final WebElement draggable = this.driver.findElement (By.cssSelector ("#todrag > span:nth-child(2)"));
        final WebElement dropZone = this.driver.findElement (By.id ("mydropzone"));

        final Actions actions = new Actions (this.driver);
        actions.dragAndDrop (draggable, dropZone)
            .build ()
            .perform ();

        final String droppedItemList = this.driver.findElement (By.cssSelector ("#droppedlist span"))
            .getText ();
        assertEquals (droppedItemList, "Draggable 1");
    }

    @Test
    public void testDragDropApproachThree () {
        this.driver.get ("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");

        final WebElement draggable = this.driver.findElement (By.cssSelector ("#todrag > span:nth-child(2)"));

        final Actions actions = new Actions (this.driver);
        actions.dragAndDropBy (draggable, 477, 0)
            .build ()
            .perform ();

        final String droppedItemList = this.driver.findElement (By.cssSelector ("#droppedlist span"))
            .getText ();
        assertEquals (droppedItemList, "Draggable 1");

    }

    @Test
    public void testDragDropApproachTwo () {
        this.driver.get ("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");

        final WebElement draggable = this.driver.findElement (By.cssSelector ("#todrag > span:nth-child(2)"));
        final WebElement dropZone = this.driver.findElement (By.id ("mydropzone"));

        final Actions actions = new Actions (this.driver);
        actions.clickAndHold (draggable)
            .moveToElement (dropZone)
            .release ()
            .build ()
            .perform ();

        final String droppedItemList = this.driver.findElement (By.cssSelector ("#droppedlist span"))
            .getText ();
        assertEquals (droppedItemList, "Draggable 1");
    }

    @Test
    public void testMouseClickAction () {
        this.driver.get ("https://ecommerce-playground.lambdatest.io/");
        final WebElement searchBox = this.driver.findElement (By.name ("search"));
        searchBox.sendKeys ("iPhone");

        final WebElement searchBtn = this.driver.findElement (By.cssSelector ("button[type=submit]"));
        searchBtn.click ();

        final String pageHeader = this.driver.findElement (By.cssSelector ("#entry_212456 h1"))
            .getText ();
        assertEquals (pageHeader, "Search - iPhone");
    }

    @Test
    public void testMouseHover () {
        this.driver.get ("https://ecommerce-playground.lambdatest.io/");
        final WebElement myAccountLink = this.driver.findElement (
            By.cssSelector ("#widget-navbar-217834 > ul > li:nth-child(6) > a"));
        final Actions actions = new Actions (this.driver);
        actions.moveToElement (myAccountLink)
            .build ()
            .perform ();

        final WebElement loginLink = this.driver.findElement (By.linkText ("Login"));
        loginLink.click ();

        final List<WebElement> pageHeaders = this.driver.findElements (By.tagName ("h2"));
        final String loginHeader = pageHeaders.get (1)
            .getText ();
        assertEquals (loginHeader, "Returning Customer");
    }

    @Test
    public void testSliderAction () {
        this.driver.get ("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
        final WebElement slider = this.driver.findElement (By.cssSelector ("input[type='range'][value='5']"));
        final Point point = slider.getLocation ();
        final int xcord = point.getX ();
        final int ycord = point.getY ();
        System.out.println ("x: " + xcord);
        System.out.println ("y: " + ycord);

        final Actions actions = new Actions (this.driver);
        actions.clickAndHold (slider)
            .moveByOffset (-145, 0)
            .release ()
            .build ()
            .perform ();
        final String outputResult = this.driver.findElement (By.cssSelector ("output#range"))
            .getText ();

        assertEquals (outputResult, "20");
    }

}
