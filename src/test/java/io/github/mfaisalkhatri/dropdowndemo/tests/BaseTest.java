package io.github.mfaisalkhatri.dropdowndemo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
        //driver.get("https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public void captureScreenShot(String screenshotName) {
        BrowsingContext browsingContext = new BrowsingContext(driver, driver.getWindowHandle());

        String screenshot = browsingContext.captureScreenshot();
        byte[] imgByteArray = Base64.getDecoder().decode(screenshot);

        FileOutputStream imgOutFile = null;
        try {
            imgOutFile = new FileOutputStream("./" + screenshotName + ".png");
            imgOutFile.write(imgByteArray);
            imgOutFile.close();
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }
    }
}