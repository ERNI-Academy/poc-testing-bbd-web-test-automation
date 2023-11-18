package com.erni.commons;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.erni.commons.utils.CommonUtility;
import com.erni.stepdefinitions.LoginDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class provides Cucumber hooks to set up and tear down WebDriver instances for tests.
 * 
 * @author faju
 *
 */
public class Hooks {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private Logger logger = LoggerFactory.getLogger(LoginDefinition.class);

    public static String browser;
    public static String hubAddress;
    public static String baseUrl;

    /**
     * Constructor to initialize browser, hub address, and base URL from properties.
     *
     * @throws IOException If an error occurs while reading properties.
     */
    public Hooks() throws IOException {
        Properties props = CommonUtility.loadProperties();
        browser = props.getProperty("browser");
        hubAddress = props.getProperty("hubAddress");
        baseUrl = props.getProperty("baseUrl");
    }

    /**
     * Before hook to set up the WebDriver instance for the test.
     *
     * @throws InterruptedException If the thread is interrupted.
     * @throws MalformedURLException If the URL is malformed.
     */
    @Before
    public void setUp() throws InterruptedException, MalformedURLException {
        WebDriver driver;
        try {
        	if (browser.equals("googlechrome")) {
            	WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                options.addArguments("--remote-allow-origins=*");
                options.setAcceptInsecureCerts(true);
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);

                driver = new RemoteWebDriver(new URL(hubAddress), options);;
            } else if (browser.equals("firefox")) {
            	WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();

                driver = new RemoteWebDriver(new URL(hubAddress), options);
            } else if (browser.equals("edge")) {
            	WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();

                driver = new RemoteWebDriver(new URL(hubAddress), options);
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            driverThreadLocal.set(driver);
            driver.get(baseUrl);
            driver.manage().window().maximize();
        }catch(Exception e) {
        	logger.error("Error occurred in setUp()", e);
        }
        
    }

    /**
     * After hook to tear down the WebDriver instance after the test.
     */
    @After
    public void tearDown() {
        WebDriver driver = driverThreadLocal.get();
        try {
        	if (driver != null) {
                driver.quit();
            }
        } catch(Exception e) {
        	logger.error("Error occurred in tearDown()", e);
        }
        
    }

    /**
     * Get the WebDriver instance associated with the current thread.
     *
     * @return The WebDriver instance.
     */
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }
}
