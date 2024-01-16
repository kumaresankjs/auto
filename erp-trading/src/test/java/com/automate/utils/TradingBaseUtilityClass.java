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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

import com.automate.DTOclasses.DriverInteractElementCommonDTO;
import com.automate.DTOclasses.DriverInteractElementInvoiceDTO;
import com.automate.DTOclasses.SalesInvoiceAddProductDataDTO;
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
	
	String ctrlA = Keys.chord(Keys.CONTROL, "a");
	
	@BeforeMethod(alwaysRun = true)
	public void startBrowser() {
		propertyFile("testingBase");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(property.getProperty("demoUrl"));
	}
	
	@AfterMethod(alwaysRun = true)
	public void quitBrowser() {
		driver.quit();
	}
	
	
	public void selectValueFromList(DriverInteractElementCommonDTO elementDTO) {
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
	
	public void selectValueFromInvoiceDropDownField(DriverInteractElementInvoiceDTO elementDTO) {
		List<String> givenUserValue = elementDTO.getGivenUserValue();
		List<String> givenUserOrgCode = elementDTO.getOrgCode();
		String userValue = givenUserValue.get(0);
		String orgCode = givenUserOrgCode.get(0);
		
		propertyFile("jdbc");
		String query = property.getProperty(elementDTO.getPropertyName());
		ArrayList<String> listOfDbValues = RetrieveRecords.executeSQLQueryList(query);
		int size = listOfDbValues.size();
		if (size > 0) {
			for (String values : listOfDbValues) {
				if (values.equalsIgnoreCase(userValue + " " + orgCode)) {
					elementDTO.getFieldElement().click();
					wait.until(ExpectedConditions.visibilityOf(elementDTO.getVisibilityListPanel()));
					for (WebElement option : elementDTO.getListOfElements()) {
						String text = option.getText();
						if (text.equalsIgnoreCase(userValue)) {
							option.click();
							try {
								Thread.sleep(1000);
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
	
	public void selectValueFromInvoiceAutoComplete(DriverInteractElementInvoiceDTO elementDTO) {
		List<String> givenUserValue = elementDTO.getGivenUserValue();
		List<String> givenUserOrgCode = elementDTO.getOrgCode();
		String userValue = givenUserValue.get(0);
		String orgCode = givenUserOrgCode.get(0);
		
		propertyFile("jdbc");
		String query = property.getProperty(elementDTO.getPropertyName());
		ArrayList<String> listOfDbValues = RetrieveRecords.executeSQLQueryList(query);
		int size = listOfDbValues.size();
		if (size > 0) {
			for (String values : listOfDbValues) {
				if (values.equalsIgnoreCase(userValue + " " + orgCode)) {
					elementDTO.getFieldElement().sendKeys(userValue);
					wait.until(ExpectedConditions.visibilityOf(elementDTO.getVisibilityListPanel()));
					for (WebElement option : elementDTO.getListOfElements()) {
						String text = option.getText();
						String[] splitWords = text.split(" - ");
						if (splitWords.length > 0) {
							if (splitWords[0].equalsIgnoreCase(userValue)) {
								option.click();
								wait.until(ExpectedConditions.visibilityOf(elementDTO.getWaitVisibilityElement()));
								break;
							}
						}
					}
				}
			}
		}
	}
	
	public void addProductsToInvoice(SalesInvoiceAddProductDataDTO productDTO) {
		List<String> productName = productDTO.getProductNameFromExternalData();
		List<String> quantity = productDTO.getQuantityFromExternalData();
		List<String> unitPrice = productDTO.getUnitPriceFromExternalData();
		List<String> givenUserOrgCode = productDTO.getOrgCode();
		String orgCode = givenUserOrgCode.get(0);

		propertyFile("jdbc");
		String query = property.getProperty(productDTO.getPropertyName());
		ArrayList<String> listOfDbValues = RetrieveRecords.executeSQLQueryList(query);

		int productListSize = productName.size();
		
		for (int i = 0; i < productListSize; i++) {
			String productFromDTO = productName.get(i);
			for (String values : listOfDbValues) {
				if (values.equalsIgnoreCase(productFromDTO + " " + orgCode)) {
					productDTO.getProductDescFieldElement().sendKeys(productFromDTO);
					wait.until(ExpectedConditions.visibilityOf(productDTO.getProductDescVisibilityListPanel()));
					for (WebElement option : productDTO.getProductDescListOfElements()) {
						String optionText = option.getText();
						if (optionText.equalsIgnoreCase(productFromDTO)) {
							option.click();
							break;
						}
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					productDTO.getQuantityFieldElement().click();
					productDTO.getQuantityFieldElement().sendKeys(ctrlA);
					productDTO.getQuantityFieldElement().sendKeys(Keys.DELETE);
					productDTO.getQuantityFieldElement().sendKeys(quantity.get(i));
					productDTO.getQuantityFieldElement().sendKeys(Keys.TAB);

					productDTO.getUnitPriceFieldElement().click();
					productDTO.getUnitPriceFieldElement().sendKeys(ctrlA);
					productDTO.getUnitPriceFieldElement().sendKeys(Keys.DELETE);
					productDTO.getUnitPriceFieldElement().sendKeys(unitPrice.get(i));
					productDTO.getUnitPriceFieldElement().sendKeys(Keys.TAB);

					productDTO.getProductAddButton().click();
					wait.until(ExpectedConditions.invisibilityOf(productDTO.getProductEditIcon()));
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
	
	public static Map<String, List<String>> invoiceMergeData(List<Map<String, String>> dataList) {
        Map<String, List<String>> mergedData = new HashMap<>();

        for (Map<String, String> dataEntry : dataList) {
            for (Map.Entry<String, String> entry : dataEntry.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                List<String> values = mergedData.getOrDefault(key, new ArrayList<>());
                values.add(value);
                mergedData.put(key, values);
            }
        }

        return mergedData;
    }
	
	public static SalesInvoiceAddProductDataDTO getProductDetailsFromMergedData(Map<String, List<String>> mergedData) {
		SalesInvoiceAddProductDataDTO excelDTO=new SalesInvoiceAddProductDataDTO();
		for(Map.Entry<String, List<String>> datas:mergedData.entrySet()) {
			String key = datas.getKey();
			List<String> value = datas.getValue();
			if (value != null) {
				if ("productName".equalsIgnoreCase(key)) {
					excelDTO.setProductNameFromExternalData(value);
				} else if ("quantity".equalsIgnoreCase(key)) {
					excelDTO.setQuantityFromExternalData(value);
				} else if ("unitPrice".equalsIgnoreCase(key)) {
					excelDTO.setUnitPriceFromExternalData(value);
				}
			}
		}
		
		return excelDTO;
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
	
	@DataProvider
	public Object[][] dataProviderTestWithUniqueColumn() {
		try {
			Map<String, List<Map<String, String>>> groupedData = ExtractTestData
					.getExcelDatasWithUniqueColumn(testDataFileName, testDataSheetName);
			List<Object> listOfObjects = new ArrayList<>();
			Object[][] testDataArray = null;
			for (Entry<String, List<Map<String, String>>> newData : groupedData.entrySet()) {
				List<Map<String, String>> value = newData.getValue();
				listOfObjects.add(value);
			}
			int testDataListSize = listOfObjects.size();
			testDataArray = new Object[testDataListSize][1];

			for (int i = 0; i < testDataListSize; i++) {
				testDataArray[i][0] = listOfObjects.get(i);
			}
			return testDataArray;
		} catch (Exception e) {
			e.printStackTrace();
			return new Object[0][0];
		}
	}

}
