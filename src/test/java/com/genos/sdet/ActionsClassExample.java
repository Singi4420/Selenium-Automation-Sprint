package com.genos.sdet;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActionsClassExample {

    public static void main(String[] args)
    {
        WebDriver driver = null;

        try
        {
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            driver.manage().window().maximize();

            driver.get("https://demoqa.com/buttons");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='text-center']")));
            String pageTitle = driver.getTitle();
            System.out.println(pageTitle + " page opened sucessfully");

            Actions action = new Actions(driver);

            WebElement doubleClickBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='doubleClickBtn']")));
             System.out.println("Button is clickable");
            action.doubleClick(doubleClickBtn).perform();
            String dbMsg = driver.findElement(By.xpath("//p[@id='doubleClickMessage']")).getText();
            if(dbMsg.equals("You have done a double click"))
            {
                System.out.println(dbMsg);
            }
            else
            {
                System.out.println("Double click not happened");
            }

            WebElement rightClickBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='rightClickBtn']")));
            System.out.println("Button is clickable");
            action.contextClick(rightClickBtn).perform();
            String rightMsg = driver.findElement(By.xpath("//p[@id='rightClickMessage']")).getText();
            if(rightMsg.equals("You have done a right click"))
            {
                System.out.println(rightMsg);
            }
            else
            {
                System.out.println("Right click not happened");
            }

             WebElement ClickBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click Me']")));
              System.out.println("Button is clickable");
            action.click(ClickBtn).perform();
            String clickMsg = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']")).getText();
            if(clickMsg.equals("You have done a dynamic click"))
            {
                System.out.println(clickMsg);
            }
            else
            {
                System.out.println("click not happened");
            }


        } 
        catch (Exception e) 
        {
            System.err.println("Test Failed : " + e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            if(driver!=null)
            {
                driver.quit();
                System.out.println("Browser closed in Finally");
            }
        }
    }
    
}
