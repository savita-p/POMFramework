package com.qa.hubspot.tests;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.listeners.AllureReportListener;
import com.qa.hubspot.listeners.pdfListener;
import com.qa.hubspot.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
//@Listeners(pdfListener.class) 
@Listeners(AllureReportListener.class)
@Epic("Epic - Hub spot Login Page Module")
@Feature("US-101: Define the Login feature of the Hubspot Application")
public class LoginPageTest {
	
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginpage;
	
	@BeforeMethod
	public void setup()
	{
		basepage =new BasePage();
		prop=basepage.initialize_properties();
		driver=basepage.initialize_driver(prop);
		loginpage=new LoginPage(driver);
	}
	
	@Test(priority=1)
	@Description("test case name: verify login page title - positive test case")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLoginPageTitle()
	{
		String title=loginpage.getLoginPageTitle();
		System.out.println("Login page title is "+title);
		Assert.assertEquals(title, Constants.Login_Page_Title);
	}
	
	@Description("test case name: verify sign up link text - positive test case")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2)
	public void verifySignupLink()
	{ 
		Assert.assertTrue(loginpage.SignupLinkDisplayed());

    }
	
	@Description("test case name: verify login Page With CorrectCredentials- positive test case")
	@Severity(SeverityLevel.CRITICAL)
     @Test(priority=3)
    public void loginPageWithCorrectCredentials()
    {
     loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
     
    }
	
	@Description("test case name: verify login Page With inCorrectCredentials- negative test case")
	@Severity(SeverityLevel.NORMAL)
    @Test (priority=4)
    public void loginwithIncorrectCredentials()
    {
     loginpage.doLogin("test@ggg","tets2t2"); 
     }
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
