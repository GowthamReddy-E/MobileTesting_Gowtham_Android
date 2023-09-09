package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gowtham.utils.EventUtil;

import freemarker.log.Logger;
import io.qameta.allure.Step;

public class LoginPage extends EventUtil {
	
	private WebDriver driver;
	
	private static ThreadLocal<LoginPage> threadLocal = new ThreadLocal<>();
	
	public static void set(LoginPage loginPage) {
		threadLocal.set(loginPage);
	}
	
	public static LoginPage get() {
		return threadLocal.get();
	}
	
	
	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Username')]")
	private WebElement txtUserName;
	
	@FindBy(xpath ="//android.widget.EditText[@content-desc=\"test-Password\"]")
	private WebElement txtPassword;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
	private WebElement btnLogin;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
		
	
	@Step("check weather the login page is displayed or not")
	public boolean isLoginPageDisplayed() {
		return checkElementExists(txtUserName);
	}
	
	@Step("login through userName:{0} and password:{1}")
	public void login(String userName, String passWord) {
		enterValue(txtUserName,userName );
		enterValue(txtPassword, passWord);
		clickElement(btnLogin);

	}
	
}
