package org.ash.tests;

import java.util.HashMap;

import org.ash.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class BaseTest {

	protected BaseTest()
	{

	}
	@BeforeMethod
	public void setup(Object[] obj) throws Exception
	{
		HashMap<String,String> map= (HashMap<String,String>)obj[0]; 
		Driver.initDriver(map.get("browser"));
	}

	@AfterMethod
	public void tearDown() 
	{
		Driver.quitDriver();
	}
}
