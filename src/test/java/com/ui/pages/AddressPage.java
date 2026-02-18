package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.BroswerUtility;

public class AddressPage extends BroswerUtility {
	// static final By FIRST_NAME_LOCATOR = By.id("firstname");
	// static final By LAST_NAME_LOCATOR = By.id("lastname");
	static final By COMPANY_TEXTBOX_LOACTOR = By.id("company");
	static final By ADDRESS1_TEXTBOX_LOACTOR = By.id("address1");
	static final By ADDRESS2_TEXTBOX_LOACTOR = By.id("address2");
	static final By POSTCODE_TEXTBOX_LOACTOR = By.id("postcode");
	static final By CITY_TEXTBOX_LOACTOR = By.id("city");
	static final By COUNTRY_TEXTBOX_LOACTOR = By.id("id_country");
	static final By HOME_PHONE_TEXTBOX_LOACTOR = By.id("phone");
	static final By MOBILE_PHONE_TEXTBOX_LOACTOR = By.id("phone_mobile");
	static final By STATE_SELECT_LOACTOR = By.id("id_state");
	static final By ADDITIONAL_INFORMATION_TEXTAREA_LOACTOR = By.id("other");
	static final By ASSIGN_ADDRESS1_TEXTBOX_LOACTOR = By.id("alias");
	static final By SAVE_ADDRESS_LOCATOR = By.id("submitAddress");
	static final By SAVE_ADDRESS_HEADING = By.xpath("//h3[contains(text(),'Home Adresss')]");
	
	public AddressPage(WebDriver driver) {
		super(driver);
	}

	public String saveAddess(AddressPOJO address) {
		enterText(COMPANY_TEXTBOX_LOACTOR, address.getCompanyName());
		enterText(ADDRESS1_TEXTBOX_LOACTOR, address.getAddress1());
		enterText(ADDRESS2_TEXTBOX_LOACTOR, address.getAddress2());
		enterText(POSTCODE_TEXTBOX_LOACTOR, address.getPostCode());
		enterText(CITY_TEXTBOX_LOACTOR, address.getCity());
		// selectFromDropDown(COUNTRY_TEXTBOX_LOACTOR,"India");
		enterText(HOME_PHONE_TEXTBOX_LOACTOR, address.getHomePhoneNumber());
		enterText(MOBILE_PHONE_TEXTBOX_LOACTOR, address.getMobilePhoneNumber());

		enterText(ADDITIONAL_INFORMATION_TEXTAREA_LOACTOR, address.getOtherInformation());
		clearText(ASSIGN_ADDRESS1_TEXTBOX_LOACTOR);
		enterText(ASSIGN_ADDRESS1_TEXTBOX_LOACTOR, address.getAddressAlias());

		selectFromDropDown(STATE_SELECT_LOACTOR);
		clickOn(SAVE_ADDRESS_LOCATOR);
		String newAddressHeading=getVisibilityText1(SAVE_ADDRESS_HEADING);
		return  newAddressHeading;
	}

}
