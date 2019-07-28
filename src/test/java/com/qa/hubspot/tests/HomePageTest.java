package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest
{
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	BasePage basepage;
	
	@BeforeMethod
	public void setup()
	{
		basepage=new BasePage();
		prop=basepage.initialize_properties();
		driver=basepage.initialize_driver(prop);
		loginpage=new LoginPage(driver);
		homepage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void VerifyHomePageTitle()
	{
		String title=homepage.getHomePageTitle();
		System.out.println("Home page title is "+title);
		Assert.assertEquals(title,Constants.Home_Page_Title);
	}
	@Test(priority=2)
	public void VerifyHomePageHeader()
	{
		Assert.assertTrue(homepage.verfiyHomePageHeader());
		Assert.assertEquals(homepage.verifyHomePageHeaderText(), Constants.Home_Page_Header);
	}
	
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}

}
