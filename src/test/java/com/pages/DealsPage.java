package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gowtham.utils.EventUtil;

public class DealsPage extends EventUtil{
	
	private WebDriver driver;
	
	private static ThreadLocal<DealsPage> threadLocal = new ThreadLocal<>();
	
	public static void set(DealsPage page) {
		threadLocal.set(page);
	}
	
	public static DealsPage get() {
		return threadLocal.get();
	}
	
	public DealsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//span[text()='Deals']/ancestor::a")
	private WebElement lnkDealsMenuLink;
	
	@FindBy(xpath="//div[starts-with(@class,'ui header') and text()='Deals']")
	private WebElement lblDealsPageHeader;
	
	@FindBy(xpath = "//button[text()='Create']")
	private WebElement btnCreate;
	
	public boolean navigateToDealsPage() {
		
		clickElement(lnkDealsMenuLink);
		
		return checkElementExists(lblDealsPageHeader);
		
	}
	
	
	public void clickCreateDeal() {
		clickElement(btnCreate);
	}

}
