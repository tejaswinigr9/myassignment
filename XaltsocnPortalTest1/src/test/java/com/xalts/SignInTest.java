package com.xalts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignInTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://xaltsocnportal.web.app/login");
        
        driver.manage().window().maximize();
      
        driver.findElement(By.xpath("//button[normalize-space()='Get Started']")).click();
        
   	    driver.findElement(By.xpath("//button[normalize-space()='Already have an account? Click here to sign in.']")).click();
    }

    @Test
    public void testSuccessfulSignIn() {
   	 
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
    	WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='App']//div[1]//div[1]//input[1]")));
    	emailField.sendKeys("user@tech.com");
    	
    	WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='App']//div[1]//div[1]//input[1]")));
    	password.sendKeys("Password123!");
    	
        driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();

       
    }

    @Test
    public void testInvalidEmail() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    	WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='App']//div[1]//div[1]//input[1]")));
    	emailField.sendKeys("user@example.com");
    	
    	WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='App']//div[1]//div[1]//input[1]")));
    	password.sendKeys("Password123!");
    	
        driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();


    }

    @Test
    public void testIncorrectPassword() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    	WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='App']//div[1]//div[1]//input[1]")));
    	emailField.sendKeys("user@tech.com");
    	
    	WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='App']//div[1]//div[1]//input[1]")));
    	password.sendKeys("Password123");
    	
        driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();


    }

    @Test
    public void testBlankFields() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    	WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='App']//div[1]//div[1]//input[1]")));
    	emailField.sendKeys(" ");
    	
    	WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='App']//div[1]//div[1]//input[1]")));
    	password.sendKeys(" ");
    	
    	  driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();
    	  

    }
}

