package org.ash.tests;

import java.util.HashMap;

import org.ash.pages.AmazonHamburgerMenuPage;
import org.testng.annotations.Test;

public final class AmazonPageTest extends BaseTest {

	private AmazonPageTest()
	{}
	
	@Test
	public void amazonTest(HashMap<String,String> data) throws InterruptedException
	{
		AmazonHamburgerMenuPage obj= new AmazonHamburgerMenuPage();
		String title=obj.clickHamburgermenu().clickMainmenu(data.get("mainmenuitem")).clickSubmenu(data.get("submenuitem"));
		System.out.println(title);
	}
}
