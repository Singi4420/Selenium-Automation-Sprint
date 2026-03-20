package com.genos.sdet;
import java.util.List;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AutoSuggestionDropdown {

    public static void main(String[] args)
    {
        WebDriver driver = null;

        try 
        {
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://www.bing.com");

            WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[contains(@aria-label,'Search')]")));
            System.out.println("Entering the value in Search field");
            searchField.sendKeys("Selenium");

            List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@role,'option') and contains(@query,'selenium')]")));
            System.out.println("Suggestions listed for the search input are Listed Below : ");

            for(WebElement suggestion: suggestions)
            {
                String word = suggestion.getText();
                System.out.println(word);
            }

            for(WebElement option: suggestions)
            {
                String word = option.getText();
                if(word.toLowerCase().contains("selenium"))
                {
                    option.click();
                    System.out.println("Suggestion clicked is : " + word);
                    break;
                }
            }

            WebElement updatedSearchField = wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']")));

                String selectedSuggestion = updatedSearchField.getAttribute("value");
                System.out.println("Selected value: " + selectedSuggestion);

            
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
