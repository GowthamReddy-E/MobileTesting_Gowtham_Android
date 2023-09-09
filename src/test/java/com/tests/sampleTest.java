package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gowtham.utils.GlobalVariables;
import com.gowtham.utils.WaitUtils;
import com.pages.Configuration;
import com.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class sampleTest extends Configuration {


	@Test(priority = 1,description = "this is the firstTest in the mobileTesting I'm creating")
	@Severity(SeverityLevel.NORMAL)
	@Description("SomkeTest")
	@Story("TestCase_0001")
	public void ticket_01() {
		if (LoginPage.get().isLoginPageDisplayed()) {
			System.out.println("the login page is displayed");
		} else {
			Assert.fail("Login page is not displayed on launching the application");
		}
		LoginPage.get().login(GlobalVariables.envData.get("username"), GlobalVariables.envData.get("password"));
		WaitUtils.constantWait(4000);
	}





}
