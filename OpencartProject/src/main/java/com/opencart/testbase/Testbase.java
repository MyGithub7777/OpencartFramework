package com.opencart.testbase;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.opencart.pagelayer.Homepage;
import com.opencart.pagelayer.Loginpage;
import com.opencart.pagelayer.Registerpage;
import com.opencart.utility.CommonComp;
import com.opencart.utility.ExcelUtils;

public class Testbase {

	public static WebDriver driver;
	public static Logger logger;
	
	public Homepage homepage_obj;
	public Registerpage registerpage_obj;
	public Loginpage loginpage_obj;
	public CommonComp common_obj;
	public ExcelUtils excel_obj;
	
	@BeforeTest
	public void start()
	{
		logger = Logger.getLogger("** Opencart Framework **");
		PropertyConfigurator.configure("logfile.properties");
		
		logger.info("------------- Framework Execution Started -------------------");
	}
	
	@AfterTest
	public void end()
	{
		logger.info("------------- Framework Execution Ended ---------------------");
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		String browser_name = "FIREFOX";
		
		if(browser_name.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser_name.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser_name.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Enter valid bwoser name");
		}
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
		logger.info("Browser launed with url");
		
		//---------- Object creation --------------- 
		homepage_obj = new Homepage(driver);
		registerpage_obj = new Registerpage(driver);
		loginpage_obj = new Loginpage(driver);
		common_obj = new CommonComp(driver);
		excel_obj = new ExcelUtils();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		logger.info("Browser closed");
	}
}
