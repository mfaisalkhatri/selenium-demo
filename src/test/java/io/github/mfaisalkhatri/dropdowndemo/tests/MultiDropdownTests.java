package io.github.mfaisalkhatri.dropdowndemo.tests;

import io.github.mfaisalkhatri.dropdowndemo.pages.seleniumplayground.DropdownPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MultiDropdownTests extends BaseTest {

    @Test
    public void testCheckIfMultipleSelectionIsAllowed() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        assertTrue(dropdownPage.isMultipleSelectionAllowed(), "Field does not support multiple selection");
    }

    @Test()
    public void testMultiSelectByValue() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        List<String> selectValues = List.of("California", "Ohio", "Texas", "Pennsylvania");

        dropdownPage.selectMultipleOptionByValue(selectValues);
        assertEquals(dropdownPage.getAllSelectedOptions(), selectValues);
        captureScreenShot("MultiSelectByValues");
    }


    @Test()
    public void testMultiSelectByIndex() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.selectMultipleOptionByIndex(new int[]{0, 2, 3});

        assertEquals(dropdownPage.getAllSelectedOptions(),
                List.of("California", "New Jersey", "New York"));
        captureScreenShot("MultiSelectByIndex");
    }

    @Test()
    public void testMultiSelectByVisibleText() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        List<String> selectValues = List.of("Florida", "New York", "Texas", "Washington");
        dropdownPage.selectMultipleOptionByVisibleText(selectValues);

        assertEquals(dropdownPage.getAllSelectedOptions(), selectValues);
        captureScreenShot("MultiSelectByVisibleText");
    }

    @Test()
    public void testDeselectAll() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        List<String> selectValues = List.of("New York", "New Jersey", "Washington");
        dropdownPage.selectMultipleOptionByVisibleText(selectValues);
        dropdownPage.deselectAllValues();

        assertEquals(dropdownPage.getAllSelectedOptions(), List.of());

        captureScreenShot("DeselectAll");
    }

    @Test()
    public void testDeselectByIndex() {
        DropdownPage dropdownPage = new DropdownPage(driver);

        dropdownPage.selectMultipleOptionByVisibleText(List.of("Florida", "New York", "Texas", "Washington"));
        dropdownPage.deselectByIndex(new int[]{3, 7});
        assertEquals(dropdownPage.getAllSelectedOptions(), List.of("Florida", "Texas"));
        captureScreenShot("DeselectByIndex");
    }

    @Test()
    public void testDeselectByValue() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.selectMultipleOptionByVisibleText(List.of("New York", "New Jersey", "Washington"));

        dropdownPage.deselectByValue(List.of("New Jersey"));
        assertEquals(dropdownPage.getAllSelectedOptions(), List.of("New York", "Washington"));
        captureScreenShot("DeselectByValue");
    }

    @Test()
    public void testDeselectByVisibleText() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.selectMultipleOptionByVisibleText(List.of("New York", "New Jersey", "Washington"));

        dropdownPage.deselectByVisibleText(List.of("Washington", "New Jersey"));
        assertEquals(dropdownPage.getAllSelectedOptions(), List.of("New York"));
        captureScreenShot("DeselectByVisibleText");
    }

    @Test()
    public void testFirstSelectedOption() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.selectMultipleOptionByVisibleText(List.of("Florida", "Ohio", "Texas"));
        assertEquals(dropdownPage.getFirstSelectedOption(), "Florida");
        captureScreenShot("FirstSelectedOption");
    }
}