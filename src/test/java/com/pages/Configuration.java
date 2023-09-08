package com.pages;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.gowtham.utils.DataUtil;
import com.gowtham.utils.Driver;
import com.gowtham.utils.EventUtil;
import com.gowtham.utils.GlobalVariables;
import com.gowtham.utils.ReporterUtil;


public class Configuration extends GlobalVariables{

	@Parameters("env")
	@BeforeSuite
	public void setUpExecution(@Optional String env) {
		env = (env==null)?"qa":env.toLowerCase();
		EventUtil.killProcesses();
		switch (env) {
		case "qa":
			envData = (new DataUtil()).getPropertyData(CONFIG_FOLDER_PATH+"\\EnvInfo_QA.properties");
			break;
		case "dev":
			envData = (new DataUtil()).getPropertyData(CONFIG_FOLDER_PATH+"\\EnvInfo_Dev.properties");
			break;
		default:
			envData = (new DataUtil()).getPropertyData(CONFIG_FOLDER_PATH+"\\EnvInfo_stage.properties");
			break;
		}
	}

	@BeforeTest
	public void initializeReport(ITestContext context) {
		ReporterUtil.set(new ReporterUtil());
		String suiteName = context.getCurrentXmlTest().getSuite().getName();
		String testName = context.getCurrentXmlTest().getName();
//		ReporterUtil.get().initializeReport(suiteName+"_"+ testName);
	}

	@BeforeMethod
	public void intializeTest(Method method, ITestContext context) throws MalformedURLException {
		Driver driverUtil = new Driver();
		driverUtil.initializeDriver();
		Driver.set(Driver.getWebDriver());
		GlobalVariables.set(new GlobalVariables());
		GlobalVariables.get().tcName = method.getName();
//		ReporterUtil.get().addTest(GlobalVariables.get().tcName);
	}

	@BeforeMethod()
	public void setUpPages() {
		DataUtil.set(new DataUtil());
		LoginPage.set(new LoginPage(Driver.get()));
	}

	@AfterMethod
	public void afterMethod() {
		Driver.get().quit();
	}

	@AfterTest
	public void finalizeExecution() {
//		ReporterUtil.get().finalizeReport();
	}

}
