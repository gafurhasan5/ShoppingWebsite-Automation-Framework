package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BroswerUtility;

public class ProductOrderDetailPage extends BroswerUtility {
	private static final By PROCEED_NEXT_TO_CART_LOACTOR_BUTTON = By
			.xpath("//a[@class='button btn btn-default standard-checkout button-medium']");
	

	public ProductOrderDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public  ConfirmAddressPage goToConfirmAddressPage() {
         clickOn(PROCEED_NEXT_TO_CART_LOACTOR_BUTTON);
         return new  ConfirmAddressPage(getDriver());
	}
	
}
