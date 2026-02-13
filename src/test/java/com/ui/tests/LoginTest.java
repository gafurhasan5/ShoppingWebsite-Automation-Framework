package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

public class LoginTest {
	HomePage homepage;
	
	Logger logger=LoggerUtility.getLogger(this.getClass());
	@BeforeMethod(description = "load the HomePage of website")
	public void setup() {
		homepage = new HomePage(CHROME);
	}

	@Test(description = "verifies with valid user is able to login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void verify_Login_Valid_Credentials(User user) {

		/*
		 * LoginPage loginPage=homepage.goToLoginPage(); MyAccountPage
		 * myAccountPage=loginPage.doLoginWith("rehankhan56390@gmail.com","12345");
		 * String userName=myAccountPage.getUserName();
		 * 
		 * // String
		 * userName=homepage.goToLoginPage().doLoginWith("rehankhan56390@gmail.com",
		 * "12345").getUserName();
		 * assertEquals(homepage.goToLoginPage().doLoginWith("rehankhan56390@gmail.com",
		 * "12345").getUserName(), "Rehan khan");
		 */

		// when we use DataProvider for multipledata for test
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Rehan khan");

	}

	// using Csv file
	@Test(description = "verifies with valid user is able to login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public void verify_Login_Valid_withCSVDATA__Credentials(User user) {
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Rehan khan");

	}

	@Test(description = "verifies with valid user is able to login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void verify_Login_Valid_withExcelDATA__Credentials(User user) {
		
		
		logger.info("Started my Login Excel");

		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Angel John1");
		logger.info("my Login Excel Completed");

	}
}
