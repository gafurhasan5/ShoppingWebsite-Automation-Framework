package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BroswerUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homepage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	@BeforeMethod(description = "load the HomePage of website")
	public void setup() {
		logger.info("load the HomePage of website");
		homepage = new HomePage(CHROME);
	}
	public BroswerUtility getInstance() //need browserUtility called
	{
		return homepage;
	}
}
