package com.UtilsLayer;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.BaseLaye.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerSetUp extends BaseClass implements ITestListener {

	ExtentReports extentReports;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		extentReports = ExtentSetup.setUp(context.getSuite().getName());

	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test is passed " + result.getMethod().getMethodName());
		try {
			extentTest.addScreenCaptureFromPath(
					ExtentSetup.takeScreenshot("PassScreenshots", result.getMethod().getMethodName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "Test is failed " + result.getMethod().getMethodName());
		try {
			extentTest.addScreenCaptureFromPath(
					ExtentSetup.takeScreenshot("FailScreenshots", result.getMethod().getMethodName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, "Test is skipped " + result.getMethod().getMethodName());

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

}
