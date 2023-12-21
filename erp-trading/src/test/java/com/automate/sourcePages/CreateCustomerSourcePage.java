package com.automate.sourcePages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automate.DTOclasses.DriverInteractElementDTO;
import com.automate.DTOclasses.TradingTestResultDTO;
import com.automate.utils.TradingBaseUtilityClass;

public class CreateCustomerSourcePage extends TradingBaseUtilityClass{
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Customer Name *']]//following::input)[1]")
	WebElement customerNameInput;
	
	@FindBy(id = "form:tabView:tinNum")
	WebElement customerGstinInput;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Customer Type']]//following::div)[1]")
	WebElement customerTypeInput;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[2]")
	WebElement customerTypeInputListPanel;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[2]//li")
	List<WebElement> customerTypeInputList;
	
	@FindBy(xpath = "(//label[text()='SEZ Unit / Developer ?']/following::div)[3]")
	WebElement customerIsSezInput;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Territory']]//following::div)[1]")
	WebElement customerTerritoryInput;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[3]")
	WebElement customerTerritoryInputListPanel;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[3]//li")
	List<WebElement> customerTerritoryInputList;
	
	@FindBy(xpath = "(//label[text()='PAN Number']/following::input)[1]")
	WebElement customerPanNumberInput;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Tier']]//following::div)[1]")
	WebElement customerTierInput;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[4]")
	WebElement customerTierInputListPanel;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[4]//li")
	List<WebElement> customerTierInputList;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Designation']]//following::div)[1]")
	WebElement customerDesignationInput;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[5]")
	WebElement customerDesignationInputListPanel;
	@FindBy(xpath = "(//div[contains(@class,'ui-selectonemenu-panel ui-widget')])[5]//li")
	List<WebElement> customerDesignationInputList;
	
	@FindBy(id = "form:tabView:title")
	WebElement customerTitleInput;
	@FindBy(id = "form:tabView:title_panel")
	WebElement customerTitleInputListPanel;
	@FindBy(xpath = "//ul[@id='form:tabView:title_items']//li")
	List<WebElement> customerTitleInputList;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Contact Name']]//following::input)[1]")
	WebElement customerContactNameInput;
	
