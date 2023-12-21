package com.automate.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListeners implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
        String testName = result.getName();
        
        takeScreenshot(driver, testName);
	}

	private void takeScreenshot(WebDriver driver, String testName) {
		try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("./testResults/screenshots/" + testName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	

}
