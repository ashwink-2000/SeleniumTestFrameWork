package org.ash.listeners;

import org.ash.enums.ConfigurationEnum;
import org.ash.utils.ConfigurationUtility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListner implements IRetryAnalyzer {

	
	int count=0;
	int retryCount=1;
	 boolean value=false;
	@Override
	public boolean retry(ITestResult result) {
		 boolean value=false;
		 try {
			if(ConfigurationUtility.getValue(ConfigurationEnum.RETRY).equalsIgnoreCase("yes"))
				{
				   value= count<retryCount;
				   count++;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
