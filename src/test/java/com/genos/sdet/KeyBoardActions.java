package com.genos.sdet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyBoardActions {

    public static void main(String[] args)
    {
        WebDriver driver = null;

        try
        {
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            driver.manage().window().maximize();

            driver.get("https://demoqa.com/text-box");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='text-center']")));
            String pageTitle = driver.getTitle();
            System.out.println(pageTitle + " page is opened successfully");

            Actions action = new Actions(driver);

            WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='userName']")));
            System.out.println("Entering the name in the field");
            action.click(nameField)
                  .sendKeys("Genos")
                  .keyDown(Keys.CONTROL)
                  .sendKeys("a")
                  .sendKeys("c")
                  .keyUp(Keys.CONTROL)
                  .perform();
            System.out.println("Name value copied from the field");

            WebElement currentAddresField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='currentAddress']")));
            System.out.println("Pasting the copied text in the Current address field");
            action.click(currentAddresField)
                  .keyDown(Keys.CONTROL)
                  .sendKeys("v")
                  .keyUp(Keys.CONTROL)
                  .perform();
            System.out.println("Copied text value pasted in the Current Addrss field");

            String nameValue = nameField.getAttribute("value");
            String currentAddressValue = currentAddresField.getAttribute("value");
            System.out.println("Name And CurrentAddress Value comparision : ");
            if(nameValue.equals(currentAddressValue))
            {
                System.out.print("Validation Passed");
            }
            else
            {
                System.out.print("Validation Failed");
            }
            System.out.println("");

            
        } 
        catch (Exception e) 
        {
            System.err.println("Test Failed :" + e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            if(driver!=null)
            {
                driver.quit();
                System.out.println("Browser closed in finally");
            }
        }
    }
    
}
