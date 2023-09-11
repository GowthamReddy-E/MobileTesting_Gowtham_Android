package com.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.gowtham.utils.AllureReports;
import com.gowtham.utils.GlobalVariables;
import com.gowtham.utils.ReporterUtil;
import com.gowtham.utils.WaitUtils;
import com.pages.Configuration;
import com.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class sampleTest extends Configuration {


	@Test(priority = 1,description = "Check The MobileApp is open with valid credentials")
	@Severity(SeverityLevel.NORMAL)
	@Description("sanityTest")
	@Story("stroy-Point: testCase_01")
	public void TC_01() throws IOException {
		if (LoginPage.get().isLoginPageDisplayed()) {
			System.out.println("the login page is displayed");
			ReporterUtil.get().writeLog(Status.PASS	,"Login page is displayed","loginPage");
		} else {
			ReporterUtil.get().writeLog(Status.PASS	,"Login page is not displayed","loginPage");
			Assert.fail("Login page is not displayed on launching the application");
		}
		ReporterUtil.get().writeLog(Status.PASS	,"trying to enter username and password");
		LoginPage.get().login(GlobalVariables.envData.get("username"), GlobalVariables.envData.get("password"));
		WaitUtils.constantWait(4000);
		ReporterUtil.get().writeLog(Status.PASS	,"landing in mainPage","mainPage");
		WaitUtils.constantWait(4000);
	}

	@Test(priority = 2,description = "Check The MobileApp is open with valid credentials allure reports")
	@Severity(SeverityLevel.NORMAL)
	@Description("sanityTest")
	@Story("stroy-Point: testCase_01")
	public void TC_02() throws IOException {
		if (LoginPage.get().isLoginPageDisplayed()) {
			System.out.println("the login page is displayed");
			AllureReports.get().writeLog("loginPage is displayed", io.qameta.allure.model.Status.PASSED);
		} else {
			Assert.fail("Login page is not displayed on launching the application");
			AllureReports.get().writeLog("loginPage is displayed", io.qameta.allure.model.Status.FAILED);
		}
		AllureReports.get().writeLog("user trying to enter the username and password", "loginPage");
		LoginPage.get().login(GlobalVariables.envData.get("username"), GlobalVariables.envData.get("password"));
		WaitUtils.constantWait(4000);
	}
}
