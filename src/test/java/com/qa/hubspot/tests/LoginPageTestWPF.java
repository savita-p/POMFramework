package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.LoginPageWPF;

public class LoginPageTestWPF 
{
	
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPageWPF loginpage;
	
	@BeforeMethod
	public void setup()
	{
		basepage =new BasePage();
		prop=basepage.initialize_properties();
		driver=basepage.initialize_driver(prop);
		loginpage=new LoginPageWPF(driver);
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitle()
	{
		String title=loginpage.getLoginPagetitle();
		Assert.assertEquals(title, Constants.Login_Page_Title);
	  
	}
	
	@Test(priority=2)
	public void verifySignupLinkText()
	{ 
		 Assert.assertTrue(loginpage.verifySignupLinkDisplayed());
    }
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
