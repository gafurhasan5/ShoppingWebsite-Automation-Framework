package com.ui.dataProviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.ui.pojo.RegisterTestData;
import com.ui.pojo.RegisterUser;
import com.utility.JSONUtility;

public class RegisterDataProvider {
	@DataProvider(name = "validUsers")
	public Object[][] getValidUsers() {
		 RegisterTestData data = JSONUtility.getTestMutilpleData();
	   List<RegisterUser> users = data.getValidUsers();
	   Object[][] obj = new Object[users.size()][1];
	   for (int i = 0; i < users.size(); i++) {
	       obj[i][0] = users.get(i);
	   }
	   return obj;
	}
}
