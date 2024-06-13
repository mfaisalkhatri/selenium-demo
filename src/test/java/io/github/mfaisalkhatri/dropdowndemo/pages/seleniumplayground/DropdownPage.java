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
}
