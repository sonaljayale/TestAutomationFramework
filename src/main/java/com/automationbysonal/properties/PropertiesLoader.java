package com.automationbysonal.properties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesLoader {
    static Properties configProperties;
    public static String runOnBrowser;
    public static Boolean takeScreenshot;
    public static String chromeDriverPath;
    public static String edgeDriverPath;
    public static String firefoxDriverPath;
    public static Boolean maximizedMode;
    public static Integer implicitWaitTime;
    public static Integer explicitWaitTime;
    public static Integer pageLoadWaitTime;
    public static Boolean deleteCookies;
    public static Boolean headless;
    public static Boolean remoteRun;

    public static void initializeProperties() throws Exception{
        if (configProperties == null){
            configProperties = new Properties();
            //proving path for configs file
            FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+"//src//test//resources//configs.properties"));
            configProperties.load(fileInputStream);
        }
        runOnBrowser = configProperties.getProperty("RunOnBrowser");
        takeScreenshot = Boolean.valueOf(configProperties.getProperty("TakeScreenshot"));
        chromeDriverPath = configProperties.getProperty("ChromeDriverPath");
        edgeDriverPath = configProperties.getProperty("EdgeDriverPath");
        firefoxDriverPath = configProperties.getProperty("FirefoxDriverPath");
        maximizedMode = Boolean.valueOf(configProperties.getProperty("MaximizedMode"));
        implicitWaitTime = Integer.valueOf(configProperties.getProperty("ImplicitWait"));
        explicitWaitTime = Integer.valueOf(configProperties.getProperty("ExplicitWait"));
        pageLoadWaitTime = Integer.valueOf(configProperties.getProperty("PageLoadWait"));
        headless = Boolean.valueOf(configProperties.getProperty("headless"));
        deleteCookies = Boolean.valueOf(configProperties.getProperty("deleteCookies"));
        remoteRun = Boolean.valueOf(configProperties.getProperty("remoteRun"));

    }

    public static void validateConfigurations() {
    }
}
    /* load the configuration properties from the file
    Properties props = PropertyLoader.loadProperties("config.properties");

    // get the browser to use for testing
    String browser = props.getProperty("browser");

    // create a new WebDriver instance using the specified browser
    WebDriver driver = new FirefoxDriver();

// navigate to the base URL of the website being tested
driver.get(props.getProperty("baseUrl"));*/
