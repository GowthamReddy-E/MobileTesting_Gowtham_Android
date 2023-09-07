package com.pages;

import org.apache.log4j.BasicConfigurator;  
import org.apache.log4j.LogManager;  
import org.apache.log4j.Logger;  

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.gowtham.utils.EventUtil;


public class HomePage extends EventUtil {


	private WebDriver driver;

	private static ThreadLocal<HomePage> threadLocal = new ThreadLocal<>();

	public static void set(HomePage homePage) {
		threadLocal.set(homePage);
	}

	public static HomePage get() {
		return threadLocal.get();
	}

	@FindBy(xpath = "//div/i[@class='settings icon']")
	private WebElement btnSettingsIcon;

	@FindBy
	private WebElement lblHomeIcon;




	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}


	public boolean isHomePageDisplayed() {
		return checkElementExists(btnSettingsIcon);
	}

	
}
