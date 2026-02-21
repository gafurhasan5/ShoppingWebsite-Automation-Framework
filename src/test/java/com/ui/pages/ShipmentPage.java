package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BroswerUtility;

public class ShipmentPage extends BroswerUtility  {
	private static final By ACCEPT_TERM_LOACTOR = By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOACTOR = By.id("uniform-cgv");
	public ShipmentPage(WebDriver driver) {
		super(driver);
		
	}
	public PaymentPage goToPaymentpage()
	{
		clickOnCheckBox(ACCEPT_TERM_LOACTOR);
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOACTOR );
		return new PaymentPage(getDriver());
	}
	

}
