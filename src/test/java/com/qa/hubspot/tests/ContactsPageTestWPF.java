package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactPageWPF;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.HomePageWPF;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.LoginPageWPF;
import com.qa.hubspot.util.ExcelUtil;

public class ContactsPageTestWPF 
{
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	HomePageWPF homepage;
	LoginPageWPF loginpage;
	ContactPageWPF contactspage;
	ExcelUtil excelutil;
	@BeforeMethod
	public void setup()
	{
	    basepage =new BasePage();
		prop=basepage.initialize_properties();
		driver=basepage.initialize_driver(prop);
		loginpage=new LoginPageWPF(driver);
		homepage=loginpage.Dologin(prop.getProperty("username"), prop.getProperty("password"));
		contactspage=homepage.gotoChildContactMenu();
		
		
	}
	@DataProvider(name="getContactsData")
	public Object[][] getContactsTestData()
	{
		Object contactsdata[][]=excelutil.getTestData("Contacts");
		return contactsdata;
		
	}
	
	
	@Test(dataProvider="getContactsData")
	public void createNewContacts(String Email,String FirstName,String LastName,String JobTitle)
	{
		contactspage.createNewContact(Email,FirstName,LastName,JobTitle);
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}

}
