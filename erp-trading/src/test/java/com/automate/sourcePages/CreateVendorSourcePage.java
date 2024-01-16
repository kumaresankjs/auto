package com.automate.sourcePages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automate.DTOclasses.DriverInteractElementCommonDTO;
import com.automate.DTOclasses.TradingTestResultDTO;
import com.automate.utils.TradingBaseUtilityClass;

public class CreateVendorSourcePage extends TradingBaseUtilityClass{
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Vendor Name *']]//following::input)[1]")
	WebElement vendorNameInput;
	
	@FindBy(id = "form:tabView:tinNum")
	WebElement vendorGstinInput;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Vendor Type']]//following::div)[1]")
	WebElement vendorTypeInput;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[2]")
	WebElement vendorTypeInputListPanel;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[2]//li")
	List<WebElement> vendorTypeInputList;
	
	@FindBy(xpath = "(//label[text()='SEZ Unit / Developer ?']/following::div)[3]")
	WebElement vendorIsSezInput;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Territory']]//following::div)[1]")
	WebElement vendorTerritoryInput;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[3]")
	WebElement vendorTerritoryInputListPanel;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[3]//li")
	List<WebElement> vendorTerritoryInputList;
	
	@FindBy(xpath = "(//label[text()='PAN Number']/following::input)[1]")
	WebElement vendorPanNumberInput;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Tier']]//following::div)[1]")
	WebElement vendorTierInput;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[4]")
	WebElement vendorTierInputListPanel;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[4]//li")
	List<WebElement> vendorTierInputList;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Designation']]//following::div)[1]")
	WebElement vendorDesignationInput;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[5]")
	WebElement vendorDesignationInputListPanel;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[5]//li")
	List<WebElement> vendorDesignationInputList;
	
	@FindBy(id = "form:tabView:title")
	WebElement vendorTitleInput;
	@FindBy(id = "form:tabView:title_panel")
	WebElement vendorTitleInputListPanel;
	@FindBy(xpath = "//ul[@id='form:tabView:title_items']//li")
	List<WebElement> vendorTitleInputList;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Contact Name']]//following::input)[1]")
	WebElement vendorContactNameInput;
	
