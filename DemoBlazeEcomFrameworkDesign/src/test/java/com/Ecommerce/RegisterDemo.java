package com.Ecommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class RegisterDemo 
{
WebDriver driver;	
WebDriverWait wait;
DblazeUtils dutils;
ExtentReports extent;
ExtentTest test;
//constructor
public RegisterDemo(WebDriver driver,WebDriverWait wait, ExtentTest test,DblazeUtils dutils)
{
	this.driver=driver;
	this.wait=wait;
	this.test=test;
	this.dutils=dutils;
	PageFactory.initElements(driver, this);
}

//Locator
@FindBy(id="signin2")WebElement clkSignup;
@FindBy(id="sign-username")WebElement txtUsername;
@FindBy(id="sign-password")WebElement txtPassword;
@FindBy(xpath="//button[@onclick='register()']")WebElement btnSignup;
@FindBy(partialLinkText="Laptops")WebElement clkLink;
@FindBy(partialLinkText="2017 Dell 15.6 Inch")WebElement clkProd;
@FindBy(xpath="//a[contains(@class,'btn-lg')]")WebElement clkAddcart;
@FindBy(partialLinkText="Cart")WebElement clkCart;
@FindBy(xpath="//button[contains(@class,'btn-success')]") WebElement clkorderbtn;
@FindBy(id="name")WebElement txtName;
@FindBy(id="country")WebElement txtCountry;
@FindBy(id="city")WebElement txtCity;
@FindBy(id="card")WebElement txtCard;
@FindBy(id= "month")WebElement txtMonth;
@FindBy(id="year")WebElement txtYear;
@FindBy(xpath="//button[@onclick='purchaseOrder()']")WebElement clkPurchasebtn;

//Action items

public void clkSignup()
{
	clkSignup.click();
	wait.until(ExpectedConditions.visibilityOf(txtUsername));
}

public void setSignup() throws InterruptedException
{
	txtUsername.sendKeys("Icecream"+System.currentTimeMillis());
	txtPassword.sendKeys("Icecream123");
	wait.until(ExpectedConditions.elementToBeClickable(btnSignup)).click();
	String signupScreenshot = dutils.captureScreenshot(driver, "Signup");
	  test.pass("Successful Sign up").addScreenCaptureFromPath(signupScreenshot);
	wait.until(ExpectedConditions.alertIsPresent());
	 driver.switchTo().alert().accept();
	}
public void searchProd()
{
	wait.until(ExpectedConditions.elementToBeClickable(clkLink)).click();
	wait.until(ExpectedConditions.elementToBeClickable(clkProd)).click();
	
}
public void addCart()
{
	wait.until(ExpectedConditions.elementToBeClickable(clkAddcart)).click();
	String addtocartScreenshot= dutils.captureScreenshot(driver, "cart");
	 test.pass("Items added to the cart").addScreenCaptureFromPath(addtocartScreenshot);
	wait.until(ExpectedConditions.alertIsPresent());
	driver.switchTo().alert().accept();
}
public void cart()
{
	wait.until(ExpectedConditions.visibilityOf(clkCart)).click();
		
}
public void btnOrder()
{
	clkorderbtn.click();
}

public void placeOrder() throws InterruptedException
{
	wait.until(ExpectedConditions.visibilityOf(txtName));
	txtName.sendKeys("Meena");
	txtCountry.sendKeys("India");
	txtCity.sendKeys("Chennai");
	txtCard.sendKeys("98340284545");
	txtMonth.sendKeys("March");
	txtYear.sendKeys("2029");
	clkPurchasebtn.click();
	 String chkoutScreenshot= dutils.captureScreenshot(driver, "placeorder");
	  test.pass("Signup to Checkout Test Successful").addScreenCaptureFromPath(chkoutScreenshot);
}
}
