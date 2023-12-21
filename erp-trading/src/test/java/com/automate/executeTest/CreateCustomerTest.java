package com.automate.executeTest;

import static org.testng.Assert.assertTrue;

import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.automate.sourcePages.CreateCustomerSourcePage;
import com.automate.sourcePages.LoginSourcePage;
import com.automate.sourcePages.NavigationSourcePages;
import com.automate.utils.TradingBaseUtilityClass;

public class CreateCustomerTest extends TradingBaseUtilityClass {
	
	@BeforeClass(alwaysRun = true)
	public void doBeforeTest() {
		testName="Customer Create";
		testDataFileName="LoginData";
		testDataSheetName="Sheet3";
	}
	
	
	
	@Test(dataProvider = "dataProviderTestWithoutUniqueColumn", groups = "ete")
	public void createCustomer(Map<String, String> data) {
		
		new LoginSourcePage(driver)
		.enterUserId(data.get("userId"))
		.enterPassword(data.get("password"))
		.enterOrgCode(data.get("orgCode"))
		.clickLoginButton();
		
		new NavigationSourcePages(driver)
		.navigateToSearchCustomerScreen()
		.navigateToCreateCustomerFromSearchScreen();
		
		new CreateCustomerSourcePage(driver)
		.enterCustomerName(data.get("customerName"))
		.enterCustomerGstin(data.get("gstin"))
		.selectCustomerType(data.get("customerType"), data.get("orgCode"))
		.selectCustomerTerritory(data.get("territory"), data.get("orgCode"))
		.selectCustomerTier(data.get("tier"), data.get("orgCode"))
		.enterCustomerPhone(data.get("phone"))
		.selectCustomerPaymentTerm(data.get("paymentTerm"), data.get("orgCode"))
		.enterCustomerBillingStreet(data.get("billingStreet"))
		.selectCustomerIsSez(data.get("isSez"))
		.clickCustomerOfficialTab()
		.enterCustomerBankAccountNo(data.get("bankAccountNo"))
		.enterCustomerBankIfscCode(data.get("bankIfscCode"))
		.clickCreateButton();
		
		CreateCustomerSourcePage createCustomer = new CreateCustomerSourcePage(driver);
		
		try {
			boolean validatedStatus = createCustomer.doValidateResult();
			assertTrue(validatedStatus, "Customer is not created");
		} catch (AssertionError er) {
			saveScreenshotOfFailedCases();
			throw er;
		}
		
	}
	

}
