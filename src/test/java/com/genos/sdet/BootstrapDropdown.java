package com.genos.sdet;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootstrapDropdown {
    
    public static void main(String[] args)
    {
        WebDriver driver = null;

        try 
        {
            
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
            driver.manage().window().maximize();
            
            driver.get("https://demoqa.com/select-menu");

            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='react-select-2-input']")));
            dropdown.click();
            System.out.println("Dropdpwn is clicked");

            WebElement dropdownValue =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='react-select-2-option-0-0']")));
            dropdownValue.click();
            System.out.println("The dropdown Value is clicked");


            WebElement selectedValue = driver.findElement(By.xpath("//div[@class='css-1dimb5e-singleValue']"));
            String selectedValueDropDown = selectedValue.getText();

            if(selectedValueDropDown.equals("Group 1, option 1"))
            {
                System.out.println("The Expected Dropdown value is clicked correctly");
            }
            else
            {
                   System.out.println("he Expected Dropdown value is not clicked correctly");
            }
           


        } catch (Exception e) {
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
