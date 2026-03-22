package com.genos.sdet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage {

    WebDriver driver;

    public TextBoxPage(WebDriver driver)
    {
        this.driver = driver;
    }

    By nameField = By.id("userName");
    By currentAddrssField = By.id("currentAddress");

    

    public void enterName(String name)
    {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterCurrentAddress(String currentAddress)
    {
        driver.findElement(currentAddrssField).sendKeys(currentAddress);
    }

    public String getName()
    {
        return driver.findElement(nameField).getAttribute(("value"));
    }
     public String getCurrentAddress()
    {
        return driver.findElement(currentAddrssField).getAttribute(("value"));
    }

    
}
