package com.ui.tests;

import org.testng.annotations.Test;

import com.ui.pojo.User;

public class AddNewAddressTest extends TestBase {
	// , retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class
	@Test(description = "verifies add address save", groups = { "e2e", "smoke",
			"sanity" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")
	public void Test(User user) {
		homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).goToAddressPage().saveAddess();
	}
}
