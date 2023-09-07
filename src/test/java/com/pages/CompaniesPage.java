package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gowtham.utils.EventUtil;

public class CompaniesPage extends EventUtil{
	
	private WebDriver driver;
	
	private static ThreadLocal<CompaniesPage> threadLocal = new ThreadLocal<>();
	
	public static void set(CompaniesPage companiesPage) {
		threadLocal.set(companiesPage);
	}
	
	public static CompaniesPage get() {
		return threadLocal.get();
	}
	
	
	public WebDriver getWebDriver() {
		return driver;
	}
	
	@FindBy(xpath="//span[text()='Companies']")
	private WebElement lnkCompanies;
	
	@FindBy(xpath = "//div[text()='Companies']")
	private WebElement lblCompaniesHeader;

	public CompaniesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public boolean navigateToCompaniesPage() {
		clickElement(lnkCompanies);
		return checkElementExists(lblCompaniesHeader);
		
	}
}
