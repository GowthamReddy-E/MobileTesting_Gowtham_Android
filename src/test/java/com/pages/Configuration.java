package com.pages;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.gowtham.utils.DataUtil;
import com.gowtham.utils.Driver;
import com.gowtham.utils.EventUtil;
import com.gowtham.utils.GlobalVariables;

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

	@BeforeMethod
	public void intializeTest() throws MalformedURLException {
		Driver driverUtil = new Driver();
		driverUtil.initializeDriver();
		Driver.set(Driver.getWebDriver());
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


}
