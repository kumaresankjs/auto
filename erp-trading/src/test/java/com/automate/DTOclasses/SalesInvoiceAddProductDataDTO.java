package com.automate.DTOclasses;

import java.util.List;

import org.openqa.selenium.WebElement;

public class SalesInvoiceAddProductDataDTO {
	private List<String> givenProductUserValue;
	private WebElement productDescFieldElement;
	private WebElement productDescVisibilityListPanel;
	private List<WebElement> productDescListOfElements;
	private WebElement quantityFieldElement;
	private WebElement unitPriceFieldElement;
	private WebElement productAddButton;
	private WebElement productEditIcon;
	private String propertyName;
	private List<String> orgCode;
	private List<String> productNameFromExternalData;
	private List<String> quantityFromExternalData;
	private List<String> unitPriceFromExternalData;
	
	
	public List<String> getGivenProductUserValue() {
		return givenProductUserValue;
	}
	public void setGivenProductUserValue(List<String> givenProductUserValue) {
		this.givenProductUserValue = givenProductUserValue;
	}
	public WebElement getProductDescFieldElement() {
		return productDescFieldElement;
	}
	public void setProductDescFieldElement(WebElement productDescFieldElement) {
		this.productDescFieldElement = productDescFieldElement;
	}
	public WebElement getProductDescVisibilityListPanel() {
		return productDescVisibilityListPanel;
	}
	public void setProductDescVisibilityListPanel(WebElement productDescVisibilityListPanel) {
		this.productDescVisibilityListPanel = productDescVisibilityListPanel;
	}
	public List<WebElement> getProductDescListOfElements() {
		return productDescListOfElements;
	}
	public void setProductDescListOfElements(List<WebElement> productDescListOfElements) {
		this.productDescListOfElements = productDescListOfElements;
	}
	public WebElement getQuantityFieldElement() {
		return quantityFieldElement;
	}
	public void setQuantityFieldElement(WebElement quantityFieldElement) {
		this.quantityFieldElement = quantityFieldElement;
	}
	public WebElement getUnitPriceFieldElement() {
		return unitPriceFieldElement;
	}
	public void setUnitPriceFieldElement(WebElement unitPriceFieldElement) {
		this.unitPriceFieldElement = unitPriceFieldElement;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public List<String> getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(List<String> orgCode) {
		this.orgCode = orgCode;
	}
	public List<String> getProductNameFromExternalData() {
		return productNameFromExternalData;
	}
	public void setProductNameFromExternalData(List<String> productNameFromExternalData) {
		this.productNameFromExternalData = productNameFromExternalData;
	}
	public List<String> getQuantityFromExternalData() {
		return quantityFromExternalData;
	}
	public void setQuantityFromExternalData(List<String> quantityFromExternalData) {
		this.quantityFromExternalData = quantityFromExternalData;
	}
	public List<String> getUnitPriceFromExternalData() {
		return unitPriceFromExternalData;
	}
	public void setUnitPriceFromExternalData(List<String> unitPriceFromExternalData) {
		this.unitPriceFromExternalData = unitPriceFromExternalData;
	}
	public WebElement getProductAddButton() {
		return productAddButton;
	}
	public void setProductAddButton(WebElement productAddButton) {
		this.productAddButton = productAddButton;
	}
	public WebElement getProductEditIcon() {
		return productEditIcon;
	}
	public void setProductEditIcon(WebElement productEditIcon) {
		this.productEditIcon = productEditIcon;
	}
	
	
	

}
