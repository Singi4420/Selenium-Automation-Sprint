package com.genos.sdet;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginAndPrintDetails {

    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");

        System.out.println("Entering UserName");
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Singaravelan");
        System.out.println("Entering email");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("singi@gmail.com");
        System.out.println("Entering currentAddress");
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Q-6, Senthuran Gardens, Tiruppur-641605");
        System.out.println("Entering permanentAddress");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("683, Dharapuram Road, Oddanchatram -624619");
        driver.findElement(By.xpath("//button[@id='submit']")).click();


        

        String name = driver.findElement(By.xpath("//p[@id='name']")).getText();
        System.out.println(name);
        String email = driver.findElement(By.xpath("//p[@id='email']")).getText();
        System.out.println(email);
        String currentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        System.out.println(currentAddress);
        String permanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();
        System.out.println(permanentAddress);

         driver.quit();

        



    }
    
}
