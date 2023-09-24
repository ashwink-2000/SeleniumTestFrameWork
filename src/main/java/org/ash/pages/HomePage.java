package org.ash.pages;

import org.ash.enums.WaitStrategy;
import org.ash.extentreports.ExtentLogger;
import org.openqa.selenium.By;

public final class HomePage extends BasePage{
	private By buttonUserProfile=By.xpath("//span[@class='oxd-userdropdown-tab']");
	private By buttonLogout=By.xpath("//a[text()='Logout']");
	
	public HomePage clickUserProfile()
	{
		clickElement(buttonUserProfile,WaitStrategy.PRESENCE);
		ExtentLogger.pass("element clicked");
		return this;
	}
	
	public LoginPage clickLogout() throws InterruptedException
	{
		clickElement(buttonLogout,WaitStrategy.PRESENCE);
		ExtentLogger.pass("element clicked");
		Thread.sleep(3000);
		return new LoginPage();
	}
}
