package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.RegisterTestData;
import com.ui.pojo.RegisterUser;
import com.utility.JSONUtility;

public class RegisterTest extends TestBase {

	@Test(priority = 1, description = "verify_register_with valid Credentials")
	public void verify_successful_register() {
		RegisterTestData data = JSONUtility.getTestData();
		// RegisterUser registeruser=data.getValidUser();
		RegisterUser registeruser = data.getValidUser();
		// MyAccountPage myaccountpage =
		// homepage.goToRegisterPage().doWithEmailAccountCreationRegisterPage("Hassan213223@gmail.com").doRegisterWith("Rehan","Khane","12345");
		MyAccountPage myaccountpage = homepage.goToRegisterPage()
				.doWithEmailAccountCreationRegisterPage(registeruser.getEmail())
				.doRegisterWith(registeruser.getFirstName(), registeruser.getLastName(), registeruser.getPassword());

		String actualHeadingText = "Your account has been created.";
		String expectedHeadingText = myaccountpage.getSucessHeading();
		Assert.assertEquals(actualHeadingText, expectedHeadingText);
	}

	@Test(priority = 2, description = "verify_register_with existing Credentials")
	public void verify_Donot_Register_Existing_Email() {
		RegisterTestData data = JSONUtility.getTestData();
		RegisterUser registeruser = data.getExistingUser();
		String expectedHeadingText = homepage.goToRegisterPage()
				.doWithExistingEmailAccountCreationRegisterPage(registeruser.getEmail()).getErrorExistingEmailMsg();
		String actualHeadingText = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
		Assert.assertEquals(actualHeadingText, expectedHeadingText);
	}

	@Test(priority = 3, description = "verify_register_with multiple valid Credentials")
	public void verify_register_with_multiple_valid_users() {
		RegisterTestData data = JSONUtility.getTestMutilpleData();
		for (RegisterUser registeruser : data.getValidUsers()) {
			// driver.manage
			WebDriver driver = homepage.getDriver();
			//driver.manage().deleteAllCookies();
			//driver.navigate().refresh();
			driver.quit();
			setup("chrome",false,false,null);
			MyAccountPage myaccountpage = homepage.goToRegisterPage()
					.doWithEmailAccountCreationRegisterPage(registeruser.getEmail()).doRegisterWith(
							registeruser.getFirstName(), registeruser.getLastName(), registeruser.getPassword());
			String actualHeadingText = "Your account has been created.";
			String expectedHeadingText = myaccountpage.getSucessHeading();
			Assert.assertEquals(actualHeadingText, expectedHeadingText);

		}
	}

	@Test(priority = 4, description = "verify_register_with multiple existing valid Credentials")
	public void verify_register_with_multiple_existing_users() {
		RegisterTestData data = JSONUtility.getTestMutilpleData();
		for (RegisterUser registeruser : data.getExistingUsers()) {
			WebDriver driver = homepage.getDriver();
			//driver.manage().deleteAllCookies();
			driver.navigate().refresh();
			String expectedHeadingText = homepage.goToRegisterPage()
					.doWithExistingEmailAccountCreationRegisterPage(registeruser.getEmail()).getErrorExistingEmailMsg();
			String actualHeadingText = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
			Assert.assertEquals(actualHeadingText, expectedHeadingText);

		}
	}
	
	@Test(priority=5,description="verify register using dataprovider",dataProviderClass = com.ui.dataProviders.RegisterDataProvider.class,dataProvider = "validUsers")
	public void verify_register_using_multiple_data_using_DataProvider(RegisterUser user) {
		MyAccountPage myaccountpage = homepage.goToRegisterPage()
				.doWithEmailAccountCreationRegisterPage(user.getEmail())
				.doRegisterWith(user.getFirstName(), user.getLastName(), user.getPassword());
		Assert.assertEquals(myaccountpage.getSucessHeading(), "Your account has been created.");
	}

}
