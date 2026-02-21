package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BroswerUtility;

public class ProductDetailPage extends BroswerUtility {
	private static final By SIZE_DROPDOWN_LOCATOR=By.id("group_1"); 
	private static final By ADD_TO_CART_LOACTOR=By.id("add_to_cart");
	private static final By PROCEED_TO_CART_LOACTOR_BUTTON=By.xpath("//a[@title='Proceed to checkout']");
	public ProductDetailPage(WebDriver driver) {
		super(driver);
		}
	public ProductDetailPage changeSize(Size size)
	{
		  selectFromDropDownByVisibleText(SIZE_DROPDOWN_LOCATOR,size.toString());
		  return new ProductDetailPage(getDriver()); 
	}
	public ProductDetailPage clickOnAddProductToCartButton()
	{
		clickOn(ADD_TO_CART_LOACTOR);
		 return new ProductDetailPage(getDriver());
	}
	public ProductOrderDetailPage clickOnProceedToCartButton()
	{
		clickOn(PROCEED_TO_CART_LOACTOR_BUTTON);
		 return new ProductOrderDetailPage(getDriver());
	}

	
}
