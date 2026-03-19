package com.genos.sdet;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDropDownExample {

    public static void main(String[] args)
    {
        WebDriver driver = null;

        try
        {
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            driver.manage().window().maximize();

            driver.get("https://demoqa.com/select-menu");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='oldSelectMenu']")));

            WebElement selectDropdown = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));

            Select dropdown = new Select(selectDropdown);

            dropdown.selectByVisibleText("Voilet");

            String selectedDropdown = dropdown.getFirstSelectedOption().getText();

            System.out.println("The selected dropdown Value : " + selectedDropdown);

            
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
