package org.ash.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.ash.enums.ConfigurationEnum;
import org.ash.utils.ConfigurationUtility;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class Driver {

	private Driver()
	{

	}
	
	public static void initDriver(String browser) 
	{
		if(Objects.isNull(DriverManager.getDriver()))
		{
			if(browser.equalsIgnoreCase("chrome"))
			{	
				if(ConfigurationUtility.getValue(ConfigurationEnum.RUNMODE).equalsIgnoreCase("remote"))
				{
					DesiredCapabilities cap= new DesiredCapabilities();
					cap.setBrowserName("chrome");
					try {
						DriverManager.setDriver(new RemoteWebDriver(new URL("http://localhost:4444"),cap));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				}
				else if(ConfigurationUtility.getValue(ConfigurationEnum.RUNMODE).equalsIgnoreCase("local"))
				{
					DriverManager.setDriver(new ChromeDriver());
				}
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				if(ConfigurationUtility.getValue(ConfigurationEnum.RUNMODE).equalsIgnoreCase("remote"))
				{
					DesiredCapabilities cap= new DesiredCapabilities();
					cap.setBrowserName("firefox");
					try {
						DriverManager.setDriver(new RemoteWebDriver(new URL("http://localhost:4444"),cap));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				}
				else if(ConfigurationUtility.getValue(ConfigurationEnum.RUNMODE).equalsIgnoreCase("local"))
				{
					DriverManager.setDriver(new FirefoxDriver());
				}
			}
			DriverManager.getDriver().get(ConfigurationUtility.getValue(ConfigurationEnum.URL));
			DriverManager.getDriver().manage().window().maximize();
		}		
	}

	public static void quitDriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}

