package io.github.mfaisalkhatri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.lang.constant.DirectMethodHandleDesc;
import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static org.testng.Assert.assertEquals;

public class SeleniumLocatorDemoTests {

    @Test
    public void testRelativeLocators() {
        final WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement montanaJacket = driver.findElement(By.cssSelector(".products.wrapper ol li:nth-child(2) .product.details a.product-item-link"));

        WebElement belowMontanaJacket = driver.findElement(with(By.cssSelector(".products.wrapper ol li .product.details a.product-item-link")).below(montanaJacket));
        System.out.println(belowMontanaJacket.getText());

        WebElement leftOfMontanaJacket = driver.findElement(with(By.cssSelector(".products.wrapper ol li .product.details a.product-item-link")).toLeftOf(montanaJacket));
        System.out.println(leftOfMontanaJacket.getText());

        WebElement rightOfMontanaJacket = driver.findElement(with(By.cssSelector(".products.wrapper ol li .product.details a.product-item-link")).toRightOf(montanaJacket));
        System.out.println(rightOfMontanaJacket.getText());

        WebElement kenobiJacket = driver.findElement(By.cssSelector(".products.wrapper ol li:nth-child(9) .product.details a.product-item-link"));

        WebElement aboveKenobiJacket = driver.findElement(with(By.cssSelector(".products.wrapper ol li .product.details a.product-item-link")).above(kenobiJacket));
        System.out.println(aboveKenobiJacket.getText());

        WebElement nearMontanaJacket = driver.findElement(with(By.className("price-wrapper")).near(montanaJacket));
        System.out.println(nearMontanaJacket.getText());

        driver.quit();
    }

}
