package com.ui.tests;

import org.testng.annotations.Test;

import static com.constants.Size.*;

import com.ui.pages.ConfirmAddressPage;
import com.ui.pages.ProductDetailPage;
import com.ui.pages.ProductOrderDetailPage;
import com.ui.pages.SearchPage;
import com.ui.pojo.User;

public class ProductCheckoutTest extends TestBase {
	// retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class

	String searchTermProductName = "PRINTED SUMMER DRESS";

	@Test(description = "verifies if logged in User is able to buy a dress", groups = { "e2e", "smoke",
			"sanity" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")

	public void checkoutTest(User user)  {
		SearchPage searchpage = homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword())
				.searchForAProduct(searchTermProductName);
		ProductDetailPage productdetailpage = searchpage.clickOnTheProductAt(1);
		// productCheckoutpage.changeSize(Size.M);
		// productCheckoutpage=productCheckoutpage.changeSize(L);

		productdetailpage.clickOnAddProductToCartButton();

		ProductOrderDetailPage productorderdetailpage = productdetailpage.clickOnProceedToCartButton();

		ConfirmAddressPage confirmaddressPage = productorderdetailpage.goToConfirmAddressPage();

		confirmaddressPage.goToShipmentPage().goToPaymentpage();
	}

}
