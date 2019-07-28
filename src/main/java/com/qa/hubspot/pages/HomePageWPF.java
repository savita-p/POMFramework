package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.TimeUtil;

public class HomePageWPF extends  BasePage
{
// define locators
	ElementActions elementaction;
	By PageHeader=By.xpath("//h1[@class='private-page__title']");
	By AccountName=By.xpath("//span[@class='account-name ']");
	By parentContactMenu=By.id("nav-primary-contacts-branch");
	By childContactMenu=By.id("nav-secondary-contacts");
	
	
	
	
	
	
	public HomePageWPF(WebDriver driver)
	{
		this.driver=driver;
		elementaction=new ElementActions(driver);
	}
	
	
	//page actions
	
		public String getHomePagetitle()
		{
			elementaction.waitForTitlePresent(Constants.Home_Page_Title);
			return elementaction.getPageTitle();
		}
		public boolean verifyPageheaderIsdisplyed()
		{
			return elementaction.ElementIsDisplayed(PageHeader);
		}
		
		public String getPageHeaderText()
		{
		  	return elementaction.ElementText(PageHeader);
		}
		public String getAccountNameText()
		{
		  	return elementaction.ElementText(AccountName);
		}
		public void clickonContactMenu()
		{   elementaction.waitForElementPresent(parentContactMenu);
			elementaction.ElementClick(parentContactMenu);
			TimeUtil.longWait();
			elementaction.waitForElementPresent(childContactMenu);
			elementaction.ElementClick(childContactMenu);
		}
		
		public ContactPageWPF gotoChildContactMenu()
		{
			clickonContactMenu();
			return new ContactPageWPF(driver);
			
		}
		
		
		
		
		
		
		
	
}
