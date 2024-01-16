package com.automate.DTOclasses;

import java.util.List;

import org.openqa.selenium.WebElement;

public class DriverInteractElementCommonDTO {
	private String givenUserValue;
	private WebElement fieldElement;
	private WebElement visibilityListPanel;
	private List<WebElement> listOfElements;
	private String propertyName;
	private String orgCode;
	private WebElement waitVisibilityElement;
	
	
	public String getGivenUserValue() {
		return givenUserValue;
	}
	public void setGivenUserValue(String givenUserValue) {
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
	
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	
	public WebElement getWaitVisibilityElement() {
		return waitVisibilityElement;
	}
	public void setWaitVisibilityElement(WebElement waitVisibilityElement) {
		this.waitVisibilityElement = waitVisibilityElement;
	}
	

}
