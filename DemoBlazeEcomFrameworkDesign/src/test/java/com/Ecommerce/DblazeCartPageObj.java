package com.Ecommerce;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class DblazeCartPageObj {
	WebDriver driver;
	RegisterDemo democart;
	WebDriverWait wait;
	ExtentReports extent;
	ExtentTest test;
	DblazeUtils dutils;
	
  @BeforeMethod
  public void setUp() {
	  extent =DblazeUtils.genReport();
	  dutils = new DblazeUtils();
	  test=extent.createTest("Signing up");
	  driver =new ChromeDriver();
	  	driver.manage().window().maximize();
	  	wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	    driver.get("https://demoblaze.com");
	      
	    }
  @Test
  public void regandchkoutflow() throws InterruptedException 
  {
	  test =extent.createTest("Signing up in demoblaze.com");
	  democart= new RegisterDemo(driver, wait, test, dutils);
	  democart.clkSignup();
	  democart.setSignup();
	  democart.searchProd();
	  democart.addCart();
	  democart.cart();
	  democart.btnOrder();
	 democart.placeOrder();
	  }
  @AfterMethod
  public void closebrowser()
  {
	  driver.quit();
	  extent.flush();
	  
  }
}
