package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BroswerUtility;

public class ConfirmAddressPage extends BroswerUtility {
	private static final By PROCEED_TO_ADRRESS_LOACTOR_BUTTON = By.name("processAddress");
	public ConfirmAddressPage(WebDriver driver) {
		super(driver);
		
	}
	public   ShipmentPage goToShipmentPage()  {
        clickOn(PROCEED_TO_ADRRESS_LOACTOR_BUTTON);
        return new  ShipmentPage(getDriver());
	}
}
