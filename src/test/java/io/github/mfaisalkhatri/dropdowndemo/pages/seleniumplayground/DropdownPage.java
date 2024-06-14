package io.github.mfaisalkhatri.dropdowndemo.pages.seleniumplayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

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

    public void selectMultipleOptionByValue(List<String> values) {
        refreshPage();
        for (int i = 0; i < values.size(); i++) {
            multiSelectDropdown().selectByValue(values.get(i).toString());
        }
    }

    public void selectMultipleOptionByIndex(int[] index) {
        refreshPage();
        for (int i = 0; i < index.length; i++) {
            multiSelectDropdown().selectByIndex(index[i]);
        }
    }

    public void selectMultipleOptionByVisibleText(List<String> text) {
        refreshPage();
        for (int i = 0; i < text.size(); i++) {
            multiSelectDropdown().selectByVisibleText(text.get(i).toString());
        }
    }

    public List<String> getAllSelectedOptions() {
        List<WebElement> allOptions = multiSelectDropdown().getAllSelectedOptions();
        List<String> selectedOptions = new ArrayList<>();
        for (int i = 0; i < allOptions.size(); i++) {
            selectedOptions.add(allOptions.get(i).getText());
        }
        return selectedOptions;
    }

    public void deselectAllValues() {
        multiSelectDropdown().deselectAll();
    }

    public void deselectByIndex(int[] index) {
        for (int i = 0; i < index.length; i++) {
            multiSelectDropdown().deselectByIndex(index[i]);
        }
    }

    public void deselectByValue(List<String> values) {
        for (int i = 0; i < values.size(); i++) {
            multiSelectDropdown().deselectByValue(values.get(i).toString());
        }
    }

    public void deselectByVisibleText(List<String> text) {

        for (int i = 0; i < text.size(); i++) {
            multiSelectDropdown().deselectByVisibleText(text.get(i).toString());
        }
    }

    public String getFirstSelectedOption() {
        return multiSelectDropdown().getFirstSelectedOption().getText();
    }

}