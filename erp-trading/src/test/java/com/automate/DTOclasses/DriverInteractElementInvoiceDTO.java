package com.automate.DTOclasses;

import java.util.List;

import org.openqa.selenium.WebElement;

public class DriverInteractElementInvoiceDTO {
	private List<String> givenUserValue;
	private WebElement fieldElement;
	private WebElement visibilityListPanel;
	private List<WebElement> listOfElements;
	private String propertyName;
	private List<String> orgCode;
	private WebElement waitVisibilityElement;
	private List<String> productNameFromExternalData;
	private List<String> quantityFromExternalData;
	private List<String> unitPriceFromExternalData;
	
	
	public List<String> getGivenUserValue() {
		return givenUserValue;
	}
	public void setGivenUserValue(List<String> givenUserValue) {
		this.givenUserValue = givenUserValue;
	}
	public WebElement getFieldElement() {
		return fieldElement;
	}
	public void setFieldElement(WebElement fieldElement) {
		this.fieldElement = fieldElement;
	}
	
	public WebElement getVisibilityListPanel() {
		return visibilityListPanel;
	}
	public void setVisibilityListPanel(WebElement visibilityListPanel) {
		this.visibilityListPanel = visibilityListPanel;
	}
	
	public List<WebElement> getListOfElements() {
		return listOfElements;
	}
	public void setListOfElements(List<WebElement> listOfElements) {
		this.listOfElements = listOfElements;
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
	
	public WebElement getWaitVisibilityElement() {
		return waitVisibilityElement;
	}
	public void setWaitVisibilityElement(WebElement waitVisibilityElement) {
		this.waitVisibilityElement = waitVisibilityElement;
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
	

}
