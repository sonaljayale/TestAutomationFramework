package com.automationbysonal.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ElementFindBy {
    WebDriver driver;
    public ElementFindBy(WebDriver driver){
        this.driver = driver;
    }
    public By findBy(String element) throws Exception {
        By by;
        RepositoryLoader loader = new RepositoryLoader();
        loader.loadProperties();
        String elementValue = loader.getProperty(element);
        String findBy = elementValue.split(":")[0];
        String findByValue = elementValue.split(":")[1];
        if (findBy.equalsIgnoreCase("xpath")) {
            by = By.xpath(findByValue);
        } else if (findBy.equalsIgnoreCase("id")) {
            by = By.xpath(findByValue);
        } else if (findBy.equalsIgnoreCase("name")) {
            by = By.xpath(findByValue);
        } else if (findBy.equalsIgnoreCase("class")) {
            by = By.xpath(findByValue);
        } else if (findBy.equalsIgnoreCase("css")) {
            by = By.xpath(findByValue);
        } else if (findBy.equalsIgnoreCase("linkText")) {
            by = By.xpath(findByValue);
        } else if (findBy.equalsIgnoreCase("partiallinkText")) {
            by = By.xpath(findByValue);
        } else {
            throw new Exception("Invalid Locator Type/Value in [" + element + "].");
        }
        return by;
    }

    public WebElement findElementBy(String element) throws Exception {
        By by = findBy(element);
        return driver.findElement(by);
    }

}
