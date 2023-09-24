package org.ash.utils;

public final class DynamicXpathUtility {

	private DynamicXpathUtility()
	{
		
	}
	
	public static String getXpath(String xpath,String value)
	{
		System.out.println(xpath.replace("%replace%",value));
		return xpath.replace("%replace%",value);
	}
}
