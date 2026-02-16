package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
	
	private static ExtentReports extentReports;
	private static ThreadLocal <ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	public static void setupSparkReporter(String reportName)
	{
		ExtentSparkReporter extentSparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "//"+ reportName);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkreporter);
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
