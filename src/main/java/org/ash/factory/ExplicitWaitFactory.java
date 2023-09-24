package org.ash.factory;

import java.time.Duration;

import org.ash.driver.DriverManager;
import org.ash.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ExplicitWaitFactory {

	private ExplicitWaitFactory()
	{

	}

	public static  WebElement peformExplicitWait(By by,WaitStrategy waitStrategy) 
	{
		WebElement element=null;
		if(waitStrategy.equals(WaitStrategy.PRESENCE))
		{
			element= new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(waitStrategy.equals(WaitStrategy.VISIBILITY))
		{
			element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if(waitStrategy.equals(WaitStrategy.CLICKABLE))
		{
			element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(15))
					.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(waitStrategy.equals(WaitStrategy.NONE))
		{
			element=DriverManager.getDriver().findElement(by);
		}

		return element;
	}

}
