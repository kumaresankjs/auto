package com.automate.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.automate.DTOclasses.DriverInteractElementDTO;
import com.automate.DTOclasses.TradingTestResultDTO;
import com.automate.messageReplacer.MessageReplacer;
import com.automate.testDataComponents.ExtractTestData;

import net.bytebuddy.utility.RandomString;


public class TradingBaseUtilityClass {
	
	protected RemoteWebDriver driver;
	protected WebDriverWait wait;
	public static FileInputStream input = null;
	protected static Properties property = new Properties();
	protected static String jdbcDriver = null;
	protected static String dbUrl = null;
	protected static String dbUser = null;
	protected static String dbPassword = null;
	Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
	protected SimpleDateFormat formatter;
	protected static String testName="";
	protected static String testDataFileName="";
	protected static String testDataSheetName="";
	
	@BeforeMethod(alwaysRun = true)
	public void startBrowser() {
		propertyFile("testingBase");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(property.getProperty("demoUrl"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form:login-focus:userId")));
	}
	
	@AfterMethod(alwaysRun = true)
	public void quitBrowser() {
		driver.quit();
	}
	
	
	public void selectValueFromList(DriverInteractElementDTO elementDTO) {
		propertyFile("jdbc");
		String query = property.getProperty(elementDTO.getPropertyName());
		ArrayList<String> listOfDbValues = RetrieveRecords.executeSQLQueryList(query);
		int size = listOfDbValues.size();
		if (size > 0) {
			for (String values : listOfDbValues) {
				if (values.equalsIgnoreCase(elementDTO.getGivenUserValue() + " " + elementDTO.getOrgCode())) {
					elementDTO.getFieldElement().click();
					wait.until(ExpectedConditions.visibilityOf(elementDTO.getVisibilityListPanel()));
					for (WebElement option : elementDTO.getListOfElements()) {
						String text = option.getText();
						if (text.equalsIgnoreCase(elementDTO.getGivenUserValue())) {
							option.click();
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							break;
						}
					}
				} 
			}
		}
	}
	
	public void selectCheckBox(String givenUserValue, WebElement checkBoxElement) {
		if(givenUserValue.equalsIgnoreCase("yes")) {
			checkBoxElement.click();
		}
	}
	
	public void sendKeysToInputFields(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public void mouseHoverMenus(WebElement menu, WebElement screen, WebElement waitElement) {
		Actions action=new Actions(driver);
		action.moveToElement(menu).moveToElement(screen);
		action.click().perform();
		wait.until(ExpectedConditions.visibilityOf(waitElement));
	}
	
	public void scrollDownPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void propertyFile(String propertyType) {
		try {
			if (propertyType.equalsIgnoreCase("jdbc")) {
				input = new FileInputStream("./src/test/resources/propertyFiles/jdbc.properties");
				property.load(input);
			}  else if (propertyType.equalsIgnoreCase("testingBase")) {
				input = new FileInputStream("./src/test/resources/propertyFiles/testingBase.properties");
				property.load(input);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void partiesDuplicateGstinActionWhileCreate(WebElement dialogElement, WebElement yesbutton) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean isDialogDisplayed = dialogElement.isDisplayed();
		if(isDialogDisplayed) {
			yesbutton.click();
		}
	}
	
	public void saveScreenshotOfFailedCases() {
		formatter= new SimpleDateFormat("dd-MM-yyyy");
		String folderDate = formatter.format(new Date());
		File screenShotFolder= new File("./testResults/screenshots/"+folderDate);
		
		if(!screenShotFolder.exists()) {
			screenShotFolder.mkdir();
		}
		
		formatter= new SimpleDateFormat("ddMMyyy_HHmmss");
		String timestamp = formatter.format(new Date());
		File srcFailedScreenShot = driver.getScreenshotAs(OutputType.FILE);
		File destFailedScreenShot = new File(screenShotFolder + "/" + testName + "_" + timestamp + ".png");
		try {
			FileUtils.copyFile(srcFailedScreenShot, destFailedScreenShot);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void doInsertResultsIntoDB(TradingTestResultDTO resultDto) {
		propertyFile("jdbc");
		jdbcDriver = property.getProperty("driver");
		dbUrl = property.getProperty("database");
		dbUser = property.getProperty("dbUser");
		dbPassword = property.getProperty("dbPassword");
		try {
		Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		String result = property.getProperty("insertResult");
		PreparedStatement insertResult = con.prepareStatement(result);
		insertResult.setString(1, testName);
		insertResult.setString(2, resultDto.getTestScenario());
		insertResult.setString(3, resultDto.getTestStatus());
		insertResult.setString(4, resultDto.getTestComments());
		insertResult.setTimestamp(5, currentTimestamp);
		int rowsInserted = insertResult.executeUpdate();
		if (rowsInserted == 0) {
			System.out.println("No results inserted");
			System.out.println();
		}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String saveByReplacingErrorMessage(String msg, String screen) {
		String replacedMsg = "";
		if (msg != null) {
			ErrorMessageReplacer msgReplacer = new MessageReplacer();

			if (screen.equalsIgnoreCase("parties")) {
				replacedMsg = msgReplacer.partiesScreenErrorMessageReplacer(msg);
			}

		}
		return replacedMsg;
	}
	
	public String randomStringGenerator() {
		String randomString = RandomString.make(10);
		return randomString;
	}
	
	public int randomNumberGenerator() {
		int nums=(int) (Math.floor(Math.random()*(900000-300000+1))+300000);
		return nums;
	}
	
	public String dateGenerator(String type) {
		String customDate = "";
		
		if (type.equalsIgnoreCase("time")) {
			formatter = new SimpleDateFormat("ddMMyyy_HHmmss");
			customDate = formatter.format(new Date());
		} else if (type.equalsIgnoreCase("date")) {
			formatter = new SimpleDateFormat("dd-MM-yyyy");
			customDate = formatter.format(new Date());
		}
		
		return customDate;
	}
	
	
	@DataProvider
	public Object[][] dataProviderTestWithoutUniqueColumn() {
		List<Map<String, String>> excelData = ExtractTestData.getExcelDatasWithoutUniqueColumn(testDataFileName,testDataSheetName);
		int listSize = excelData.size();
		
		Object[][] data=new Object[listSize][1];
		
		for(int i=0;i<listSize;i++) {
			data[i][0]=excelData.get(i);
		}
		
		return data;
		
	}

}
