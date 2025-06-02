package io.github.mfaisalkhatri.mouseactionsdemo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestMouseActions extends BaseTest {

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
    public void testMouseClickAction () throws InterruptedException {
        this.driver.get ("https://ecommerce-playground.lambdatest.io/");
        final WebElement searchBox = this.driver.findElement (By.name ("search"));
        searchBox.sendKeys ("iPhone");

        final WebElement searchBtn = this.driver.findElement (By.cssSelector ("button[type=submit]"));
        searchBtn.click ();

        final String pageHeader = this.driver.findElement (By.cssSelector ("#entry_212456 h1"))
            .getText ();
        assertEquals (pageHeader, "Search - iPhone");
    }

}
