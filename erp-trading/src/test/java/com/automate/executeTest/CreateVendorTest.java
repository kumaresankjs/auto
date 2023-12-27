package com.automate.executeTest;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automate.sourcePages.CreateVendorSourcePage;
import com.automate.sourcePages.LoginSourcePage;
import com.automate.sourcePages.NavigationSourcePages;
import com.automate.utils.TradingBaseUtilityClass;

public class CreateVendorTest extends TradingBaseUtilityClass {
	
	@BeforeClass(alwaysRun = true)
	public void doBeforeTest() {
		testName="Vendor Create";
		testDataFileName="LoginData";
		testDataSheetName="vendor";
	}
	
	
	
	@Test(dataProvider = "dataProviderTestWithoutUniqueColumn", groups = "ete")
	public void createVendor(Map<String, String> data) {
		
		new LoginSourcePage(driver)
		.enterUserId(data.get("userId"))
		.enterPassword(data.get("password"))
		.enterOrgCode(data.get("orgCode"))
		.clickLoginButton();
		
		new NavigationSourcePages(driver)
		.navigateToSearchVendorScreen()
		.navigateToCreateVendorFromSearchScreen();
		
		new CreateVendorSourcePage(driver)
		.enterVendorName(data.get("vendorName"))
		.enterVendorGstin(data.get("gstin"))
		.selectVendorType(data.get("vendorType"), data.get("orgCode"))
		.selectVendorTerritory(data.get("territory"), data.get("orgCode"))
		.selectVendorTier(data.get("tier"), data.get("orgCode"))
		.enterVendorPhone(data.get("phone"))
		.selectVendorPaymentTerm(data.get("paymentTerm"), data.get("orgCode"))
		.enterVendorBillingStreet(data.get("billingStreet"))
		.selectVendorIsSez(data.get("isSez"))
		.clickVendorOfficialTab()
		.enterVendorBankAccountNo(data.get("bankAccountNo"))
		.enterVendorBankIfscCode(data.get("bankIfscCode"))
		.clickCreateButton();
		
		CreateVendorSourcePage createCustomer = new CreateVendorSourcePage(driver);
		
		try {
			boolean validatedStatus = createCustomer.doValidateResult();
			assertTrue(validatedStatus, "Vendor is not created");
		} catch (AssertionError er) {
			saveScreenshotOfFailedCases();
			throw er;
		}
		
	}
	

}
