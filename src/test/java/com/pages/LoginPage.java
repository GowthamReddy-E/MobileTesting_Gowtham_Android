package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gowtham.utils.EventUtil;

import freemarker.log.Logger;

public class LoginPage extends EventUtil {
	private WebDriver driver;
	
	private static ThreadLocal<LoginPage> threadLocal = new ThreadLocal<>();
	
	public static void set(LoginPage loginPage) {
		threadLocal.set(loginPage);
	}
	
	public static LoginPage get() {
		return threadLocal.get();
	}
	
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement txtUserName;
	
	@FindBy(name ="password")
	private WebElement txtPassword;
	
	@FindBy(xpath="//div[text()='Login']")
	private WebElement btnLogin;
	
	

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public boolean isLoginPageDisplayed() {
		return checkElementExists(txtUserName);
	}
	
	public void login(String userName, String passWord) {
		enterValue(txtUserName,userName );
		enterValue(txtPassword, passWord);
		clickElement(btnLogin);

	}
	

	
}
