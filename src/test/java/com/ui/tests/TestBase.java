package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BroswerUtility;
import com.utility.LamdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homepage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	// for local Test in eclipse
//	@BeforeMethod(description = "load the HomePage of website")
//	public void setup() {
//		logger.info("load the HomePage of website");
//		homepage = new HomePage(CHROME,true);// true for isHeadless browser
//	}
	// forLamdaTest
	private boolean isLamdaTest = true;
     private boolean isHeadless=true;
	@BeforeMethod(description = "load the HomePage of website")
	public void setup(ITestResult result) {
		WebDriver lamdaDriver = null;
		if (isLamdaTest) {
			LamdaTestUtility.initializeLamdaTestSession("chrome", result.getMethod().getMethodName());
			homepage = new HomePage(lamdaDriver);
		} else {
			logger.info("load the HomePage of website");
			homepage = new HomePage(CHROME, isHeadless);// true for isHeadless browser
		}
	}

	public BroswerUtility getInstance() // need browserUtility called
	{
		return homepage;
	}

	@AfterMethod(description = "Tear Down the browser")
	public void tearDown() {
		if (isLamdaTest) {
			LamdaTestUtility.quitSession();//quit or close the browserSession on LamdaTest
		} else {
			homepage.quitBrowser(); //local
		}
	}
}
