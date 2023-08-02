package com.TestLayer;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BaseLaye.BaseClass;
import com.PageLayer.UserRegisterPage;
import com.UtilsLayer.RetryAnalyzer;

public class UserRegisterPageTest extends BaseClass{

//	before test setup
//	create test cases
//	after test setup
	
	@BeforeTest
	public void setup() {
		initialize();
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateUserRegistration() {
		UserRegisterPage userReg = new UserRegisterPage();
		userReg.registerPageFunctionlity("CPV Delhi", "Pune", "Hardik",
				"Pandey", "2000", "Aug","10" ,"Hardik@gmail.com", "no", "Hardik001",
				"Hardik@123", "Hardik@123", "Birth City", "Mumbai");
	}
	
	@AfterTest
	public void tearDown() {
		
	}
	
}
