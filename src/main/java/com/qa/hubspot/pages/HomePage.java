package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.TimeUtil;

public class HomePage extends BasePage 
{
	// 1. create page factory
	@FindBy(xpath="//h1[@class='private-page__title']")
	WebElement homePageheader;
	
	@FindBy(xpath="//span[@class='account-name']")
	WebElement accountName;
	
	@FindBy(id="nav-primary-contacts-branch")
	WebElement parentContactMenu;
	
	
	@FindBy(id="nav-secondary-contacts")
	WebElement childContactMenu;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	
	// page actions
	public String getHomePageTitle()
	{
		return driver.getTitle();
		
	}
	
	public String getAccountNameText()
	{
		return accountName.getText();
		
	}
	
	public boolean verfiyHomePageHeader()
	{
		return homePageheader.isDisplayed();
		
	}
	
	public String verifyHomePageHeaderText()
	{
		return homePageheader.getText();
		
	}
	
	public void clickOnContactsMenu()
	{
		parentContactMenu.click();
		TimeUtil.mediumWait();
		childContactMenu.click();
	}
	
	public ContactsPage gotoContactsPage()
	{
		clickOnContactsMenu();
		return new ContactsPage(driver);
	}
	
	

}
