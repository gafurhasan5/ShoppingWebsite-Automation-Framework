package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterUtility {
	private static ExtentSparkReporter extentSparkreporter;  //resposible for UI Report-like dark theme,location of information
	private static ExtentReports extentReports;   // responsibe for common information on report->testname ,browser, env detail 
	private static ThreadLocal <ExtentTest> extentTest=new ThreadLocal<ExtentTest>();//responsible for creating test case entries in the report and update status of test method
	public static void setupSparkReporter(String reportName)
	{
	    extentSparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//"+reportName);
	    extentSparkreporter.config().setDocumentTitle("Automation Report");
	    extentSparkreporter.config().setReportName(reportName);
	    extentSparkreporter.config().setTheme(Theme.DARK);
	    extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkreporter);
		//extentReports.setSystemInfo(reportName, reportName)
	}
    public static void createExtentTest(String testName)
    {
    	ExtentTest Test= extentReports.createTest(testName);
    	extentTest.set(Test);
    }
    public static ExtentTest getTest()
    {
    	return extentTest.get();
    }
    public static void flushReport()
    {
    	extentReports.flush();
    }
}
