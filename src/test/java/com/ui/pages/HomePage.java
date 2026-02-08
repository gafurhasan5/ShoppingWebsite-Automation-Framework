package com.ui.pages;

import org.openqa.selenium.By;

import com.constants.Browser;
import com.utility.BroswerUtility;

public final class HomePage extends BroswerUtility {
	
	private static final By SIGN_IN_LINK_LOCATOR = By.linkText("Sign in");
	
	
	public HomePage(Browser chrome)
	{
		super(chrome);//to call the parent class constructor from child class constructor
		goToWebSite("https://automationpractice.techwithjatin.com/");
	}
	public LoginPage goToLoginPage()
	{
		clickOn(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());
	}

}
