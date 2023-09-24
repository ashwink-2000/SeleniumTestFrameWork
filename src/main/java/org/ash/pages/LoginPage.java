package org.ash.pages;

import org.ash.driver.DriverManager;
import org.ash.enums.WaitStrategy;
import org.ash.extentreports.ExtentLogger;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage {
	
	private By textboxUserName=By.xpath("//input[@name='username']");
	private By textboxPassword=By.xpath("//input[@name='password']");
	private By buttonLogin=By.xpath("//button[@type='submit']");

	public LoginPage enterUserName(String userName)
	{
		sendText(textboxUserName,userName,WaitStrategy.PRESENCE);
		ExtentLogger.pass(userName+"entered");
		return this;
	}
	
	public LoginPage enterPassword(String password)
	{
		sendText(textboxPassword,password,WaitStrategy.PRESENCE);
		ExtentLogger.pass(password+"entered");
		return this;
	}
	
	public HomePage clickLogin()
	{
		clickElement(buttonLogin,WaitStrategy.PRESENCE);
		ExtentLogger.pass("element clicked");
		return new HomePage();
	}
	
	public String getTitle()
	{
		return DriverManager.getDriver().getTitle();
	}
}

