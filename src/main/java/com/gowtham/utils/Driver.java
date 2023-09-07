package com.gowtham.utils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Driver {

	private static WebDriver driver;

	private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

	public static void set(WebDriver driver) {
		threadLocal.set(driver);
	}

	public static WebDriver get() {
		return threadLocal.get();
	}



	public static WebDriver getWebDriver() {
		return driver;
	}



	@BeforeMethod
	public  void initializeDriver() throws MalformedURLException {
		String path=System.getProperty("user.dir");
		File f = new File (path+"/src/test/resources/Apps");
		//File fs = new File (f,"ApiDemos-debug.apk");
		File fs = new File (f,"Android.SauceLabs.Mobile.Sample.app.2.2.1.apk");

		System.out.println(fs.getAbsolutePath());

		DesiredCapabilities dc=new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");

		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");

		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");


		dc.setCapability("appPackage", "com.swaglabsmobileapp");

		dc.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");

		dc.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		driver = new AndroidDriver<AndroidElement>(new URL ("http://127.0.0.1:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}



	@AfterMethod
	public void tearDown() {
		driver.quit();
	}




}
