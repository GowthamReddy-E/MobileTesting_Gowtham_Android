package com.testNg.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestNGListenerClass implements ITestListener {
	
	
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " is passed");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " is failed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " is skipped");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
