package org.ash.tests;
import java.util.HashMap;

import org.ash.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAndLogoutTest extends BaseTest {
	@Test
	public void loginPageTest(HashMap<String,String> data) throws InterruptedException
	{
		LoginPage loginPage= new LoginPage();
		String title=loginPage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin().clickUserProfile().clickLogout().getTitle();
		Assert.assertEquals(title,"OrangeHRM");
	}

	@Test
	public void loginPageTest1(HashMap<String,String> data) throws InterruptedException
	{
		LoginPage loginPage= new LoginPage();
		String title=loginPage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin().clickUserProfile().clickLogout().getTitle();
		Assert.assertEquals(title,"OrangeHRM");
	}
}
