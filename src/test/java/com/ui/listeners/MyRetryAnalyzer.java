package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	public static final int MAX_ATTEMPT_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(Env.QA, "MAX_ATTEMPT_NUMBER_OF_ATTEMPTS"));//getting from properties file
	//public static final int MAX_ATTEMPT_NUMBER_OF_ATTEMPTS = JSONUtility.readJSON(Env.QA).getMAX_ATTEMPT_NUMBER_OF_ATTEMPTS();// getting from JSON file
	private static int currentAttempt = 1;

	@Override
	public boolean retry(ITestResult result)
	{
		if(currentAttempt<=MAX_ATTEMPT_NUMBER_OF_ATTEMPTS)
		{ 
			currentAttempt++;
			return true;
		}
		
		return false;
	}
	
}
