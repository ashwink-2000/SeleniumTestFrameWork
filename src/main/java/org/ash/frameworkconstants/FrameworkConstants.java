package org.ash.frameworkconstants;

import org.ash.enums.ConfigurationEnum;
import org.ash.utils.ConfigurationUtility;

public final  class FrameworkConstants {
	private FrameworkConstants()
	{

	}

	private static String CONFIGURATIONFILEPATH =System.getProperty("user.dir")+"/src/test/resources/config/configuration.properties";
	private static String FOLDERPATH=System.getProperty("user.dir")+"/src/test/resources/ExtentReports/";
	private static String EXTENTREPORTPATH="";

	public static String getExtentReportPath() throws Exception
	{
		if(EXTENTREPORTPATH.isEmpty())
			EXTENTREPORTPATH=createReportPath();

		return EXTENTREPORTPATH;
	}

	private static String createReportPath() throws Exception
	{
		if(ConfigurationUtility.getValue(ConfigurationEnum.OVERRIDEREPORTS).equalsIgnoreCase("no"))
			return FOLDERPATH+System.currentTimeMillis()+"index.html";
		else
			return FOLDERPATH+"index.html";
	}

	public static String getConfigurationFilePath()
	{
		return CONFIGURATIONFILEPATH;
	}
}
