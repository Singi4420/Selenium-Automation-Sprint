package com.genos.sdet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RadioButtonExample {

    public static void main(String[] args)
    {
        WebDriver driver = null;

        try
         {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("https://demoqa.com/radio-button");

            WebElement radioBtn = driver.findElement(By.xpath("//input[@id='yesRadio']"));

            if(radioBtn.isEnabled())
            {
                System.out.println("Radio button is enabled");
                radioBtn.click();
                if(radioBtn.isSelected())
                {
                    System.out.println("Radio button is clicked");
                }
                else
                {
                        System.out.println("Radio button is mot clicked");
                }
            }
            else
            {
                System.out.println("Radio button is not enabled");
            }

            WebElement result = driver.findElement(By.xpath("//p[@class='mt-3']"));

            String resultMsg = result.getText();

            System.out.println(resultMsg);


            
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
