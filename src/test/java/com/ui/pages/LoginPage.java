package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BroswerUtility;

public final class LoginPage extends BroswerUtility {

	static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
	static final By LOGIN_ERROR_MSG_LOCATOR = By.xpath("//li[text()='Authentication failed.']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage doLoginWith(String emailAddress, String Password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, Password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		return new MyAccountPage(getDriver());
	}

	public LoginPage doLoginWithInvalid(String emailAddress, String Password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, Password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		return new LoginPage(getDriver());
	}

	public String getErrorMessage() {
		return getVisibilityText(LOGIN_ERROR_MSG_LOCATOR);
	}
}