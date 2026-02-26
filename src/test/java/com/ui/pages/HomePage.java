package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BroswerUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BroswerUtility {

	private static final By SIGN_IN_LINK_LOCATOR = By.linkText("Sign in");
	

	//li[contains(text(),'An account using this email address has already be')]
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public HomePage(Browser browser, boolean isHeadless) {
		super(browser, isHeadless);// to call the parent class constructor from child class constructor
		// goToWebSite("https://automationpractice.techwithjatin.com/");
		// goToWebSite(readProperty(QA,"URL")); //for properties file
		goToWebSite(JSONUtility.readJSON(QA)); // for JSON file
		   maximizeWindow();
	}

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebSite(JSONUtility.readJSON(QA));
	}

	public LoginPage goToLoginPage() {
		logger.info("Trying to performimg click to go to Sign in Page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());
	}

	public RegisterPage goToRegisterPage() {
		logger.info("Trying to performimg click to go to Register in Page");
		clickOn(SIGN_IN_LINK_LOCATOR);
        return new RegisterPage(getDriver());
	}

	public void quitBrowser() {
		logger.info("Trying to perform close the browser....");
		getDriver().quit();
	}
//	public void refreshBrowser() {
//		logger.info("Trying to perform refresh the browser....");
//		getDriver().manage().deleteAllCookies();
//		//getDriver().r
//		getDriver().close();
//		
//	}

}
