package com.automationbysonal.brower;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Firefox extends Browser{

    FirefoxOptions firefoxOptions;

    @Override
    public void setPreferences() {
        firefoxOptions = new FirefoxOptions();

        if (isHeadless()){
            firefoxOptions.setHeadless(true);
        }
        if (isMaximized()) {
            firefoxOptions.addArguments("start-maximized");
        }

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("excludeSwitches",
                Collections.singletonList("enable-automation"));

        firefoxOptions.setCapability("prefs", prefs);

    }

    @Override
    public WebDriver loadBrowser(String path) {

        WebDriver driver = null;
        System.setProperty("webdriver.firefox.driver",path );
        if (isRemote()){
            try{
                //selenium grid
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),firefoxOptions);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            driver = new FirefoxDriver(firefoxOptions);
            driver.manage().timeouts().pageLoadTimeout(getPageLoadTimeOut(), TimeUnit.SECONDS);
            if (isDeleteCookies()){
                driver.manage().deleteAllCookies();
            }
        }
        return driver;
    }

}
