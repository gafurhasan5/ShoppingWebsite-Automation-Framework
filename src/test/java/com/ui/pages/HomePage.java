package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.constants.Browser;
import com.utility.BroswerUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BroswerUtility {
	
	private static final By SIGN_IN_LINK_LOCATOR = By.linkText("Sign in");
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public HomePage(Browser browser) 
	{
		super(browser);//to call the parent class constructor from child class constructor
		//goToWebSite("https://automationpractice.techwithjatin.com/");
		//goToWebSite(readProperty(QA,"URL")); //for properties file
		goToWebSite(JSONUtility.readJSON(QA)); //for JSON file
		
	}
	public LoginPage goToLoginPage()
	{
		logger.info("Trying to performimg click to go to Sign in Page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());
	}

}
