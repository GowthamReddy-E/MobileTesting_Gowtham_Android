package com.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gowtham.utils.EventUtil;

public class CreateNewDealPage extends EventUtil{
	
	private WebDriver driver;
	
	private static ThreadLocal<CreateNewDealPage> threadLocal = new ThreadLocal<>();
	
	public static void set(CreateNewDealPage page) {
		threadLocal.set(page);
	}
	
	public static CreateNewDealPage get() {
		return threadLocal.get();
	}
	
	public CreateNewDealPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath="//div[starts-with(@class,'ui header') and text()='Create new Deal']")
	private WebElement lblCreateNewDealPageHeader;
	
	@FindBy(xpath = "//input[@name='title']")
	private WebElement txtDealTitle;
	
	@FindBy(xpath="//label[text()='Access']/following-sibling::div//button")
	private WebElement btnAccess;
	
	@FindBy(xpath = "//div[text()='Select users allowed access']/parent::div")
	private WebElement lstUsersForAccess;
	
	public boolean isCreateNewDealPageDisplayed() {
		return checkElementExists(lblCreateNewDealPageHeader);
	}
	
	
	public void enterDealData(Map<String, String> dealData) {
		
		enterValue(txtDealTitle, dealData.get("DEAL_TITLE"));
		selectAccess(dealData.get("ACCESS"));
		
		if (dealData.get("ACCESS").equalsIgnoreCase("private")) {
			selectValueFromList(lstUsersForAccess, dealData.get("USERS_FOR_ACCESS"));
		}
		
		
	}
	
	public void selectAccess(String access) {
		
		if (!btnAccess.getText().equalsIgnoreCase(access))
				clickElement(btnAccess);
		
		
	}
	
}
