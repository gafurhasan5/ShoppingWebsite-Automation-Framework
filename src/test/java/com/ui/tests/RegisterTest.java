package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

public class RegisterTest extends TestBase{
	
	@Test(priority=1)
	public void verify_successful_register() 
	{
		MyAccountPage myaccountpage = homepage.goToRegisterPage().doWithEmailAccountCreationRegisterPage("Hassan213223@gmail.com").doRegisterWith("Rehan","Khane","12345");
		String actualHeadingText="Your account has been created.";
		String expectedHeadingText=myaccountpage.getSucessHeading();
		Assert.assertEquals(actualHeadingText,expectedHeadingText);
	}
	@Test(priority=2)
	public void verify_Donot_Register_Existing_Email() 
	{
		String expectedHeadingText = homepage.goToRegisterPage().doWithExistingEmailAccountCreationRegisterPage("Hassan1223@gmail.com").getErrorExistingEmailMsg();
		String actualHeadingText="An account using this email address has already been registered. Please enter a valid password or request a new one.";
        Assert.assertEquals(actualHeadingText,expectedHeadingText);
	}

}
