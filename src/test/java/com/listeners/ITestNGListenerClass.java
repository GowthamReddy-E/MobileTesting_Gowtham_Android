package com.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.gowtham.utils.ReporterUtil;

public class ITestNGListenerClass implements ITestListener {
	
	
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " is passed");
		System.out.println("on test success gowtham");
		ReporterUtil.get().getScreenShot(result.getMethod().getMethodName()+"success");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " is failed");
		System.out.println("on test failure gowtham");
		ReporterUtil.get().getScreenShot(result.getMethod().getMethodName()+"failure");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " is skipped");
		System.out.println("on test skipped gowtham");
		ReporterUtil.get().getScreenShot(result.getMethod().getMethodName()+"skipped");
	}

}
