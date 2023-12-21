package com.automate.sourcePages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automate.utils.TradingBaseUtilityClass;

public class LoginSourcePage extends TradingBaseUtilityClass{
	
	@FindBy(id = "form:login-focus:userId")
	WebElement userIdInput;
	
	@FindBy(id = "form:login-focus:nonFeedback")
	WebElement passwordInput;
	
	@FindBy(id = "form:login-focus:orgCode")
	WebElement orgCodeInput;
	
	@FindBy(id = "form:login-focus:login1")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[@title='Quick Setup']")
	WebElement quickSetupicon;
	
	
	public LoginSourcePage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public LoginSourcePage enterUserId(String userId) {
		userIdInput.sendKeys(userId);
		return this;
	}
	
	public LoginSourcePage enterPassword(String password) {
		passwordInput.sendKeys(password);
		return this;
	}
	
	public LoginSourcePage enterOrgCode(String orgCode) {
		orgCodeInput.sendKeys(orgCode);
		return this;
	}
	
	public LoginSourcePage clickLoginButton() {
		loginButton.click();
//		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(quickSetupicon));
		return this;
	}
}
