package org.ash.listeners;

import java.util.Arrays;

import org.ash.extentreports.ExtentLogger;
import org.ash.extentreports.ExtentReportSetup;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestAndSuiteListener implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReportSetup.initExtentReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReportSetup.quitExtentReport();;

	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportSetup.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass("Test "+result.getMethod().getMethodName()+" passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail("Test "+result.getMethod().getMethodName()+" failed");
		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		try {
			ExtentLogger.fail("failedScreenshot",true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip("Test "+result.getMethod().getMethodName()+" skipped");

	}

}
