package com.ui.tests;

import org.testng.annotations.Test;

import com.ui.pojo.AddressPOJO;
import com.ui.pojo.User;
import com.utility.FakerAddressUtility;

public class AddNewFirstTimeAddressTest extends TestBase {
	// , retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class
	
	AddressPOJO address;
	@Test(description = "verifies add address save", groups = { "e2e", "smoke",
			"sanity" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")
	public void Test(User user) {
		// address=new AddressPOJO("CG","AURAI","BHADHOHI", "PUNE", "983983", "8738826601","8738826601", "Hello gafur", "Ghosia Aurai Bhadohi", "Goa");
		address=FakerAddressUtility.getFakeAddess();
		homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).goToAddressPage().saveAddess( address);
	}
}