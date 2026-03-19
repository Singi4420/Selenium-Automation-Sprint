package com.genos.sdet;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/test/login.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("singi@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Singi@123");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();

       String toastMessage = driver.findElement(By.xpath("//h3[text()='Successfully Logged in...']")).getText();

       System.out.println(toastMessage);

       driver.quit();

    }
}
