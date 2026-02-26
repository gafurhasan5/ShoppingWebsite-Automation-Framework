package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BroswerUtility;

public class AccountCreationRegisterPage extends BroswerUtility {
	//p[@class='alert alert-success']
	static final By GENDER_CHECKBOX_BOX_LOCATOR = By.id("id_gender1");//By.xpath("//input[@id='id_gender1']");
	static final By FIRST_NAME_TEXT_BOX_LOCATOR = By.xpath("//input[@id='customer_firstname']");
	static final By LAST_NAME_TEXT_BOX_LOCATOR = By.xpath("//input[@id='customer_lastname']");
	static final By PASSWORD_TEXT_BOX_LOCATOR = By.xpath("//input[@id='passwd']");
	static final By DAY_SELECT_BOX_LOCATOR = By.xpath("//select[@id='days']");
	static final By MONTH_SELECT_BOX_LOCATOR = By.xpath("//select[@id='months']");
	static final By YEAR_SELECT_BOX_LOCATOR = By.xpath("//select[@id='years']");
	static final By CLICK_NEWSLETTER_LOCATOR = By.id("uniform-newsletter");//By.xpath("//input[@id='uniform-newsletter']");
	static final By CLICK_OFFER__LOCATOR = By.id("uniform-optin");//By.xpath("//input[@id='optin']");
	static final By REGISTER_SUBMIT_BUTTON__LOCATOR = By.xpath("//button[@id='submitAccount']");
	public AccountCreationRegisterPage(WebDriver driver) {
		super(driver);
	}
   public MyAccountPage doRegisterWith(String fname,String lname,String password)
   {
	   clickOn(GENDER_CHECKBOX_BOX_LOCATOR);
	   enterText(FIRST_NAME_TEXT_BOX_LOCATOR,fname);
	   enterText(LAST_NAME_TEXT_BOX_LOCATOR,lname);
	   enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
	   selectFromDropDown(DAY_SELECT_BOX_LOCATOR);
	   selectFromDropDown(MONTH_SELECT_BOX_LOCATOR);
	   selectFromDropDown(YEAR_SELECT_BOX_LOCATOR);
	   clickOnCheckBox(CLICK_NEWSLETTER_LOCATOR);
	   clickOnCheckBox(CLICK_OFFER__LOCATOR);
	   clickOn(REGISTER_SUBMIT_BUTTON__LOCATOR);
	   return new  MyAccountPage(getDriver());
   }
}
