package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.RegisterPage;
import com.ui.pojo.User;


public class CheckoutTest extends TestBase {
	@Test(priority = 1, description = "verify_signout",dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")
	public void verify_checkout(User user) {
		RegisterPage registerpage =homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).logout();
		String registerHeadingPage=registerpage.getHeadingofRegister();
		Assert.assertEquals(registerHeadingPage,"CREATE AN ACCOUNT");
		
	}
                 }
