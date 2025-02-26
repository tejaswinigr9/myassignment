package com.xalts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
     
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://xaltsocnportal.web.app/signup");
    }

    @Test
    public void testSignUpValid() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    	WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='App']//div[1]//div[1]//input[1]")));
    	emailField.sendKeys("user@tech.com");
    	
    	WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='App']//div[1]//div[1]//input[1]")));
    	password.sendKeys("Password123!");
    	
    	WebElement confirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl css-1v4ccyo']//input[@id='outlined-basic']")));
    	confirmPassword.sendKeys("Password123!");
    	
        driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String pageTitle = driver.getTitle();
       // Assert.assertTrue(pageTitle.contains("Open Capital Network"), "Sign Up Failed");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
