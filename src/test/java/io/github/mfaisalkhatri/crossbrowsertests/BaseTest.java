package io.github.mfaisalkhatri.crossbrowsertests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BaseTest {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    @BeforeTest
    @Parameters("browser")
    public void setup(final String browser) {
        final String userName = System.getenv("LT_USERNAME") == null ? "LT_USERNAME" : System.getenv("LT_USERNAME");
        final String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "LT_ACCESS_KEY" : System.getenv("LT_ACCESS_KEY");
        final String gridUrl = "@hub.lambdatest.com/wd/hub";

        if (browser.equalsIgnoreCase("REMOTE_CHROME")) {
            final ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPlatformName("Windows 10");
            chromeOptions.setBrowserVersion("121.0");
            chromeOptions.setCapability("LT:Options", getLtOptions());
            try {
                DRIVER.set(new RemoteWebDriver(new URL("http://" + userName + ":" + accessKey + gridUrl), chromeOptions));
            } catch (final MalformedURLException e) {
                throw new Error("Could not start the Chrome remote session on LambdaTest cloud grid");
            }

        } else if (browser.equalsIgnoreCase("REMOTE_EDGE")) {
            final EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setPlatformName("Windows 10");
            edgeOptions.setBrowserVersion("121.0");
            edgeOptions.setCapability("LT:Options", getLtOptions());
            try {
                DRIVER.set(new RemoteWebDriver(new URL("http://" + userName + ":" + accessKey + gridUrl), edgeOptions));
            } catch (final MalformedURLException e) {
                throw new Error("Could not start the Chrome remote session on LambdaTest cloud grid");
            }

        } else if (browser.equalsIgnoreCase("REMOTE_FIREFOX")) {
            final FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setPlatformName("Windows 10");
            firefoxOptions.setBrowserVersion("122.0");
            firefoxOptions.setCapability("LT:Options", getLtOptions());
            try {
                DRIVER.set(new RemoteWebDriver(new URL("http://" + userName + ":" + accessKey + gridUrl), firefoxOptions));
            } catch (final MalformedURLException e) {
                throw new Error("Could not start the Chrome remote session on LambdaTest cloud grid");
            }


        } else if (browser.equalsIgnoreCase("REMOTE_SAFARI")) {
            final SafariOptions safariOptions = new SafariOptions();
            safariOptions.setPlatformName("macOS Sonoma");
            safariOptions.setBrowserVersion("17.0");
            safariOptions.setCapability("LT:Options", getLtOptions());
            try {
                DRIVER.set(new RemoteWebDriver(new URL("http://" + userName + ":" + accessKey + gridUrl), safariOptions));
            } catch (final MalformedURLException e) {
                throw new Error("Could not start the Chrome remote session on LambdaTest cloud grid");
            }
        } else {
            throw new Error("Browser name is not specified correctly. It should be either chrome, firefox, edge or safari!!");
        }
    }

    private HashMap<String, Object> getLtOptions() {
        HashMap<String, Object> ltOptions = new HashMap();
        ltOptions.put("build", "Selenium Cross Browser Tests");
        ltOptions.put("project", "Selenium Demo");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        return ltOptions;
    }

    public WebDriver getDriver() {
        return DRIVER.get();
    }

    @AfterTest
    public void tearDown() {
        DRIVER.get().quit();
    }


}
