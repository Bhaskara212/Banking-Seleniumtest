package com.krishna.com.Seleniumbanktesting;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
    	System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver13\\chromedriver.exe");
    	//System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-usage");
        DesiredCapabilities cp = new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        WebDriver driver = new ChromeDriver(options);
        
        System.out.println("Selenium Test Scripts Execution Started..");
       
         //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         //driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
         //driver.manage().window().maximize();
         driver.get("http://localhost:8081//contact.html");
         
         driver.findElement(By.name("Name")).sendKeys("Bhaskar");
         Thread.sleep(2000);
         driver.findElement(By.name("Phone Number")).sendKeys("99121916");
         Thread.sleep(2000);
         driver.findElement(By.name("Email")).sendKeys("pitchikas.212@gmail.com");
         Thread.sleep(2000);
         driver.findElement(By.id("comment")).sendKeys("I want full info about personal Loan.");
         Thread.sleep(2000);
         driver.findElement(By.className("send_bt")).click();
         Thread.sleep(2000);
         
         String message = driver.findElement(By.id("message")).getText();
         if(message.equals("Email Sent")) {
         	System.out.println("Script executed Successfully");
         }
    
         else {
         	System.out.println("Script failed");
         }
         
         System.out.println("Taking Screenshot as proof");
         //take the screenshot of the testcase
         
 		
 		  TakesScreenshot scrShot = ((TakesScreenshot)driver);
 		  
 		  File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
 		  
 		  File destFile = new File("screenshot.png");
 		  
 		  FileUtils.copyFile(screenShot, destFile);
 		 
 		  System.out.println("reports stored at : " + destFile.getAbsolutePath().toString());
          Thread.sleep(2000);
          driver.quit();
          System.out.println("Script executed successfully");
    }
}
