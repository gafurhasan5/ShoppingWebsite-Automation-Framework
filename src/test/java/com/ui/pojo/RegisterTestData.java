package com.ui.pojo;

import java.util.List;

// this is wrapper class 
public class RegisterTestData {
	private RegisterUser validUser;
	   private RegisterUser existingUser;
	   public RegisterUser getValidUser() { return validUser; }
	   public RegisterUser getExistingUser() { return existingUser;}
	   
	   //for maltiple data Test
	   private List<RegisterUser> validUsers;
	   private List<RegisterUser> existingUsers;
	   private List<RegisterUser> invalidUsers;
	   
	   public List<RegisterUser> getValidUsers() {
		   return validUsers;
	   }
	   public List<RegisterUser> getExistingUsers() {
		   return existingUsers;
	   }
	   public List<RegisterUser> getInvalidUsers() {
		   return invalidUsers;
	   }
	   
}
