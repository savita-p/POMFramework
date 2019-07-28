package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.HomePageWPF;
import com.qa.hubspot.pages.LoginPageWPF;

public class HomePageTestWPF 
{
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPageWPF loginpage;
	HomePageWPF homepage ;
	@BeforeMethod
	public void setup()
	{
		basepage =new BasePage();
		prop=basepage.initialize_properties();
		driver=basepage.initialize_driver(prop);
		loginpage=new LoginPageWPF(driver);
		homepage=loginpage.Dologin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle()
	{
		String title=homepage.getHomePagetitle();
		System.out.println("home page title is "+title);
		Assert.assertEquals(title, Constants.Home_Page_Title);
	  
	}
	
	@Test(priority=2)
	public void verifyHomePageHeader()
	{ 
		 Assert.assertTrue(homepage.verifyPageheaderIsdisplyed());
    }
	@Test(priority=3)
	public void verifyHomePageHeaderText()
	{ 
		 Assert.assertEquals(homepage.getPageHeaderText(),Constants.Home_Page_Header);
    }
	@Test(priority=4)
	public void verifyHomePageAccountName()
	{ 
		 Assert.assertEquals(homepage.getAccountNameText(),"NaveenAutomationLabs");
    }
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
