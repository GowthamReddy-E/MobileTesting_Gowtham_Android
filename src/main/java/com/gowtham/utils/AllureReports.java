package com.gowtham.utils;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

public class AllureReports extends GenericUtil {

	private static ThreadLocal<AllureReports> threadLocal = new ThreadLocal<>();

	public static void set(AllureReports reportUtil) {
		threadLocal.set(reportUtil);
	}

	public static AllureReports get() {
		return threadLocal.get();
	}

	public void writeLog(String stepInfo,Status status) {
		Allure.addAttachment(stepInfo,status.toString());	
	}

	public void writeLog(String stepInfo,String screenShotName) {
		Allure.addAttachment(stepInfo,takeScreenShot(screenShotName));
	}

	public static ByteArrayInputStream takeScreenShot(String screenShotName ) {
		byte[] screenshot2 = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
		return new ByteArrayInputStream(screenshot2) ;
	}
}
