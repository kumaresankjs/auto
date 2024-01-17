package com.automate.executeTest;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automate.DTOclasses.SalesInvoiceAddProductDataDTO;
import com.automate.sourcePages.CreateSalesInvoiceSourcePage;
import com.automate.sourcePages.LoginSourcePage;
import com.automate.sourcePages.NavigationSourcePages;
import com.automate.utils.TradingBaseUtilityClass;

public class CreateSalesInvoiceTest extends TradingBaseUtilityClass {

	@BeforeClass(alwaysRun = true)
	public void getExcelDatas() {
		testDataFileName = "LoginData";
		testDataSheetName = "salesInvoice";
		testName = "Create Sales invoice";
	}

	@Test(groups = "ete", dataProvider = "dataProviderTestWithUniqueColumn")
	public void createSalesInvoice(List<Map<String,String>> data) {
		Map<String, List<String>> mergedUniqueIdData = invoiceMergeData(data);
		SalesInvoiceAddProductDataDTO productDetailsDTO = getProductDetailsFromMergedData(mergedUniqueIdData);
		
		
		new LoginSourcePage(driver)
		.enterUserIdForInvoiceCreate(mergedUniqueIdData.get("userId"))
		.enterPasswordForInvoiceCreate(mergedUniqueIdData.get("password"))
		.enterOrgCodeForInvoiceCreate(mergedUniqueIdData.get("orgCode"))
		.clickLoginButton();
		
		new NavigationSourcePages(driver)
		.navigateToSearchSalesInvoiceScreen()
		.navigateToCreateSalesInvoiceFromSearchScreen();

		
		new CreateSalesInvoiceSourcePage(driver)
				.selectCustomerName(mergedUniqueIdData.get("customerName"), mergedUniqueIdData.get("orgCode"))
				.selectStore(mergedUniqueIdData.get("store"), mergedUniqueIdData.get("orgCode"))
				.selectPaymentMode(mergedUniqueIdData.get("paymentMode"), mergedUniqueIdData.get("orgCode")) 
				.addProducts(productDetailsDTO, mergedUniqueIdData.get("orgCode"))
				.clickSaveButton();
		 
	}

}
