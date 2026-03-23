package com.genos.sdet;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
    public static void main(String[] args) {

    WebDriver driver = null;

    try
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle + " page opened sucessfully");

       List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links on the page: " + links.size());

        for(WebElement link : links)
        {
            String url = link.getAttribute("href");
            if(url == null || url.isEmpty())
            {
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            try
            {   
                URL urls = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) urls.openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                int responseCode = connection.getResponseCode();
                if(responseCode >= 400)
                {
                    System.out.println(url + " is a broken link");
                }
                else
                {
                    System.out.println(url + " is a valid link");
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception while checking URL: " + url + " - " + e.getMessage());
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
            System.out.println("Browser closed successfully");
        }
    }
    

}

}
