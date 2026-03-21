package com.genos.sdet;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WindowsExample {

    public static void main(String[] args)
    {
        WebDriver driver = null;

        try
        {
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();

            driver.get("https://demoqa.com/browser-windows");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='text-center' and text()='Browser Windows']")));
            String pageTitle = driver.getTitle();
            System.out.println(pageTitle + " page is opened");

            String parent = driver.getWindowHandle();

            WebElement newTabBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='tabButton']")));
            newTabBtn.click();
            System.out.println("New Tab Button is clicked");

            Set<String> windowHandles = driver.getWindowHandles();
            for(String tab: windowHandles)
            {
                if(!tab.equals(parent))
                {
                    driver.switchTo().window(tab);
                    System.out.println("---Switched to New Tab---");
                    System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
                    break;
                }
            }

            driver.switchTo().window(parent);
            System.out.println("---Switched to parent Tab---");

            WebElement newWindowBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='windowButton']")));
            newWindowBtn.click();
            System.out.println("New Window Button is clicked");
             Set<String> windowHandles1 = driver.getWindowHandles();
            for(String window: windowHandles1)
            {
                if(!window.equals(parent))
                {
                    driver.switchTo().window(window);
                    System.out.println("---Switched to New Window---");
                    System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
                    break;
                }
            }

        } 
        catch (Exception e) 
        {
            System.err.println("Test Failed : " + e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            if(driver!= null)
            {
                driver.quit();
                System.out.println("Browser closed in finally");
            }
        }
    }
    
}
