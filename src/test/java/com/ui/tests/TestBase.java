package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
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
	private boolean isLamdaTest;
	//private boolean isHeadless = true;
    
	@Parameters({"browser","isLamdaTest","isHeadless"})
	@BeforeMethod(description = "load the HomePage of website")
	public void setup(
			@Optional("Chrome")String browser,   //@Optional use the run the one particular class test without run testing.xml file(all test run)
			@Optional("false")boolean isLamdaTest,
			@Optional("false")boolean isHeadless ,ITestResult result) {

		WebDriver lamdaDriver;

		if (isLamdaTest) {

			lamdaDriver = LamdaTestUtility.initializeLamdaTestSession(browser, result.getMethod().getMethodName());

			homepage = new HomePage(lamdaDriver);

		} else {

			logger.info("load the HomePage of website");
			homepage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	public BroswerUtility getInstance() // need browserUtility called
	{
		return homepage;
	}

	@AfterMethod(description = "Tear Down the browser")
	public void tearDown() {
		if (isLamdaTest) {
			LamdaTestUtility.quitSession();// quit or close the browserSession on LamdaTest
		} else {
			homepage.quitBrowser(); // local
		}
	}
}
