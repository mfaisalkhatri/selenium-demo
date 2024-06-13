package io.github.mfaisalkhatri.dropdowndemo.tests;

import io.github.mfaisalkhatri.dropdowndemo.pages.seleniumplayground.DropdownPage;
import io.github.mfaisalkhatri.dropdowndemo.pages.seleniumplayground.JqueryDropdownPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropdownTest extends BaseTest{

    @Test
    public void testSelectDropdownValue() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.selectByValue("Monday");
        assertEquals(dropdownPage.getSelectedValue(), "Monday");
    }

    @Test
    public void testSelectDropdownWithIndex() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.selectByIndex(3);
        assertEquals(dropdownPage.getSelectedValue(), "Tuesday");

    }

    @Test
    public void testSelectDropdownWithVisibleText() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.selectByVisibleText("Thursday");
        assertEquals(dropdownPage.getSelectedValue(), "Thursday");
    }


    @Test
    public void testJQueryDropdownField() {
        JqueryDropdownPage jqueryDropdownPage = new JqueryDropdownPage(driver);
        jqueryDropdownPage.selectCountry("India");
        assertEquals(jqueryDropdownPage.getOption(), "India");
    }
}
