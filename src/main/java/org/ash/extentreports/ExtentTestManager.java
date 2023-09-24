package org.ash.extentreports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentTestManager {

	private ExtentTestManager()
	{

	}
	private static ThreadLocal<ExtentTest> extest =new ThreadLocal<ExtentTest>();

	public static ExtentTest getExtentTest()
	{
		return extest.get();
	}

	public static void setExtentTest(ExtentTest exTestref)
	{
		extest.set(exTestref);
	}

	public static void remove()
	{
		extest.remove();
	}
}
