package io.github.mfaisalkhatri.dropdowndemo.pages.seleniumplayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

    private WebDriver driver;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    private Select singleSelectDropdown() {
        WebElement singleDropdownField = driver.findElement(By.id("select-demo"));
        return new Select(singleDropdownField);
    }

    public void selectByValue(String value) {

        singleSelectDropdown().selectByValue(value);
    }

    public void selectByIndex(int index) {
        singleSelectDropdown().selectByIndex(index);
    }
    public void selectByVisibleText(String text) {
        singleSelectDropdown().selectByVisibleText(text);
    }

    public String getSelectedValue () {
        return singleSelectDropdown().getFirstSelectedOption().getText();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    private Select multiSelectDropdown() {
        WebElement multiSelectField = driver.findElement(By.id("multi-select"));
        return new Select(multiSelectField);
    }

    public boolean isMultipleSelectionAllowed() {
        return multiSelectDropdown().isMultiple();
    }

    public void selectMultipleOptionByValue(final String[] values) {
        refreshPage();
        for (int i = 0; i < values.length; i++) {
            multiSelectDropdown().selectByVisibleText(values[i]);
        }
    }

    public void selectMultipleOptionByIndex(final int[] index) {
        refreshPage();
        for (int i = 0; i < index.length; i++) {
            multiSelectDropdown().selectByIndex(index[i]);
        }
    }

    public void selectMultipleOptionByVisibleText(final String[] text) {
        refreshPage();
        for (int i = 0; i < text.length; i++) {
            multiSelectDropdown().selectByVisibleText(text[i]);
        }
    }
}