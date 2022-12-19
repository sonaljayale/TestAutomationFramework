package com.automationbysonal.brower;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Chrome extends Browser {

    ChromeOptions chromeOptions;

    @Override
    public void setPreferences() {
        chromeOptions = new ChromeOptions();

        if (isHeadless()){
            chromeOptions.setHeadless(true);
        }
        if (isMaximized()) {
            chromeOptions.addArguments("start-maximized");
        }
       /* //Block pop-up windows
        chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));*/

       /* //Set download directory
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        chromeOptions.setExperimentalOption("prefs", prefs);*/

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("excludeSwitches",
                Collections.singletonList("enable-automation"));

        chromeOptions.setExperimentalOption("prefs", prefs);
    }

    @Override
    public WebDriver loadBrowser(String path) {
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver",path );
        if (isRemote()){
           try{
               //selenium grid
               driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeOptions);
           }catch(Exception e){
               e.printStackTrace();
           }
        }else{
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().pageLoadTimeout(getPageLoadTimeOut(), TimeUnit.SECONDS);
            if (isDeleteCookies()){
                driver.manage().deleteAllCookies();
            }
        }
        return driver;
    }
}
