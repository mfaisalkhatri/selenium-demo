package io.github.mfaisalkhatri.paginationdemo.tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import io.github.mfaisalkhatri.paginationdemo.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumPaginationTests {

    private WebDriver driver;

    @BeforeTest
    public void setup () {

        this.driver = new ChromeDriver ();
        this.driver.manage ()
            .window ()
            .maximize ();
        this.driver.manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (10));
    }

    @AfterTest
    public void tearDown () {
        this.driver.quit ();
    }

    @Test
    public void testFilterRecordsOnPage () {
        this.driver.get ("https://ecommerce-playground.lambdatest.io/index.php?route=product/category&path=25_28");

        final ProductPage productPage = new ProductPage (this.driver);
        productPage.changeFilterRecord ("50");
        assertTrue (productPage.paginationDetails ()
            .contains ("2 Pages"));
    }

    @Test
    public void testPageNavigation () {
        this.driver.get ("https://ecommerce-playground.lambdatest.io/index.php?route=product/category&path=25_28");

        final ProductPage productPage = new ProductPage (this.driver);
        productPage.navigateToLastPage ();
        assertTrue (productPage.paginationDetails ()
            .contains ("Showing 61 to 75 of 75"));

        productPage.navigateToFirstPage ();
        assertTrue (productPage.paginationDetails ()
            .contains ("Showing 1 to 15 of 75"));
    }

    @Test
    public void testProductDetailsOnAllPage () {
        this.driver.get ("https://ecommerce-playground.lambdatest.io/index.php?route=product/category&path=25_28");

        final ProductPage productPage = new ProductPage (this.driver);
        assertTrue (productPage.paginationDetails ()
            .contains ("5 Pages"));
        productPage.printProductDetailsOnPages ();
    }

    @Test
    public void testSearchForProduct () {
        this.driver.get ("https://ecommerce-playground.lambdatest.io/index.php?route=product/category&path=25_28");

        final ProductPage productPage = new ProductPage (this.driver);
        productPage.searchForProduct ("HP LP3065");
    }
}