package org.ash.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ash.utils.ExcelUtility;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class IMethodInterceptorListener implements IMethodInterceptor{

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<IMethodInstance> result=  new ArrayList<IMethodInstance>();
		List<Map<String,String>> list=ExcelUtility.getData("TestDetails.xlsx", "runManager");
		
		for(int i=0;i<methods.size();i++)
		{
			for(int j=0;j<list.size();j++)
			{
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname"))
						&& (list.get(j).get("execute")).equalsIgnoreCase("yes"))
				{
					System.out.println(methods.get(i).getMethod().getMethodName());
					result.add(methods.get(i));
				}
			}
		}
		return result;
	}

}
