package org.ash.pages;

import org.ash.driver.DriverManager;
import org.ash.enums.WaitStrategy;
import org.ash.factory.ExplicitWaitFactory;
import org.ash.utils.DynamicXpathUtility;
import org.openqa.selenium.By;

public class AmazonHamburgerMenuPage extends BasePage {


	private By hamBurgerMenuAll = By.xpath("//a[@id='nav-hamburger-menu']");
	public String mainMenuItem="//div[text()='%replace%']";
	public String subMenuItem="//a[text()='%replace%']";

	public AmazonHamburgerMenuPage clickHamburgermenu()
	{
		clickElement(hamBurgerMenuAll,WaitStrategy.CLICKABLE);
		return this;
	}

	public AmazonHamburgerMenuPage clickMainmenu(String item) throws InterruptedException
	{
		Thread.sleep(3000);
		clickElement(By.xpath(DynamicXpathUtility.getXpath(mainMenuItem, item)),WaitStrategy.CLICKABLE);
		return this;
	}
	public String clickSubmenu(String item) throws InterruptedException
	{
		Thread.sleep(3000);
		clickElement(By.xpath(DynamicXpathUtility.getXpath(subMenuItem, item)),WaitStrategy.CLICKABLE);
		return DriverManager.getDriver().getTitle();
	}
	
}
