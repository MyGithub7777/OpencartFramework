package com.opencart.testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.testbase.Testbase;

public class RegisterTest extends Testbase {

	@Test
	public void validateRegisteringAccountByProvidingValidAccountdetails()
	{
		String expected_result = "Your Account Has Been Created!";
		
		homepage_obj.clickOnMyAccounntLink();
		homepage_obj.clickOnRegisterLink();
		logger.info("on register page");
		
		int row = 5;
		
		registerpage_obj.enterFirstName(excel_obj.readData("RegisterData", row, 1));
		registerpage_obj.enterLastName(excel_obj.readData("RegisterData", row, 2));
		registerpage_obj.enterEmail(excel_obj.readData("RegisterData", row, 3));
		registerpage_obj.entertelephone(excel_obj.readData("RegisterData", row, 4));
		registerpage_obj.enterPassword(excel_obj.readData("RegisterData", row, 5));
		registerpage_obj.enterConfirmPassword(excel_obj.readData("RegisterData", row, 6));
		registerpage_obj.clickOnPrivacyPolicyCheckbox();
		registerpage_obj.clickOnContinueButton();
		logger.info("account details entered");
		
		String actual_result = driver.getTitle();
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void validateRegisteringAccountByProvidingExistingAccountdetails()
	{
		String expected_result = "Warning: E-Mail Address is already registered!";

		homepage_obj.clickOnMyAccounntLink();
		homepage_obj.clickOnRegisterLink();
		logger.info("on register page");
		registerpage_obj.enterFirstName("david");
		registerpage_obj.enterLastName("test13");
		registerpage_obj.enterEmail("davidtest13@gmail.com");
		registerpage_obj.entertelephone("665558658985");
		registerpage_obj.enterPassword("Test@1234");
		registerpage_obj.enterConfirmPassword("Test@1234");
		registerpage_obj.clickOnPrivacyPolicyCheckbox();
		registerpage_obj.clickOnContinueButton();
		logger.info("account details entered");
		String actual_result = common_obj.getErrorMessage();
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, expected_result);
	}
}
