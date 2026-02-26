package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BroswerUtility;

public class RegisterPage extends BroswerUtility {
	private static final By REGISTER_EMAIL_TEXT_BOX_LOCATOR = By.xpath("//input[@id='email_create']");
	private static final By CREATE_ACCOUNT_SUBMIT_LOCATOR = By.xpath("//button[@id='SubmitCreate']");
	private static final By ACCOUNT_EXIST_ERROR_MSG_HEADING_LOCATOR = By.xpath("//li[contains(text(),'An account using this email')]");
	private static final By REGISTER_HEADING_TEXT_LOCATOR = By.xpath("//h3[normalize-space()='Create an account']");
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	public AccountCreationRegisterPage doWithEmailAccountCreationRegisterPage(String emailAddress) {
	     enterText(REGISTER_EMAIL_TEXT_BOX_LOCATOR, emailAddress);
         clickOn(CREATE_ACCOUNT_SUBMIT_LOCATOR);
         return new AccountCreationRegisterPage(getDriver());
   }
	public RegisterPage  doWithExistingEmailAccountCreationRegisterPage(String emailAddress) {
	     enterText(REGISTER_EMAIL_TEXT_BOX_LOCATOR, emailAddress);
        clickOn(CREATE_ACCOUNT_SUBMIT_LOCATOR);
        return new RegisterPage(getDriver());
  }
	public String getErrorExistingEmailMsg()
	{
		return getVisibilityText1(ACCOUNT_EXIST_ERROR_MSG_HEADING_LOCATOR);
	}
	public String getHeadingofRegister() {
		return getVisibilityText1( REGISTER_HEADING_TEXT_LOCATOR);
	}
}