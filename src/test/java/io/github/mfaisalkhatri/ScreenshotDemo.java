package io.github.mfaisalkhatri;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;


public class ScreenshotDemo {

    private WebDriver driver;
    private File file;


    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        driver = new ChromeDriver(options);
    }

    @Test
    public void testTakeScreenshot() throws IOException {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        BrowsingContext browsingContext = new BrowsingContext(driver, driver.getWindowHandle());

        driver.get("https://ecommerce-playground.lambdatest.io/");

        String screenshot = browsingContext.captureScreenshot();
        byte[] imgByteArray = Base64.getDecoder().decode(screenshot);

        file = new File("./screenshots/screenshot_homepage.png");
        FileOutputStream imgOutFile = new FileOutputStream( file);
        imgOutFile.write(imgByteArray);
        imgOutFile.close();


    }

    @AfterTest
    public void tearDown() {
        String filePath = file.getPath();
        String imagePath = "<a href='" +filePath + "'> <img src='"+ filePath + "' height = '100' width='100'/> </a>";
        Reporter.log(imagePath);
        driver.quit();
    }



}
