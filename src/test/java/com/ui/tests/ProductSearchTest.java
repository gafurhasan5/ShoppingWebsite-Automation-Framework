package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners(com.ui.listeners.TestListener.class)

public class ProductSearchTest extends TestBase{
	
	String searchTermProductName="PRINTED SUMMER DRESS";
	@Test(description = "verifies if the logged in user able to to search product and correct product  are displayed", groups = { "e2e",
	"smoke","sanity"},dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	
	public void verifyProductSearchTest(User user)
	{
		//String Productname=homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).searchForAProduct("PRINTED SUMMER DRESS").getProductHeadingTitle();
		//System.out.println("Heading Page Title: "+Productname);

		//assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).searchForAProduct("RINTED SUMMER DRESS").getProductHeadingTitle(),
			//"Printed Summer Dress");
		boolean actualResult=homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).searchForAProduct(searchTermProductName).IsSearchTermProductNamePresent(searchTermProductName);
		
		Assert.assertEquals(actualResult,true);
	}

	

}
