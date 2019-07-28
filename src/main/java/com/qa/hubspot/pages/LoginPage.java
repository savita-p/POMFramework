package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.TimeUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage
{
	// 1. create page factory
	@FindBy(id="username")
	WebElement emailid;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginbutton;
	
	@FindBy(linkText="Sign up")
	WebElement signup;
	
	
	
	//2 create constructor of login page
	public LoginPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	//3 Page actions
	@Step("getting login page title and returning the page title step....")
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	@Step("verfying sign up link is displayed step....")
	public boolean SignupLinkDisplayed()
	{
		return signup.isDisplayed();
	}
	
	@Step("Login with : {0} and {1}")
	public HomePage doLogin(String username,String pwd)
	{
		System.out.println("credentials: "+username + "/" + pwd);
		emailid.sendKeys(username);
		password.sendKeys(pwd);
		loginbutton.click();
		TimeUtil.longWait();
		return new HomePage(driver);
	}
	
		
}
