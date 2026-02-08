package com.ui.tests;

import org.testng.annotations.Test;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;

public class LoginTest {
	HomePage homepage;
	public void setup()
	{
	homepage=new HomePage(CHROME);
	}
	public void tearDown()
	{
		//driver.quit();
	}

	@Test(description="verifies with valid user is able to login into the application",groups= {"e2e","sanity"})
	public void verify_Login_Valid_Credentials() {
		
		/*LoginPage loginPage=homepage.goToLoginPage();
		MyAccountPage myAccountPage=loginPage.doLoginWith("rehankhan56390@gmail.com","12345");
		String userName=myAccountPage.getUserName();*/
		//above three line we can write in single line
		String userName=homepage.goToLoginPage().doLoginWith("rehankhan56390@gmail.com","12345").getUserName();
		System.out.println(userName);
		
	}
}
