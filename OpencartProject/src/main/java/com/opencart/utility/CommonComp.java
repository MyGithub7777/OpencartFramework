package com.opencart.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonComp {

	private WebDriver driver;
	public CommonComp(WebDriver d)
	{
		driver = d;
	}
	
	private By error_msg = By.xpath("//div[contains(@class,'alert-danger')]");
	
	public String getErrorMessage()
	{
		String error = driver.findElement(error_msg).getText();
		return error;
	}
}
