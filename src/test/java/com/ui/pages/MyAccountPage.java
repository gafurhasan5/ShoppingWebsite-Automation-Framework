package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BroswerUtility;

public final  class MyAccountPage extends BroswerUtility {
	
	private static final By USER_NAME_LOCATOR=By.xpath("//a[@title='View my customer account']/span");
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	public String getUserName()
	{
		return getVisibilityText(USER_NAME_LOCATOR);
	}

}
