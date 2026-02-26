package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BroswerUtility;

public final class MyAccountPage extends BroswerUtility {

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
	private static final By SEARCH_BOX_TEXT_LOCATOR = By.id("search_query_top");
	private static final By SEARCH_BUTTON_TEXT_LOCATOR = By.name("submit_search");
	private static final By ADD_NEW_ADDRESS_LINK_LOCATOR = By.xpath("//a[contains(@title,'Add my first address')]");
	private static final By SUCCESS_TEXT_LOCATOR = By.xpath("//p[@class='alert alert-success']");
	private static final By SIGN_OUT_BUTTON_LOCATOR = By.xpath("//a[@class='logout']");
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getUserName() {
		return getVisibilityText1(USER_NAME_LOCATOR);
	}

	public SearchPage searchForAProduct(String productName) {
		enterText(SEARCH_BOX_TEXT_LOCATOR, productName);
		clickOn(SEARCH_BUTTON_TEXT_LOCATOR);
		return new SearchPage(getDriver());
	}

	public AddressPage goToAddressPage() {
		clickOn(ADD_NEW_ADDRESS_LINK_LOCATOR);
		return new AddressPage(getDriver());
	}
	public String getSucessHeading() {
		return getVisibilityText1(SUCCESS_TEXT_LOCATOR);
	}
	public RegisterPage logout()
	{
		clickOn(SIGN_OUT_BUTTON_LOCATOR);
		return new RegisterPage(getDriver());
	}
	
}
