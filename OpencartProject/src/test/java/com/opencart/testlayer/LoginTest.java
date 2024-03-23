package com.opencart.testlayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.testbase.Testbase;

public class LoginTest extends Testbase {

	@Test
	public void verifyLoginTestWithValidDetails() throws IOException
	{
		String exppected_result = "My Account";
		
		homepage_obj.clickOnMyAccounntLink();
		homepage_obj.clickOnLoginLink();
		logger.info("on login page");
		
		loginpage_obj.enterEmail(excel_obj.readData("LoginData", 1, 1));
		loginpage_obj.enterPassword(excel_obj.readData("LoginData", 1, 2));
		loginpage_obj.clickOnLoginButton();
		logger.info("login details entered");
		
		String actual_result = driver.getTitle();
		System.out.println(actual_result);
		Assert.assertEquals(actual_result, exppected_result);
	}
	
	@Test
	public void verifyLoginTestWithInValidDetails()
	{
		String exppected_result = "Warning: No match for E-Mail Address and/or Password.";
		
		homepage_obj.clickOnMyAccounntLink();
		homepage_obj.clickOnLoginLink();
		logger.info("on login page");
		
		loginpage_obj.enterEmail("davidtest14@gmail.com");
		loginpage_obj.enterPassword("Test");
		loginpage_obj.clickOnLoginButton();
		logger.info("login details entered");
		
		String actual_result = common_obj.getErrorMessage();
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, exppected_result);
	}
}
