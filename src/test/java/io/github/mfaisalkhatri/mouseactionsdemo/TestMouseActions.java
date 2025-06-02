package io.github.mfaisalkhatri.mouseactionsdemo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestMouseActions extends BaseTest {

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
