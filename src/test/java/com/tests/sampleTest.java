package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gowtham.utils.GlobalVariables;
import com.gowtham.utils.WaitUtils;
import com.pages.Configuration;
import com.pages.LoginPage;

public class sampleTest extends Configuration {


	@Test
	public void test_0001() {
		if (LoginPage.get().isLoginPageDisplayed()) {
			System.out.println("the login page is displayed");
		} else {
			Assert.fail("Login page is not displayed on launching the application");
		}
		LoginPage.get().login(GlobalVariables.envData.get("username"), GlobalVariables.envData.get("password"));
		WaitUtils.constantWait(4000);
	}





}
