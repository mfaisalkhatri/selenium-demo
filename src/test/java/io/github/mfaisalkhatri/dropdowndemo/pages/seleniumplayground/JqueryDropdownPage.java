package io.github.mfaisalkhatri.dropdowndemo.pages.seleniumplayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JqueryDropdownPage {

    private WebDriver driver;

    public JqueryDropdownPage(WebDriver driver) {
        this.driver = driver;
    }


    private WebElement countryDropdown() {
        return driver.findElement(By.cssSelector("div:nth-child(1) > div.py-20.px-10 span.selection > span"));
    }

    private WebElement searchBoxInCountryField() {
        return driver.findElement(By.cssSelector("span:nth-child(1) > input.select2-search__field"));
    }

    private WebElement searchResult() {
        return driver.findElement(By.cssSelector("#select2-country-results > li"));
    }

    public void selectCountry(String countryName) {
        countryDropdown().click();
        searchBoxInCountryField().sendKeys(countryName);
        searchResult().click();
    }

    public String getOption () {
        return driver.findElement(By.cssSelector("#select2-country-container")).getText();
    }
}
