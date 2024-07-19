package io.github.mfaisalkhatri.seleniumgriddemo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocalGridTests extends BaseTest{


    @Test
    public void testPageHeader() {
        getDriver().get("https://the-internet.herokuapp.com/");
        String pageHeader = getDriver().findElement(By.tagName("h1")).getText();

        assertEquals(pageHeader, "Welcome to the-internet");
    }






}
