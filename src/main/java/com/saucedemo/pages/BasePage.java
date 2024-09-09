package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Super class for Page Objects
public class BasePage {
    public static WebDriver driver;

    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }
    // Protected because you only want to use this in your parent or child classes
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected void set(By locator, String text){
        find(locator).clear(); // Clears data in the element
        find(locator).sendKeys(text); // Sends string text to element
    }

    protected void click(By locator){
        find(locator).click();
    }
}
