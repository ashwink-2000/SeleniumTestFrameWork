package org.ash.pages;

import org.ash.enums.WaitStrategy;
import org.ash.extentreports.ExtentLogger;
import org.ash.factory.ExplicitWaitFactory;
import org.openqa.selenium.By;

public class BasePage {

	protected BasePage()
	{

	}
	public void clickElement(By by,WaitStrategy waitStrategy)
	{
		ExplicitWaitFactory.peformExplicitWait(by, waitStrategy).click();
		ExtentLogger.pass(by.toString() +"is clicked");
		
	}

	public void sendText(By by,String value,WaitStrategy waitStrategy)
	{		
		ExplicitWaitFactory.peformExplicitWait(by, waitStrategy).sendKeys(value);
	}

}

