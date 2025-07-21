package com.Ecommerce;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;  
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DblazeUtils {
	
	public static ExtentReports genReport()
	
	{
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter reporter =new ExtentSparkReporter("reports/report.html");
		extent.attachReporter(reporter);
		return extent;
	}
	public static String captureScreenshot(WebDriver driver, String screenshotName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String dest =System.getProperty("user.dir") + "//Screenshots//" + screenshotName + System.currentTimeMillis() + ".png";

        try {
            FileUtils.copyFile(src, new File(dest));
            System.out.println("Screenshot saved: " + dest);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
        return dest;
}}
