package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;

public class ElementActions extends BasePage
{
	public ElementActions(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public WebElement getElement(By locator) 
	{ 
		WebElement element=null;
		try
	  {
		element=driver.findElement(locator);
		
	  }
	  catch(Exception e)
	  {
		System.out.println("some exception occured while creating WebElement"+locator);
	  }
		return element;
	}
	
	
	public void waitForElementPresent(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	public void waitForTitlePresent(String Title)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains(Title));
		
	}
	public void waitElementTobeClickable(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	
	public boolean ElementIsDisplayed(By locator)
	{
		waitForElementPresent(locator);
		return getElement(locator).isDisplayed();
	}
	
	public void ElementClick(By locator)
	{   waitElementTobeClickable(locator);
		getElement(locator).click();
	}
	public void ElementSendKeys(By locator,String value)
	{   waitForElementPresent(locator);
	    waitElementTobeClickable(locator);
		getElement(locator).sendKeys(value);
	}
	public String ElementText(By locator)
	{   waitForElementPresent(locator);
		return getElement(locator).getText();
	}
	public String getPageTitle()
	{  
		String title=null;
		try
	  {
		title=driver.getTitle();
	  }
	catch(Exception e)
	{
		System.out.println("some exception occured while gettile title");
	}
	return title;
	}
}
