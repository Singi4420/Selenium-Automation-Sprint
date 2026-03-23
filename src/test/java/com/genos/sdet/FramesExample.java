package com.genos.sdet;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FramesExample {

    public static void main(String[] args)
    {
        WebDriver driver = null;

        try 
        {
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();

            driver.get("https://demoqa.com/frames");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='text-center' and text()='Frames']")));

             wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='frame1']")));
            System.out.println("-----Frame 1-----");
            String text1 = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
            System.out.println("The text inside frame 1 is : " + text1);

            driver.switchTo().defaultContent();

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='frame2']")));
            System.out.println("-----Frame 2-----");
            String text2 = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
            System.out.println("The text inside frame 2 is : " + text2);


        } 
        catch (Exception e) 
        {
           System.err.println("Test Failed  : " + e.getMessage());
        }
        finally
        {
            if(driver != null)
            {
                driver.quit();
                System.out.println("Browser closed in finally");
            }
        }
    }
    
}
