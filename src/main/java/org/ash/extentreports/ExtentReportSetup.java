package org.ash.extentreports;

import java.util.Objects;

import org.ash.frameworkconstants.FrameworkConstants;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReportSetup {

	private ExtentReportSetup()
	{

	}

	private static ExtentReports extentReport;
	public static void initExtentReport() throws Exception
	{ 
		if(Objects.isNull(extentReport)) 
		{
			extentReport = new ExtentReports();
			ExtentSparkReporter sparkReporter= new ExtentSparkReporter(FrameworkConstants.getExtentReportPath());
			extentReport.attachReporter(sparkReporter);
			sparkReporter.config().setDocumentTitle("Automation Report");
			sparkReporter.config().setReportName("Automation Report");
			sparkReporter.config().setTheme(Theme.STANDARD);
		}
	}

	public static void quitExtentReport()
	{  
		if(Objects.nonNull(extentReport))
		{		
			extentReport.flush();
			ExtentTestManager.remove();
		}
	}

	public static void createTest(String testName)
	{
		ExtentTestManager.setExtentTest(extentReport.createTest(testName));
	}
}
