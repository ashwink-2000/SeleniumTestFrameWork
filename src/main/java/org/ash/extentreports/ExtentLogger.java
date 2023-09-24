package org.ash.extentreports;

import org.ash.enums.ConfigurationEnum;
import org.ash.utils.ConfigurationUtility;
import org.ash.utils.ScreenShotUtility;

import com.aventstack.extentreports.MediaEntityBuilder;

public final class ExtentLogger {

	private ExtentLogger()
	{}

	public static void pass(String message)
	{
		ExtentTestManager.getExtentTest().pass(message);
	}
	public static void fail(String message)
	{
		ExtentTestManager.getExtentTest().fail(message);
	}
	public static void skip(String message)
	{
		ExtentTestManager.getExtentTest().skip(message);
	}
	public static void info(String message)
	{
		ExtentTestManager.getExtentTest().info(message);
	}
	public static void pass(String message,boolean isScreenshotNeeded) throws Exception
	{
		if(ConfigurationUtility.getValue(ConfigurationEnum.PASSEDSCREENSHOT).equals("yes") && isScreenshotNeeded)
			ExtentTestManager.getExtentTest().pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtility.getScreenshot()).build());
		else
			pass(message);
	}
	public static void fail(String message,boolean isScreenshotNeeded) throws Exception
	{
		if(ConfigurationUtility.getValue(ConfigurationEnum.FAILEDSCREENSHOT).equals("yes") && isScreenshotNeeded)
			ExtentTestManager.getExtentTest().fail(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtility.getScreenshot()).build());
		else
			pass(message);
	}
	public static void skip(String message,boolean isScreenshotNeeded) throws Exception
	{
		if(ConfigurationUtility.getValue(ConfigurationEnum.SKIPPEDSCREENSHOT).equals("yes") && isScreenshotNeeded)
			ExtentTestManager.getExtentTest().skip(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtility.getScreenshot()).build());
		else
			pass(message);
	}
}
