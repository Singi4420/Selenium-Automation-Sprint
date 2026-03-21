package com.genos.sdet;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AlertsExample {

    public static void main(String[] args)
    {
        WebDriver driver = null;

        try 
        {
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();

            driver.get("https://demoqa.com/alerts");


           WebElement clickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='alertButton']")));
           wait.until(ExpectedConditions.elementToBeClickable(clickBtn));
           clickBtn.click();
           System.out.println("Simple alert button is clicked");
           Alert simpleAlert = driver.switchTo().alert();
           System.out.println("Simple Alert Text is " + simpleAlert.getText());
           simpleAlert.accept();
           Thread.sleep(5);

    
            WebElement clickBtn1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='confirmButton']")));
           wait.until(ExpectedConditions.elementToBeClickable(clickBtn));
           clickBtn1.click();
           System.out.println(" Confirmation Alert button is clicked");
           Alert confirmationAlert = driver.switchTo().alert();
           System.out.println("Confirmation Alert Text is " + confirmationAlert.getText());
           confirmationAlert.dismiss();
           WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='confirmResult']")));
           String resultMsg = result.getText();
           System.out.println(resultMsg);
           Thread.sleep(5);



          WebElement clickBtn2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='promtButton']")));
           wait.until(ExpectedConditions.elementToBeClickable(clickBtn));
           clickBtn2.click();
           System.out.println("Prompt alert  button is clicked");
           Alert promptAlert = driver.switchTo().alert();
           System.out.println("Prompt Alert Text is " + promptAlert.getText());
           promptAlert.sendKeys("Genos");
           promptAlert.accept();
           WebElement result1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='promptResult']")));
           String resultMsg1 = result1.getText();
           System.out.println(resultMsg1);
          



        }
        catch (Exception e) 
        {
            System.err.println("Test Failed : " + e.getMessage());
            e.printStackTrace();
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
