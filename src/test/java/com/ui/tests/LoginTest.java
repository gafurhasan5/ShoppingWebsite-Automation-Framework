package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;

public class LoginTest {
	HomePage homepage;
	@BeforeMethod(description="load the HomePage of website")
	public void setup()
	{
	homepage=new HomePage(CHROME);
	}

	@Test(description="verifies with valid user is able to login into the application",groups= {"e2e","sanity"})
	public void verify_Login_Valid_Credentials() {
		
		/*LoginPage loginPage=homepage.goToLoginPage();
		MyAccountPage myAccountPage=loginPage.doLoginWith("rehankhan56390@gmail.com","12345");
		String userName=myAccountPage.getUserName();*/
		//String userName=homepage.goToLoginPage().doLoginWith("rehankhan56390@gmail.com","12345").getUserName();
		assertEquals(homepage.goToLoginPage().doLoginWith("rehankhan56390@gmail.com","12345").getUserName(),"Rehan khan");
		
		
	}
}