	@FindBy(id = "form:tabView:mobNo")
	WebElement vendorMobileNoInput;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Phone']]//following::input)[1]")
	WebElement vendorPhoneInput;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='E-Mail']]//following::input)[1]")
	WebElement vendorEmailInput;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Fax']]//following::input)[1]")
	WebElement vendorFaxInput;
	
	@FindBy(id = "form:tabView:status")
	WebElement vendorStatusInput;
	@FindBy(id = "form:tabView:status_panel")
	WebElement vendorStatusInputListPanel;
	@FindBy(xpath = "//ul[@id='form:tabView:status_items']//li")
	List<WebElement> vendorStatusInputList;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Limit Amount']]//following::input)[1]")
	WebElement vendorCreditLimitAmountInput;
	
	@FindBy(id = "form:tabView:paymentterm")
	WebElement vendorPaymentTermInput;
	@FindBy(id = "form:tabView:paymentterm_panel")
	WebElement vendorPaymentTermInputListPanel;
	@FindBy(xpath = "//ul[@id='form:tabView:paymentterm_items']//li")
	List<WebElement> vendorPaymentTermInputList;
	
	@FindBy(id = "form:tabView:tab:street1")
	WebElement vendorBillingStreetInput;
	
	@FindBy(xpath = "//input[@id='form:tabView:tab:city1']")
	WebElement vendorBillingCityInput;
	
	@FindBy(id = "form:tabView:tab:state1")
	WebElement vendorBillingStateInput;
	@FindBy(id = "form:tabView:tab:state1_panel")
	WebElement vendorBillingStateInputListPanel;
	@FindBy(xpath = "//ul[@id='form:tabView:tab:state1_items']//li")
	List<WebElement> vendorBillingStateInputList;
	
	@FindBy(id = "form:tabView:tab:country1_label")
	WebElement vendorBillingCountryInput;
	@FindBy(id = "form:tabView:tab:country1_panel")
	WebElement vendorBillingCountryInputListPanel;
	@FindBy(xpath = "//ul[@id='form:tabView:tab:country1_items']//li")
	List<WebElement> vendorBillingCountryInputList;
	
	@FindBy(id = "form:tabView:tab:zipCode1")
	WebElement vendorBillingPostalCodeInput;
	
	@FindBy(id = "form:tabView:tab:street")
	WebElement vendorShippingStreetInput;
	
	@FindBy(id = "form:tabView:tab:city")
	WebElement vendorShippingCityInput;
	
	@FindBy(id = "form:tabView:tab:state")
	WebElement vendorShippingStateInput;
	@FindBy(id = "form:tabView:tab:state_panel")
	WebElement vendorShippingStateInputListPanel;
	@FindBy(xpath = "//ul[@id='form:tabView:tab:state_items']//li")
	List<WebElement> vendorShippingStateInputList;
	
	@FindBy(id = "form:tabView:tab:country")
	WebElement vendorShippingCountryInput;
	@FindBy(id = "form:tabView:tab:country_panel")
	WebElement vendorShippingCountryInputListPanel;
	@FindBy(xpath = "//ul[@id='form:tabView:tab:country_items']//li")
	List<WebElement> vendorShippingCountryInputList;
	
	@FindBy(id = "form:tabView:tab:zipCode")
	WebElement vendorShippingPostalCodeInput;
	
	@FindBy(xpath = "(//div[@id='form:tabView:tab:copyAddress']//div)[2]")
	WebElement copyAddressCheckboxInput;
	
	@FindBy(id = "form:save")
	WebElement vendorScreenCreateButtonInput;
	
	@FindBy(id = "form:resetDecline")
	WebElement vendorScreenResetButtonInput;
	
	@FindBy(xpath = "//a[text()='Official']")
	WebElement vendorOfficialTab;
	
	@FindBy(xpath = "(//td[text()='Bank Account No']//following::input)[1]")
	WebElement vendorBankAccountNo;
	
	@FindBy(xpath = "(//td[text()='IFSC Code']//following::input)[1]")
	WebElement vendorBankIfscCode;
	
	@FindBy(xpath = "//div[@id='form:messages']//li//span")
	WebElement createVendorFormMessage;
	
	@FindBy(id = "form:dupNameDialog")
	WebElement duplicateGstinConfirmationDialog;
	
	@FindBy(css = "a[id='form:confirmYes2']")
	WebElement duplicateGstinConfirmationYesButton;
	
	@FindBy(id = "form:confirmNo2")
	WebElement duplicateGstinConfirmationNoButton;
	
	public CreateVendorSourcePage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public CreateVendorSourcePage enterVendorName(String vendorName) {
		sendKeysToInputFields(vendorNameInput, vendorName);
		return this;
	}
	
	public CreateVendorSourcePage enterVendorGstin(String vendorGstin) {
		sendKeysToInputFields(vendorGstinInput, vendorGstin);
		return this;
	}
	public CreateVendorSourcePage enterVendorPAN(String vendorPAN) {
		sendKeysToInputFields(vendorPanNumberInput, vendorPAN);
		return this;
	}
	public CreateVendorSourcePage enterVendorContactName(String vendorContactName) {
		sendKeysToInputFields(vendorContactNameInput, vendorContactName);
		return this;
	}
	public CreateVendorSourcePage enterVendorMobileNo(String vendorMobileNo) {
		sendKeysToInputFields(vendorMobileNoInput, vendorMobileNo);
		return this;
	}
	public CreateVendorSourcePage enterVendorPhone(String vendorPhone) {
		sendKeysToInputFields(vendorPhoneInput, vendorPhone);
		return this;
	}
	public CreateVendorSourcePage enterVendorEmail(String vendorEmail) {
		sendKeysToInputFields(vendorEmailInput, vendorEmail);
		return this;
	}
	public CreateVendorSourcePage enterVendorFax(String vendorFax) {
		sendKeysToInputFields(vendorFaxInput, vendorFax);
		return this;
	}
	
	public CreateVendorSourcePage scrollDownToAddressBar() {
		scrollDownPage();
		return this;
	}
	
	public CreateVendorSourcePage enterVendorBillingStreet(String vendorBillingStreet) {
		sendKeysToInputFields(vendorBillingStreetInput, vendorBillingStreet);
		return this;
	}
	public CreateVendorSourcePage enterVendorBillingCity(String vendorBillingCity) {
		sendKeysToInputFields(vendorBillingCityInput, vendorBillingCity);
		return this;
	}
	public CreateVendorSourcePage enterVendorBillingPostalCode(String vendorBillingPostalCode) {
		sendKeysToInputFields(vendorBillingPostalCodeInput, vendorBillingPostalCode);
		return this;
	}
	public CreateVendorSourcePage enterVendorShippingStreet(String vendorShippingStreet) {
		sendKeysToInputFields(vendorShippingStreetInput, vendorShippingStreet);
		return this;
	}
	public CreateVendorSourcePage enterVendorShippingCity(String vendorShippingCity) {
		sendKeysToInputFields(vendorShippingCityInput, vendorShippingCity);
		return this;
	}
	public CreateVendorSourcePage enterVendorShippingPostalCode(String vendorShippingPostalCode) {
		sendKeysToInputFields(vendorShippingPostalCodeInput, vendorShippingPostalCode);
		return this;
	}
	
	public CreateVendorSourcePage selectVendorType(String vendorType, String orgCode) {
		DriverInteractElementCommonDTO elementDTO=new DriverInteractElementCommonDTO();
		elementDTO.setGivenUserValue(vendorType);
		elementDTO.setFieldElement(vendorTypeInput);
		elementDTO.setVisibilityListPanel(vendorTypeInputListPanel);
		elementDTO.setListOfElements(vendorTypeInputList);
		elementDTO.setPropertyName("retrieveVendorType");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	
	public CreateVendorSourcePage selectVendorTerritory(String vendorTerritory, String orgCode) {
		DriverInteractElementCommonDTO elementDTO=new DriverInteractElementCommonDTO();
		elementDTO.setGivenUserValue(vendorTerritory);
		elementDTO.setFieldElement(vendorTerritoryInput);
		elementDTO.setVisibilityListPanel(vendorTerritoryInputListPanel);
		elementDTO.setListOfElements(vendorTerritoryInputList);
		elementDTO.setPropertyName("retrieveTerritory");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	
	public CreateVendorSourcePage selectVendorTier(String vendorTier, String orgCode) {
		DriverInteractElementCommonDTO elementDTO=new DriverInteractElementCommonDTO();
		elementDTO.setGivenUserValue(vendorTier);
		elementDTO.setFieldElement(vendorTierInput);
		elementDTO.setVisibilityListPanel(vendorTierInputListPanel);
		elementDTO.setListOfElements(vendorTierInputList);
		elementDTO.setPropertyName("retrieveTier");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	
	public CreateVendorSourcePage selectVendorDesignation(String vendorDesignation, String orgCode) {
		DriverInteractElementCommonDTO elementDTO=new DriverInteractElementCommonDTO();
		elementDTO.setGivenUserValue(vendorDesignation);
		elementDTO.setFieldElement(vendorDesignationInput);
		elementDTO.setVisibilityListPanel(vendorDesignationInputListPanel);
		elementDTO.setListOfElements(vendorDesignationInputList);
		elementDTO.setPropertyName("retrieveDesignation");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	public CreateVendorSourcePage selectVendorTitle(String vendorTitle, String orgCode) {
		DriverInteractElementCommonDTO elementDTO=new DriverInteractElementCommonDTO();
		elementDTO.setGivenUserValue(vendorTitle);
		elementDTO.setFieldElement(vendorTitleInput);
		elementDTO.setVisibilityListPanel(vendorTitleInputListPanel);
		elementDTO.setListOfElements(vendorTitleInputList);
		elementDTO.setPropertyName("retrieveTitle");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	
	public CreateVendorSourcePage selectVendorStatus(String vendorStatus, String orgCode) {
		DriverInteractElementCommonDTO elementDTO=new DriverInteractElementCommonDTO();
		elementDTO.setGivenUserValue(vendorStatus);
		elementDTO.setFieldElement(vendorStatusInput);
		elementDTO.setVisibilityListPanel(vendorStatusInputListPanel);
		elementDTO.setListOfElements(vendorStatusInputList);
		elementDTO.setPropertyName("retrieveStatus");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	
	public CreateVendorSourcePage selectVendorPaymentTerm(String vendorPaymentTerm, String orgCode) {
		DriverInteractElementCommonDTO elementDTO=new DriverInteractElementCommonDTO();
		elementDTO.setGivenUserValue(vendorPaymentTerm);
		elementDTO.setFieldElement(vendorPaymentTermInput);
		elementDTO.setVisibilityListPanel(vendorPaymentTermInputListPanel);
		elementDTO.setListOfElements(vendorPaymentTermInputList);
		elementDTO.setPropertyName("retrievePaymentTerm");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	public CreateVendorSourcePage selectVendorBillingState(String vendorBillingState, String orgCode) {
		DriverInteractElementCommonDTO elementDTO=new DriverInteractElementCommonDTO();
		elementDTO.setGivenUserValue(vendorBillingState);
		elementDTO.setFieldElement(vendorBillingStateInput);
		elementDTO.setVisibilityListPanel(vendorBillingStateInputListPanel);
		elementDTO.setListOfElements(vendorBillingStateInputList);
		elementDTO.setPropertyName("retrieveState");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	
	public CreateVendorSourcePage selectVendorBillingCountry(String vendorBillingCountry, String orgCode) {
		DriverInteractElementCommonDTO elementDTO=new DriverInteractElementCommonDTO();
		elementDTO.setGivenUserValue(vendorBillingCountry);
		elementDTO.setFieldElement(vendorBillingCountryInput);
		elementDTO.setVisibilityListPanel(vendorBillingCountryInputListPanel);
		elementDTO.setListOfElements(vendorBillingCountryInputList);
		elementDTO.setPropertyName("retrieveCountry");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	public CreateVendorSourcePage selectVendorShippingState(String vendorShippingState, String orgCode) {
		DriverInteractElementCommonDTO elementDTO=new DriverInteractElementCommonDTO();
		elementDTO.setGivenUserValue(vendorShippingState);
		elementDTO.setFieldElement(vendorShippingStateInput);
		elementDTO.setVisibilityListPanel(vendorShippingStateInputListPanel);
		elementDTO.setListOfElements(vendorShippingStateInputList);
		elementDTO.setPropertyName("retrieveState");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	public CreateVendorSourcePage selectVendorShippingCountry(String vendorShippingCountry, String orgCode) {
		DriverInteractElementCommonDTO elementDTO=new DriverInteractElementCommonDTO();
		elementDTO.setGivenUserValue(vendorShippingCountry);
		elementDTO.setFieldElement(vendorShippingCountryInput);
		elementDTO.setVisibilityListPanel(vendorShippingCountryInputListPanel);
		elementDTO.setListOfElements(vendorShippingCountryInputList);
		elementDTO.setPropertyName("retrieveCountry");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	
	public CreateVendorSourcePage selectVendorIsSez(String vendorIsSez) {
		selectCheckBox(vendorIsSez, vendorIsSezInput);
		return this;
	}
	
	public CreateVendorSourcePage selectVendorCopyBillingAddress(String vendorCopyBillingAddress) {
		selectCheckBox(vendorCopyBillingAddress, copyAddressCheckboxInput);
		return this;
	}
	
	public CreateVendorSourcePage clickVendorOfficialTab() {
		vendorOfficialTab.click();
		wait.until(ExpectedConditions.visibilityOf(vendorBankAccountNo));
		return this;
	}
	
	public CreateVendorSourcePage enterVendorBankAccountNo(String bankAccountNo) {
		sendKeysToInputFields(vendorBankAccountNo, bankAccountNo);
		return this;
	}
	
	public CreateVendorSourcePage enterVendorBankIfscCode(String bankIfscCode) {
		sendKeysToInputFields(vendorBankIfscCode, bankIfscCode);
		return this;
	}
	
	
	public CreateVendorSourcePage clickCreateButton() {
		vendorScreenCreateButtonInput.click();
		partiesDuplicateGstinActionWhileCreate(duplicateGstinConfirmationDialog, duplicateGstinConfirmationYesButton);
		wait.until(ExpectedConditions.visibilityOf(createVendorFormMessage));
		return this;
	}
	
	public boolean doValidateResult() {
		boolean isVendorCreate=false;
		String actualMessage = createVendorFormMessage.getText();
		TradingTestResultDTO resultsDTO=new TradingTestResultDTO();
		if(actualMessage.contains("created successfully")) {
			isVendorCreate=true;
			resultsDTO.setTestScenario("Create vendor with test data retreived from excel file");
			resultsDTO.setTestStatus("Pass");
			resultsDTO.setTestComments(actualMessage);
			doInsertResultsIntoDB(resultsDTO);
		} else {
			String replacedMsg = saveByReplacingErrorMessage(actualMessage, "parties");
			resultsDTO.setTestScenario("Create vendor with test data retreived from excel file");
			resultsDTO.setTestStatus("Fail");
			resultsDTO.setTestComments(replacedMsg);
			doInsertResultsIntoDB(resultsDTO);
		}
		return isVendorCreate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
