package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.util.ElementActions;


public class LoginPageWPF extends BasePage
{
	ElementActions elementaction;
	// define locators
	By emailid=By.id("username");
	By password=By.id("password");
	By loginbtn=By.id("loginBtn");
	By signuplink=By.linkText("Sign up");
	
	public LoginPageWPF(WebDriver driver)
	{
		this.driver=driver;
	  elementaction=new ElementActions(driver);
	}
	
	//page actions
	
	public String getLoginPagetitle()
	{
		elementaction.waitForTitlePresent(Constants.Login_Page_Title);
		return elementaction.getPageTitle();
	}
	
	public boolean verifySignupLinkDisplayed()
	{
	  	
	  return elementaction.ElementIsDisplayed(signuplink);
	    
	}
	public String verifySignupLinkText()
	{
	  	return elementaction.ElementText(signuplink);
	 
	    
	}
	
	public HomePageWPF Dologin(String username,String pwd)
	{
		elementaction.ElementSendKeys(emailid, username);
		elementaction.ElementSendKeys(password, pwd);
		elementaction.ElementClick(loginbtn);
		return new HomePageWPF(driver);
	}
	
	
	
	
	
	
	
	

}
