package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ui.pojo.AddressPOJO;
import com.ui.pojo.User;
import com.utility.FakerAddressUtility;

public class AddNewFirstTimeAddressTest extends TestBase {
	// , retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class
	
	AddressPOJO address;
	@Test(description = "verifies first Time add address save", groups = { "e2e", "smoke",
			"sanity" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")
	public void Test(User user) {
		// address=new AddressPOJO("CG","AURAI","BHADHOHI", "PUNE", "983983", "8738826601","8738826601", "Hello gafur", "Home Adresss", "Goa");
		address=FakerAddressUtility.getFakeAddess();
		String AddressHeading=homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).goToAddressPage().saveAddess(address);
		Assert.assertEquals(AddressHeading,address.getAddressAlias().toUpperCase());
	}
}