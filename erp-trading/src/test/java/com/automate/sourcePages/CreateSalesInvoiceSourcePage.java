package com.automate.sourcePages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automate.DTOclasses.DriverInteractElementInvoiceDTO;
import com.automate.DTOclasses.SalesInvoiceAddProductDataDTO;
import com.automate.utils.TradingBaseUtilityClass;

public class CreateSalesInvoiceSourcePage extends TradingBaseUtilityClass {
	
	
	@FindBy(id="form:customerName_input")
	WebElement createCustomerNameInput;
	@FindBy(id="form:customerName_panel")
	WebElement customerNameInputListPanel;
	@FindBy(xpath="//span[@id='form:customerName_panel']//td[1]")
	List<WebElement> customerNameInputList;
	@FindBy(xpath = "//table[@id='form:billingAddress1']//a[1]")
	WebElement billingAddressEditButton;
	
	@FindBy(id="form:store")
	WebElement createStoreInput;
	@FindBy(id="form:store_panel")
	WebElement storeInputListPanel;
	@FindBy(xpath="//ul[@id='form:store_items']//li")
	List<WebElement> storeInputList;
	
	
	@FindBy(id="form:payment")
	WebElement createPaymentTermInput;
	@FindBy(id="form:payment_panel")
	WebElement paymentTermInputListPanel;
	@FindBy(xpath="//ul[@id='form:payment_items']//li")
	List<WebElement> paymentTermInputList;
	
	
	@FindBy(id="form:paymentMode")
	WebElement createPaymentModeInput;
	@FindBy(id="form:paymentMode_panel")
	WebElement paymentModeInputListPanel;
	@FindBy(xpath="//ul[@id='form:paymentMode_items']//li")
	List<WebElement> paymentModeInputList;
	
	@FindBy(id="form:productIdField_input")
	WebElement createProductDescInput;
	@FindBy(id="form:productIdField_panel")
	WebElement productFieldInputListPanel;
	@FindBy(xpath="//span[@id='form:productIdField_panel']//td[2]")
	List<WebElement> productInputList;
	@FindBy(id="form:productEdit")
	WebElement editProductIcon;
	
	
	@FindBy(id="form:quantityField")
	WebElement createQtyInput ;
	@FindBy(xpath="//table[@id='form:unitPriceForConversion']//input")
	WebElement createUnitPriceInput;
	@FindBy(xpath="//span[text()='Add']")
	WebElement createAddProductButton;
	@FindBy(id="form:save1")
	WebElement saveSalesInvoiceButton;
	@FindBy(id="form:update")
	WebElement invoiceUpdateButton;
	
	
	public CreateSalesInvoiceSourcePage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	String ctrlA = Keys.chord(Keys.CONTROL, "a");


	public CreateSalesInvoiceSourcePage selectCustomerName(List<String> customerName, List<String> orgCode) {
		DriverInteractElementInvoiceDTO elementDTO=new DriverInteractElementInvoiceDTO();
		elementDTO.setGivenUserValue(customerName);
		elementDTO.setFieldElement(createCustomerNameInput);
		elementDTO.setVisibilityListPanel(customerNameInputListPanel);
		elementDTO.setListOfElements(customerNameInputList);
		elementDTO.setPropertyName("retrieveCustomerList");
		elementDTO.setWaitVisibilityElement(billingAddressEditButton);
		elementDTO.setOrgCode(orgCode);
		selectValueFromInvoiceAutoComplete(elementDTO);
		
		return this;
	}

	public CreateSalesInvoiceSourcePage selectStore(List<String> store, List<String> orgCode)  {
		DriverInteractElementInvoiceDTO elementDTO=new DriverInteractElementInvoiceDTO();
		elementDTO.setGivenUserValue(store);
		elementDTO.setFieldElement(createStoreInput);
		elementDTO.setVisibilityListPanel(storeInputListPanel);
		elementDTO.setListOfElements(storeInputList);
		elementDTO.setPropertyName("retrieveStoreList");
		elementDTO.setOrgCode(orgCode);
		selectValueFromInvoiceDropDownField(elementDTO);
		return this;
	}
	
	public CreateSalesInvoiceSourcePage selectPaymentTerm(List<String> paymentTerm, List<String> orgCode) {
		DriverInteractElementInvoiceDTO elementDTO=new DriverInteractElementInvoiceDTO();
		elementDTO.setGivenUserValue(paymentTerm);
		elementDTO.setFieldElement(createPaymentTermInput);
		elementDTO.setVisibilityListPanel(paymentTermInputListPanel);
		elementDTO.setListOfElements(paymentTermInputList);
		elementDTO.setPropertyName("retrievePaymentTerm");
		elementDTO.setOrgCode(orgCode);
		selectValueFromInvoiceDropDownField(elementDTO);
		return this;
	}
	
	public CreateSalesInvoiceSourcePage selectPaymentMode(List<String> paymentMode, List<String> orgCode) {
		DriverInteractElementInvoiceDTO elementDTO=new DriverInteractElementInvoiceDTO();
		elementDTO.setGivenUserValue(paymentMode);
		elementDTO.setFieldElement(createPaymentModeInput);
		elementDTO.setVisibilityListPanel(paymentModeInputListPanel);
		elementDTO.setListOfElements(paymentModeInputList);
		elementDTO.setPropertyName("retrievePaymentMode");
		elementDTO.setOrgCode(orgCode);
		selectValueFromInvoiceDropDownField(elementDTO);
		return this;
	}
	
	public CreateSalesInvoiceSourcePage addProducts(SalesInvoiceAddProductDataDTO productDetailsDTO, List<String> orgCode) {
		SalesInvoiceAddProductDataDTO productDTO=new SalesInvoiceAddProductDataDTO();
		productDTO.setProductNameFromExternalData(productDetailsDTO.getProductNameFromExternalData());
		productDTO.setQuantityFromExternalData(productDetailsDTO.getQuantityFromExternalData());
		productDTO.setUnitPriceFromExternalData(productDetailsDTO.getUnitPriceFromExternalData());
		productDTO.setOrgCode(orgCode);
		productDTO.setPropertyName("retrieveProductList");
		productDTO.setProductDescFieldElement(createProductDescInput);
		productDTO.setProductDescVisibilityListPanel(productFieldInputListPanel);
		productDTO.setProductDescListOfElements(productInputList);
		productDTO.setQuantityFieldElement(createQtyInput);
		productDTO.setUnitPriceFieldElement(createUnitPriceInput);
		productDTO.setProductAddButton(createAddProductButton);
		productDTO.setProductEditIcon(editProductIcon);
		addProductsToInvoice(productDTO);
		return this;
	}

	
	public CreateSalesInvoiceSourcePage clickAddProduct() {
		createAddProductButton.click();
		wait.until(ExpectedConditions.invisibilityOf(editProductIcon));
		return this;
	}

	public CreateSalesInvoiceSourcePage clickSaveButton() {
		saveSalesInvoiceButton.click();
		wait.until(ExpectedConditions.visibilityOf(invoiceUpdateButton));
		return this;
	}

}