	@FindBy(id = "form:tabView:mobNo")
	WebElement customerMobileNoInput;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Phone']]//following::input)[1]")
	WebElement customerPhoneInput;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='E-Mail']]//following::input)[1]")
	WebElement customerEmailInput;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Fax']]//following::input)[1]")
	WebElement customerFaxInput;
	
	@FindBy(id = "form:tabView:status")
	WebElement customerStatusInput;
	@FindBy(id = "form:tabView:status_panel")
	WebElement customerStatusInputListPanel;
	@FindBy(xpath = "//ul[@id='form:tabView:status_items']//li")
	List<WebElement> customerStatusInputList;
	
	@FindBy(xpath = "(//p[text()[normalize-space()='Limit Amount']]//following::input)[1]")
	WebElement customerCreditLimitAmountInput;
	
	@FindBy(id = "form:tabView:paymentterm")
	WebElement customerPaymentTermInput;
	@FindBy(id = "form:tabView:paymentterm_panel")
	WebElement customerPaymentTermInputListPanel;
	@FindBy(xpath = "//ul[@id='form:tabView:paymentterm_items']//li")
	List<WebElement> customerPaymentTermInputList;
	
	@FindBy(id = "form:tabView:tab:street1")
	WebElement customerBillingStreetInput;
	
	@FindBy(xpath = "//input[@id='form:tabView:tab:city1']")
	WebElement customerBillingCityInput;
	
	@FindBy(id = "form:tabView:tab:state1")
	WebElement customerBillingStateInput;
	@FindBy(id = "form:tabView:tab:state1_panel")
	WebElement customerBillingStateInputListPanel;
	@FindBy(xpath = "//ul[@id='form:tabView:tab:state1_items']//li")
	List<WebElement> customerBillingStateInputList;
	
	@FindBy(id = "form:tabView:tab:country1_label")
	WebElement customerBillingCountryInput;
	@FindBy(id = "form:tabView:tab:country1_panel")
	WebElement customerBillingCountryInputListPanel;
	@FindBy(xpath = "//ul[@id='form:tabView:tab:country1_items']//li")
	List<WebElement> customerBillingCountryInputList;
	
	@FindBy(id = "form:tabView:tab:zipCode1")
	WebElement customerBillingPostalCodeInput;
	
	@FindBy(id = "form:tabView:tab:street")
	WebElement customerShippingStreetInput;
	
	@FindBy(id = "form:tabView:tab:city")
	WebElement customerShippingCityInput;
	
	@FindBy(id = "form:tabView:tab:state")
	WebElement customerShippingStateInput;
	@FindBy(id = "form:tabView:tab:state_panel")
	WebElement customerShippingStateInputListPanel;
	@FindBy(xpath = "//ul[@id='form:tabView:tab:state_items']//li")
	List<WebElement> customerShippingStateInputList;
	
	@FindBy(id = "form:tabView:tab:country")
	WebElement customerShippingCountryInput;
	@FindBy(id = "form:tabView:tab:country_panel")
	WebElement customerShippingCountryInputListPanel;
	@FindBy(xpath = "//ul[@id='form:tabView:tab:country_items']//li")
	List<WebElement> customerShippingCountryInputList;
	
	@FindBy(id = "form:tabView:tab:zipCode")
	WebElement customerShippingPostalCodeInput;
	
	@FindBy(xpath = "(//div[@id='form:tabView:tab:copyAddress']//div)[2]")
	WebElement copyAddressCheckboxInput;
	
	@FindBy(id = "form:save")
	WebElement customerScreenCreateButtonInput;
	
	@FindBy(id = "form:resetDecline")
	WebElement customerScreenResetButtonInput;
	
	@FindBy(xpath = "//a[text()='Official']")
	WebElement customerOfficialTab;
	
	@FindBy(xpath = "(//td[text()='Bank Account No']//following::input)[1]")
	WebElement customerBankAccountNo;
	
	@FindBy(xpath = "(//td[text()='IFSC Code']//following::input)[1]")
	WebElement customerBankIfscCode;
	
	@FindBy(xpath = "//div[@id='form:messages']//li//span")
	WebElement createCustomerFormMessage;
	
	@FindBy(id = "form:dupNameDialog")
	WebElement duplicateGstinConfirmationDialog;
	
	@FindBy(id = "form:confirmYes2")
	WebElement duplicateGstinConfirmationYesButton;
	
	@FindBy(id = "form:confirmNo2")
	WebElement duplicateGstinConfirmationNoButton;
	
	public CreateCustomerSourcePage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public CreateCustomerSourcePage enterCustomerName(String customerName) {
		sendKeysToInputFields(customerNameInput, customerName);
		return this;
	}
	
	public CreateCustomerSourcePage enterCustomerGstin(String customerGstin) {
		sendKeysToInputFields(customerGstinInput, customerGstin);
		return this;
	}
	public CreateCustomerSourcePage enterCustomerPAN(String customerPAN) {
		sendKeysToInputFields(customerPanNumberInput, customerPAN);
		return this;
	}
	public CreateCustomerSourcePage enterCustomerContactName(String customerContactName) {
		sendKeysToInputFields(customerContactNameInput, customerContactName);
		return this;
	}
	public CreateCustomerSourcePage enterCustomerMobileNo(String customerMobileNo) {
		sendKeysToInputFields(customerMobileNoInput, customerMobileNo);
		return this;
	}
	public CreateCustomerSourcePage enterCustomerPhone(String customerPhone) {
		sendKeysToInputFields(customerPhoneInput, customerPhone);
		return this;
	}
	public CreateCustomerSourcePage enterCustomerEmail(String customerEmail) {
		sendKeysToInputFields(customerEmailInput, customerEmail);
		return this;
	}
	public CreateCustomerSourcePage enterCustomerFax(String customerFax) {
		sendKeysToInputFields(customerFaxInput, customerFax);
		return this;
	}
	
	public CreateCustomerSourcePage scrollDownToAddressBar() {
		scrollDownPage();
		return this;
	}
	
	public CreateCustomerSourcePage enterCustomerBillingStreet(String customerBillingStreet) {
		sendKeysToInputFields(customerBillingStreetInput, customerBillingStreet);
		return this;
	}
	public CreateCustomerSourcePage enterCustomerBillingCity(String customerBillingCity) {
		sendKeysToInputFields(customerBillingCityInput, customerBillingCity);
		return this;
	}
	public CreateCustomerSourcePage enterCustomerBillingPostalCode(String customerBillingPostalCode) {
		sendKeysToInputFields(customerBillingPostalCodeInput, customerBillingPostalCode);
		return this;
	}
	public CreateCustomerSourcePage enterCustomerShippingStreet(String customerShippingStreet) {
		sendKeysToInputFields(customerShippingStreetInput, customerShippingStreet);
		return this;
	}
	public CreateCustomerSourcePage enterCustomerShippingCity(String customerShippingCity) {
		sendKeysToInputFields(customerShippingCityInput, customerShippingCity);
		return this;
	}
	public CreateCustomerSourcePage enterCustomerShippingPostalCode(String customerShippingPostalCode) {
		sendKeysToInputFields(customerShippingPostalCodeInput, customerShippingPostalCode);
		return this;
	}
	
	public CreateCustomerSourcePage selectCustomerType(String customerType, String orgCode) {
		DriverInteractElementDTO elementDTO=new DriverInteractElementDTO();
		elementDTO.setGivenUserValue(customerType);
		elementDTO.setFieldElement(customerTypeInput);
		elementDTO.setVisibilityListPanel(customerTypeInputListPanel);
		elementDTO.setListOfElements(customerTypeInputList);
		elementDTO.setPropertyName("retrieveCustomerType");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	
	public CreateCustomerSourcePage selectCustomerTerritory(String customerTerritory, String orgCode) {
		DriverInteractElementDTO elementDTO=new DriverInteractElementDTO();
		elementDTO.setGivenUserValue(customerTerritory);
		elementDTO.setFieldElement(customerTerritoryInput);
		elementDTO.setVisibilityListPanel(customerTerritoryInputListPanel);
		elementDTO.setListOfElements(customerTerritoryInputList);
		elementDTO.setPropertyName("retrieveTerritory");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	
	public CreateCustomerSourcePage selectCustomerTier(String customerTier, String orgCode) {
		DriverInteractElementDTO elementDTO=new DriverInteractElementDTO();
		elementDTO.setGivenUserValue(customerTier);
		elementDTO.setFieldElement(customerTierInput);
		elementDTO.setVisibilityListPanel(customerTierInputListPanel);
		elementDTO.setListOfElements(customerTierInputList);
		elementDTO.setPropertyName("retrieveTier");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	
	public CreateCustomerSourcePage selectCustomerDesignation(String customerDesignation, String orgCode) {
		DriverInteractElementDTO elementDTO=new DriverInteractElementDTO();
		elementDTO.setGivenUserValue(customerDesignation);
		elementDTO.setFieldElement(customerDesignationInput);
		elementDTO.setVisibilityListPanel(customerDesignationInputListPanel);
		elementDTO.setListOfElements(customerDesignationInputList);
		elementDTO.setPropertyName("retrieveDesignation");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	public CreateCustomerSourcePage selectCustomerTitle(String customerTitle, String orgCode) {
		DriverInteractElementDTO elementDTO=new DriverInteractElementDTO();
		elementDTO.setGivenUserValue(customerTitle);
		elementDTO.setFieldElement(customerTitleInput);
		elementDTO.setVisibilityListPanel(customerTitleInputListPanel);
		elementDTO.setListOfElements(customerTitleInputList);
		elementDTO.setPropertyName("retrieveTitle");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	
	public CreateCustomerSourcePage selectCustomerStatus(String customerStatus, String orgCode) {
		DriverInteractElementDTO elementDTO=new DriverInteractElementDTO();
		elementDTO.setGivenUserValue(customerStatus);
		elementDTO.setFieldElement(customerStatusInput);
		elementDTO.setVisibilityListPanel(customerStatusInputListPanel);
		elementDTO.setListOfElements(customerStatusInputList);
		elementDTO.setPropertyName("retrieveStatus");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	
	public CreateCustomerSourcePage selectCustomerPaymentTerm(String customerPaymentTerm, String orgCode) {
		DriverInteractElementDTO elementDTO=new DriverInteractElementDTO();
		elementDTO.setGivenUserValue(customerPaymentTerm);
		elementDTO.setFieldElement(customerPaymentTermInput);
		elementDTO.setVisibilityListPanel(customerPaymentTermInputListPanel);
		elementDTO.setListOfElements(customerPaymentTermInputList);
		elementDTO.setPropertyName("retrievePaymentTerm");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	public CreateCustomerSourcePage selectCustomerBillingState(String customerBillingState, String orgCode) {
		DriverInteractElementDTO elementDTO=new DriverInteractElementDTO();
		elementDTO.setGivenUserValue(customerBillingState);
		elementDTO.setFieldElement(customerBillingStateInput);
		elementDTO.setVisibilityListPanel(customerBillingStateInputListPanel);
		elementDTO.setListOfElements(customerBillingStateInputList);
		elementDTO.setPropertyName("retrieveState");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	
	public CreateCustomerSourcePage selectCustomerBillingCountry(String customerBillingCountry, String orgCode) {
		DriverInteractElementDTO elementDTO=new DriverInteractElementDTO();
		elementDTO.setGivenUserValue(customerBillingCountry);
		elementDTO.setFieldElement(customerBillingCountryInput);
		elementDTO.setVisibilityListPanel(customerBillingCountryInputListPanel);
		elementDTO.setListOfElements(customerBillingCountryInputList);
		elementDTO.setPropertyName("retrieveCountry");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	public CreateCustomerSourcePage selectCustomerShippingState(String customerShippingState, String orgCode) {
		DriverInteractElementDTO elementDTO=new DriverInteractElementDTO();
		elementDTO.setGivenUserValue(customerShippingState);
		elementDTO.setFieldElement(customerShippingStateInput);
		elementDTO.setVisibilityListPanel(customerShippingStateInputListPanel);
		elementDTO.setListOfElements(customerShippingStateInputList);
		elementDTO.setPropertyName("retrieveState");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	public CreateCustomerSourcePage selectCustomerShippingCountry(String customerShippingCountry, String orgCode) {
		DriverInteractElementDTO elementDTO=new DriverInteractElementDTO();
		elementDTO.setGivenUserValue(customerShippingCountry);
		elementDTO.setFieldElement(customerShippingCountryInput);
		elementDTO.setVisibilityListPanel(customerShippingCountryInputListPanel);
		elementDTO.setListOfElements(customerShippingCountryInputList);
		elementDTO.setPropertyName("retrieveCountry");
		elementDTO.setOrgCode(orgCode);
		selectValueFromList(elementDTO);
		return this;
	}
	
	public CreateCustomerSourcePage selectCustomerIsSez(String customerIsSez) {
		selectCheckBox(customerIsSez, customerIsSezInput);
		return this;
	}
	
	public CreateCustomerSourcePage selectCustomerCopyBillingAddress(String customerCopyBillingAddress) {
		selectCheckBox(customerCopyBillingAddress, copyAddressCheckboxInput);
		return this;
	}
	
	public CreateCustomerSourcePage clickCustomerOfficialTab() {
		customerOfficialTab.click();
		wait.until(ExpectedConditions.visibilityOf(customerBankAccountNo));
		return this;
	}
	
	public CreateCustomerSourcePage enterCustomerBankAccountNo(String bankAccountNo) {
		sendKeysToInputFields(customerBankAccountNo, bankAccountNo);
		return this;
	}
	
	public CreateCustomerSourcePage enterCustomerBankIfscCode(String bankIfscCode) {
		sendKeysToInputFields(customerBankIfscCode, bankIfscCode);
		return this;
	}
	
	
	public CreateCustomerSourcePage clickCreateButton() {
		customerScreenCreateButtonInput.click();
		partiesDuplicateGstinActionWhileCreate(duplicateGstinConfirmationDialog, duplicateGstinConfirmationYesButton);
		wait.until(ExpectedConditions.visibilityOf(createCustomerFormMessage));
		return this;
	}
	
	public boolean doValidateResult() {
		boolean isCustomerCreate=false;
		String actualMessage = createCustomerFormMessage.getText();
		TradingTestResultDTO resultsDTO=new TradingTestResultDTO();
		if(actualMessage.contains("created successfully")) {
			isCustomerCreate=true;
			resultsDTO.setTestScenario("Create customer with test data retreived from excel file");
			resultsDTO.setTestStatus("Pass");
			resultsDTO.setTestComments(actualMessage);
			doInsertResultsIntoDB(resultsDTO);
		} else {
			String replacedMsg = saveByReplacingErrorMessage(actualMessage, "parties");
			resultsDTO.setTestScenario("Create customer with test data retreived from excel file");
			resultsDTO.setTestStatus("Fail");
			resultsDTO.setTestComments(replacedMsg);
			doInsertResultsIntoDB(resultsDTO);
		}
		return isCustomerCreate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
