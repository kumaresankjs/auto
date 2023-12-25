package com.automate.sourcePages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automate.utils.TradingBaseUtilityClass;

public class NavigationSourcePages extends TradingBaseUtilityClass{
	
	@FindBy(xpath = "//span[text()='Parties']")
	WebElement partiesMenu;
	
	@FindBy(xpath = "//span[text()='Customer']")
	WebElement searchCustomerScreen;
	
	@FindBy(id = "form:new")
	WebElement createCustomerIcon;
	
	@FindBy(xpath = "//span[text()='Vendor']")
	WebElement searchVendorScreen;
	
	@FindBy(id = "form:new")
	WebElement createVendorIcon;
	
	
	
	public NavigationSourcePages(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	
	public NavigationSourcePages navigateToSearchCustomerScreen() {
		mouseHoverMenus(partiesMenu, searchCustomerScreen, createCustomerIcon);
		return this;
	}
	
	public NavigationSourcePages navigateToCreateCustomerFromSearchScreen() {
		Actions action=new Actions(driver);
		action.sendKeys(Keys.F1).perform();
//		createCustomerIcon.click();
		return this;
	}
	
	public NavigationSourcePages navigateToSearchVendorScreen() {
		mouseHoverMenus(partiesMenu, searchVendorScreen, createVendorIcon);
		return this;
	}
	
	public NavigationSourcePages navigateToCreateVendorFromSearchScreen() {
		Actions action=new Actions(driver);
		action.sendKeys(Keys.F1).perform();
//		createVendorIcon.click();
		return this;
	}
	
	

}
