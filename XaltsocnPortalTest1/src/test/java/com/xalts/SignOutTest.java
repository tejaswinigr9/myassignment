package com.xalts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignOutTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://xaltsocnportal.web.app"); 
    }

    @Test
    public void testSuccessfulSignOut() {
        driver.findElement(By.xpath("//button[normalize-space()='Sign Out']")).click();
        
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
}

