package com.ui.pages;

import static com.constants.Env.QA;
import static com.utility.PropertiesUtil.*;

import org.openqa.selenium.By;

import com.constants.Browser;
import com.utility.BroswerUtility;
import com.utility.JSONUtility;

public final class HomePage extends BroswerUtility {
	
	private static final By SIGN_IN_LINK_LOCATOR = By.linkText("Sign in");
	
	
	public HomePage(Browser browser) 
	{
		super(browser);//to call the parent class constructor from child class constructor
		//goToWebSite("https://automationpractice.techwithjatin.com/");
		//goToWebSite(readProperty(QA,"URL")); //for properties file
		goToWebSite(JSONUtility.readJSON(QA)); //for JSON file
		
	}
	public LoginPage goToLoginPage()
	{
		clickOn(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());
	}

}
