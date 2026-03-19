package com.genos.sdet;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxExample
{

    public static void main(String[] args)
    {
        WebDriver driver = null;

        try
        {
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.manage().window().maximize();

            driver.get("https://demoqa.com/checkbox");

            WebElement expandBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'rc-tree-switcher_close')]")));
            System.out.println("Expand button is Clickable");
            expandBtn.click();

            WebElement desktop = driver.findElement(By.xpath("//span[normalize-space(text())='Desktop']/ancestor::div[contains(@class,'rc-tree-treenode')]/descendant::span[contains(@class,'rc-tree-checkbox')]"));
            if(desktop.isDisplayed())
            {
                System.out.println("The Desktp checkbox is displayed");
                desktop.click();
                if(desktop.isEnabled())
                {
                    System.out.println("The Desktop checbox is selected");
                }
            }
            else
            {
                System.out.println("The Desktop checkbox is not displayed");
            }

             WebElement documents = driver.findElement(By.xpath("//span[normalize-space(text())='Documents']/ancestor::div[contains(@class,'rc-tree-treenode')]/descendant::span[contains(@class,'rc-tree-checkbox')]"));
            if(documents.isDisplayed())
            {
                System.out.println("The Document checkbox is displayed");
                documents.click();
                if(documents.isEnabled())
                {
                    System.out.println("The Document checbox is selected");
                }
            }
            else
            {
                System.out.println("The Document checkbox is not displayed");
            }

            WebElement downloads = driver.findElement(By.xpath("//span[normalize-space(text())='Downloads']/ancestor::div[contains(@class,'rc-tree-treenode')]/descendant::span[contains(@class,'rc-tree-checkbox')]"));
            if(downloads.isDisplayed())
            {
                System.out.println("The Downloads checkbox is displayed");
                downloads.click();
                if(downloads.isEnabled())
                {
                    System.out.println("The Downloads checbox is selected");
                }
            }
            else
            {
                System.out.println("The Downloads checkbox is not displayed");
            }

            List<WebElement> results = driver.findElements(By.xpath("//span[@class='text-success']"));

            for(WebElement element:results)
            {
                String word = element.getText();

                if(word.equalsIgnoreCase("desktop") || word.equalsIgnoreCase("documents") ||  word.equalsIgnoreCase("downloads"))
                {
                    System.out.println("Printing the selected checkboxes");
                    System.out.println(word);
                }
            }
    


        }
        catch(Exception e)
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
