package com.tests;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.gowtham.utils.Driver;
import com.gowtham.utils.GlobalVariables;
import com.gowtham.utils.WaitUtils;
import com.pages.Configuration;
import com.pages.LoginPage;
import com.gowtham.utils.ReporterUtil;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class sampleTest extends Configuration {


	@Test(priority = 1,description = "this is the firstTest in the mobileTesting I'm creating")
	@Severity(SeverityLevel.NORMAL)
	@Description("sanityTest")
	@Story("testCase_01")
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
		byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
		attachScreenshot(screenshot);
		WaitUtils.constantWait(4000);
	}


	@Attachment(value = "Screenshot", type = "image/png")
	public byte[] attachScreenshot(byte[] screenshot) {
		return screenshot;
	}

}
