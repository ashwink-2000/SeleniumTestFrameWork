package org.ash.utils;

import org.ash.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public final class ScreenShotUtility {

	private ScreenShotUtility()
	{
		
	}
	
	public  static String getScreenshot()
	{
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
