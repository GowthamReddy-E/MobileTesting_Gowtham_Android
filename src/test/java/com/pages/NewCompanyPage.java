package com.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gowtham.utils.EventUtil;
import com.gowtham.utils.GlobalVariables;

public class NewCompanyPage extends EventUtil{
	
	private WebDriver driver;
	
	private static ThreadLocal<NewCompanyPage> threadLocal = new ThreadLocal<>();
	
	public static void set(NewCompanyPage newCompanyPage) {
		threadLocal.set(newCompanyPage);
	}
	
	public static NewCompanyPage get() {
		return threadLocal.get();
	}
	
	
	@FindBy(xpath="//button[text()='Create']")
	private WebElement btnCreate;
	
	@FindBy(xpath = "//div[text()='Create new Company']")
	private WebElement lblCreateCompanyPageHeader;
	
	@FindBy(xpath="//label[text()='Name']/following-sibling::div//input[@name='name']")
	private WebElement txtCompanyName;

	@FindBy(xpath="//label[text()='Access']/following-sibling::div//button")
	private WebElement btnAccess;
	
	public NewCompanyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public boolean navigateToCreateCompanyPage() {
		clickElement(btnCreate);
		return checkElementExists(lblCreateCompanyPageHeader, GlobalVariables.DEFAULT_EXPLICIT_WAIT);
	}
	
	public void enterCompanyData(Map<String, String> data) {
		enterValue(txtCompanyName, data.get("COMPANY_NAME"));
		selectCompanyAccess(data.get("ACCESS"));
		
	}

	public String getCurrentAccessLevel() {
		waitForElementToVisible(btnAccess, GlobalVariables.DEFAULT_EXPLICIT_WAIT);
		return btnAccess.getText();
	}
	private void selectCompanyAccess(String accessToSelect) {
		waitForElementToVisible(btnAccess, GlobalVariables.DEFAULT_EXPLICIT_WAIT);
		if (!getCurrentAccessLevel().equalsIgnoreCase(accessToSelect)) {
			clickElement(btnAccess);
		}
		
		
	}

}
