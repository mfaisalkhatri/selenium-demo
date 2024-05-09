package io.github.mfaisalkhatri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static org.testng.Assert.assertEquals;


public class SeleniumLocatorDemoTests {

    private WebDriver driver;
@BeforeTest
public void setup () {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}

@AfterTest
public void tearDown() {
    driver.quit();
}



    @Test
    public void testIdLocator() throws InterruptedException {

    driver.get("https://juice-shop.herokuapp.com/#/register");
    WebElement emailField = driver.findElement(By.id("emailControl"));
    emailField.sendKeys("faisal@demo.com");
    Thread.sleep(2000);

    }

    @Test
    public void testNameLocator() {
    driver.get("https://the-internet.herokuapp.com/login");
    WebElement usernameField = driver.findElement(By.name("username"));
    usernameField.sendKeys("faisal@demo.com");

    }

    

    @Test
    public void testRelativeLocators() {

        driver.navigate().to("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");

        WebElement montanaJacket = driver.findElement(By.cssSelector(".products.wrapper ol li:nth-child(2) .product.details a.product-item-link"));

        WebElement belowMontanaJacket = driver.findElement(with(By.cssSelector(".products.wrapper ol li .product.details a.product-item-link")).below(montanaJacket));
        assertEquals (belowMontanaJacket.getText(), "Taurus Elements Shell");

        WebElement leftOfMontanaJacket = driver.findElement(with(By.cssSelector(".products.wrapper ol li .product.details a.product-item-link")).toLeftOf(montanaJacket));
        assertEquals (leftOfMontanaJacket.getText(), "Proteus Fitness Jackshirt");

        WebElement rightOfMontanaJacket = driver.findElement(with(By.cssSelector(".products.wrapper ol li .product.details a.product-item-link")).toRightOf(montanaJacket));
        assertEquals (rightOfMontanaJacket.getText(), "Jupiter All-Weather Trainer");

        WebElement kenobiJacket = driver.findElement(By.cssSelector(".products.wrapper ol li:nth-child(9) .product.details a.product-item-link"));
        WebElement aboveKenobiJacket = driver.findElement(with(By.cssSelector(".products.wrapper ol li .product.details a.product-item-link")).above(kenobiJacket));
        assertEquals (aboveKenobiJacket.getText(), "Mars HeatTech™ Pullover");


        WebElement nearMontanaJacket = driver.findElement(with(By.className("price-wrapper")).near(montanaJacket));
        assertEquals (nearMontanaJacket.getText(), "$49.00");
    }


}
