package com.automate.sourcePages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automate.utils.TradingBaseUtilityClass;

public class CreateSalesInvoicePage extends TradingBaseUtilityClass {
	
	
	@FindBy(id="form:customerName_input")
	WebElement createCustomerNameInput;
	@FindBy(id="form:store")
	WebElement createStoreInput;
	@FindBy(id="form:payment")
	WebElement createPaymentTermInput;
	@FindBy(id="form:paymentMode")
	WebElement createPaymentModeInput;
	@FindBy(id="form:productIdField_input")
	WebElement createProductDescInput;
	@FindBy(id="form:quantityField")
	WebElement createQtyInput ;
	@FindBy(xpath="//table[@id='form:unitPriceForConversion']//input")
	WebElement createUnitPriceInput;
	@FindBy(xpath="//span[text()='Add']")
	WebElement createAddProductButton;
	@FindBy(id="form:save1")
	WebElement saveSalesInvoiceButton;
	@FindBy(id="form:customerName_panel")
	WebElement customerNamePanel;
	@FindBy(xpath="//span[@id='form:customerName_panel']//td[1]")
	List<WebElement> customerNameList;
	@FindBy(id="form:store_panel")
	WebElement storePanel;
	@FindBy(xpath="//ul[@id='form:store_items']//li")
	List<WebElement> storeList;
	@FindBy(id="form:payment_panel")
	WebElement paymentTermPanel;
	@FindBy(xpath="//ul[@id='form:payment_items']//li")
	List<WebElement> paymentTermList;
	@FindBy(id="form:paymentMode_panel")
	WebElement paymentModePanel;
	@FindBy(xpath="//ul[@id='form:paymentMode_items']//li")
	List<WebElement> paymentModeList;
	@FindBy(id="form:productIdField_panel")
	WebElement productFieldPanel;
	@FindBy(xpath="//span[@id='form:productIdField_panel']//td[2]")
	List<WebElement> productList;
	@FindBy(id="form:productEdit")
	WebElement editProductIcon;
	@FindBy(id="form:update")
	WebElement invoiceUpdateButton;
	
	
	public CreateSalesInvoicePage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	String ctrlA = Keys.chord(Keys.CONTROL, "a");


	public CreateSalesInvoicePage enterCustomerName(List<String> data) {
		wait.until(ExpectedConditions.visibilityOf(createCustomerNameInput));
		createCustomerNameInput.sendKeys(data.get(0));
		wait.until(ExpectedConditions.visibilityOf(customerNamePanel));
//		int size = selectCustFromList.size();
		for (WebElement option : customerNameList) {
			String optionText = option.getText();
			String[] splitWords = optionText.split(" - ");
			if (splitWords.length > 0) {
				if (splitWords[0].equalsIgnoreCase(data.get(0))) {
					option.click();
					break;
				}
			}
		}
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='form:billingAddress1']//a[1]")));
		return this;
	}

	public CreateSalesInvoicePage enterStore(List<String> store)  {
		createStoreInput.click();
		wait.until(ExpectedConditions.visibilityOf(storePanel));
		for (WebElement option : storeList) {
			String optionText = option.getText();
			if (optionText.equalsIgnoreCase(store.get(0))) {
				option.click();
				break;
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public CreateSalesInvoicePage enterPaymentTerm(String paymentTerm) {
		createPaymentTermInput.click();
		wait.until(ExpectedConditions.visibilityOf(paymentTermPanel));
		for (WebElement option : paymentTermList) {
			String optionText = option.getText();
			if (optionText.equalsIgnoreCase(paymentTerm)) {
				option.click();
				break;
			}
		}
		return this;
	}
	
	public CreateSalesInvoicePage enterPaymentMode(List<String> paymentMode) {
		createPaymentModeInput.click();
		wait.until(ExpectedConditions.visibilityOf(paymentModePanel));
		for (WebElement option : paymentModeList) {
			String optionText = option.getText();
			if (optionText.equalsIgnoreCase(paymentMode.get(0))) {
				option.click();
				break;
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public CreateSalesInvoicePage enterProduct(String product)  {
		createProductDescInput.sendKeys(product);
		wait.until(ExpectedConditions.visibilityOf(productFieldPanel));
		for (WebElement option : productList) {
			String optionText = option.getText();
			if (optionText.equalsIgnoreCase(product)) {
				option.click();
				break;
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public CreateSalesInvoicePage enterProductQuantity(String productQty) {
		createQtyInput.click();
		createQtyInput.sendKeys(ctrlA);
		createQtyInput.sendKeys(Keys.DELETE);
		createQtyInput.sendKeys(productQty);
		createQtyInput.sendKeys(Keys.TAB);
		return this;
	}

	public CreateSalesInvoicePage enterProductUnitPrice(String productUnitPrice) {
		createUnitPriceInput.click();
		createUnitPriceInput.sendKeys(ctrlA);
		createUnitPriceInput.sendKeys(Keys.DELETE);
		createUnitPriceInput.sendKeys(productUnitPrice);
		createUnitPriceInput.sendKeys(Keys.TAB);
		return this;
	}
	
	/*
	 * public CreateSalesInvoicePage addProducts(SalesInvoiceExcelDataDTO excelDTO)
	 * { List<String> productName = excelDTO.getProductName(); List<String> quantity
	 * = excelDTO.getQuantity(); List<String> unitPrice = excelDTO.getUnitPrice();
	 * 
	 * int size = productName.size(); for (int i = 0; i < size; i++) {
	 * createProductDescInput.sendKeys(productName.get(i));
	 * wait.until(ExpectedConditions.visibilityOf(productFieldPanel)); for
	 * (WebElement option : productList) { String optionText = option.getText(); if
	 * (optionText.equalsIgnoreCase(productName.get(i))) { option.click(); break; }
	 * } try { Thread.sleep(1000); } catch (InterruptedException e) {
	 * e.printStackTrace(); } createQtyInput.click();
	 * createQtyInput.sendKeys(ctrlA); createQtyInput.sendKeys(Keys.DELETE);
	 * createQtyInput.sendKeys(quantity.get(i)); createQtyInput.sendKeys(Keys.TAB);
	 * createUnitPriceInput.click(); createUnitPriceInput.sendKeys(ctrlA);
	 * createUnitPriceInput.sendKeys(Keys.DELETE);
	 * createUnitPriceInput.sendKeys(unitPrice.get(i));
	 * createUnitPriceInput.sendKeys(Keys.TAB);
	 * 
	 * clickAddProduct(); } return this; }
	 */
	
	
	public CreateSalesInvoicePage clickAddProduct() {
		createAddProductButton.click();
		wait.until(ExpectedConditions.invisibilityOf(editProductIcon));
		return this;
	}

	public CreateSalesInvoicePage clickSaveButton() {
		saveSalesInvoiceButton.click();
		wait.until(ExpectedConditions.visibilityOf(invoiceUpdateButton));
		return this;
	}

}
