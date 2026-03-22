package com.genos.sdet;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Screenshots {
    
    public static void main(String[] args) {
        
        WebDriver driver = null;    


        try 
        {
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));     

            driver.manage().window().maximize();
            driver.get("https://demoqa.com/text-box");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='text-center']")));  

            // Take full page screenshot

            String pageTitle = driver.getTitle();
            System.out.println(pageTitle + " page is opened successfully");     
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir")+"\\Screenshots\\fullpage.png");
            destination.getParentFile().mkdirs(); // Create directory if it doesn't exist
            source.renameTo(destination);
            System.out.println("Full page screenshot taken successfully");

            // Take element screenshot
            WebElement currentAddressField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='currentAddress']")));
            File sourceFile = currentAddressField.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(System.getProperty("user.dir")+"\\Screenshots\\currentAddressField.png");
            destinationFile.getParentFile().mkdirs(); // Create directory if it doesn't exist   
            sourceFile.renameTo(destinationFile);
            System.out.println("Element screenshot taken successfully");
            

            
        } 
        catch (Exception e) 
        {
           System.err.println("Test Failed :" + e.getMessage());
           e.printStackTrace();
        }
        finally
        {
            if(driver != null)
            {
                driver.quit();
                System.out.println("Browser closed in finally.");
            }
        }
    }

}
