package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.ui.listeners.TestListener.class)

public class LoginTestInavlidCredential extends TestBase {

	private static final String INVALID_EMAIL_ADDRESS = "rehankhan56390@gmail.com";
	private static final String INVALID_PASSWORD = "7327328321";

	@Test(description = "verifies with proper error message shown for when user enter invalid credentials | Authentication failed ", groups = {
			"e2e", "sanity","smoke" })
	public void InvalidTest() {
		assertEquals(
				homepage.goToLoginPage().doLoginWithInvalid(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD).getErrorMessage(),
				"Authentication failed.");

	}

}
