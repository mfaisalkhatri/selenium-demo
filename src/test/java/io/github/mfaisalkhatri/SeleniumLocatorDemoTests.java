package io.github.mfaisalkhatri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static org.testng.Assert.assertEquals;


public class SeleniumLocatorDemoTests {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void testIdLocator() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/login");
        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys("faisal@demo.com");
        Thread.sleep(2000);

    }

    @Test
    public void testNameLocator() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("faisal@demo.com");
        Thread.sleep(2000);
    }

    @Test
    public void testLinkTextLocator() throws InterruptedException  {
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dragAndDropLink = driver.findElement(By.linkText("Drag and Drop"));
        dragAndDropLink.click();
        Thread.sleep(2000);
    }

    @Test
    public void testPartialLinkTextLocator() throws InterruptedException  {
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dragAndDropLink = driver.findElement(By.partialLinkText("Context"));
        dragAndDropLink.click();
        Thread.sleep(2000);
    }

    @Test
    public void testTagNameLocator() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dragAndDropLink = driver.findElement(By.partialLinkText("Drag and Drop"));
        dragAndDropLink.click();
        WebElement pageTitle = driver.findElement(By.tagName("h3"));
        System.out.println(pageTitle.getText());

        //Finding all links on the page
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> pageLinks = driver.findElements(By.tagName("a"));
        for(int i=0; i<pageLinks.size(); i++) {
            System.out.println(pageLinks.get(i).getText());
        }

    }

    @Test
    public void testClassName () throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/forgot_password");
        WebElement retrievePasswordBtn = driver.findElement(By.className("radius"));
        retrievePasswordBtn.click();
        Thread.sleep(2000);
    }

    @Test
    public void testSimplkeXpathLocators() {
        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        WebElement nameField = driver.findElement(By.xpath("input[@id='title']"));
        nameField.sendKeys("Faisal");
        WebElement messageField = driver.findElement(By.xpath("//textarea[contains(@name, 'description')]"));
        messageField.sendKeys("This is test message");
    }

    @Test
    public void testXpathAndOr() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement usernameField = driver.findElement(By.xpath("//input[@id=\"username\" or @name=\"username\"]"));
        usernameField.sendKeys("faisal@demo.co.in");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password' and @name ='password']"));
        passwordField.sendKeys("Password123");

        Thread.sleep(2000);

    }

    



    @Test
    public void testRelativeLocators() {

        driver.navigate().to("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");

        WebElement montanaJacket = driver.findElement(By.cssSelector(".products.wrapper ol li:nth-child(2) .product.details a.product-item-link"));

        WebElement belowMontanaJacket = driver.findElement(with(By.cssSelector(".products.wrapper ol li .product.details a.product-item-link")).below(montanaJacket));
        assertEquals(belowMontanaJacket.getText(), "Taurus Elements Shell");

        WebElement leftOfMontanaJacket = driver.findElement(with(By.cssSelector(".products.wrapper ol li .product.details a.product-item-link")).toLeftOf(montanaJacket));
        assertEquals(leftOfMontanaJacket.getText(), "Proteus Fitness Jackshirt");

        WebElement rightOfMontanaJacket = driver.findElement(with(By.cssSelector(".products.wrapper ol li .product.details a.product-item-link")).toRightOf(montanaJacket));
        assertEquals(rightOfMontanaJacket.getText(), "Jupiter All-Weather Trainer");

        WebElement kenobiJacket = driver.findElement(By.cssSelector(".products.wrapper ol li:nth-child(9) .product.details a.product-item-link"));
        WebElement aboveKenobiJacket = driver.findElement(with(By.cssSelector(".products.wrapper ol li .product.details a.product-item-link")).above(kenobiJacket));
        assertEquals(aboveKenobiJacket.getText(), "Mars HeatTech™ Pullover");


        WebElement nearMontanaJacket = driver.findElement(with(By.className("price-wrapper")).near(montanaJacket));
        assertEquals(nearMontanaJacket.getText(), "$49.00");
    }


}
