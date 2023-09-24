package org.ash.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public final class DataProviderUtility {

	private DataProviderUtility()
	{

	}

	@DataProvider(name="getData",parallel=true)
	public static Object[] getData(Method m)
	{
		String methodName=m.getName();
		List<Map<String,String>> iterationlist= new ArrayList<Map<String,String>>();
		List<Map<String,String>> list=ExcelUtility.getData("TestDetails.xlsx", "data");
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).get("testname").equalsIgnoreCase(methodName)
					&& list.get(i).get("execute").equalsIgnoreCase("yes"))
			{
				iterationlist.add(list.get(i));
			}
		}
		System.out.println(list.toString());
		return iterationlist.toArray();
	}
}
