package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementActions;

public class ContactPageWPF extends BasePage
{
	// define locators
	ElementActions elementaction;
	By email=By.id("uid-ctrl-1");
	By firstname=By.id("uid-ctrl-2");
	By lastname=By.id("uid-ctrl-3");
	By jobtitle=By.id("uid-ctrl-5");
	By createContactFirstBtn=By.xpath("//span[text()='Create contact']");
    By createContactSecondBtn=By.xpath("//li//span[text()='Create contact']");
    
    public ContactPageWPF(WebDriver driver)
    {
    	this.driver=driver;  // import basepage
    	elementaction=new ElementActions(driver);
    }
    
    public void createNewContact(String EmailVal,String Firstname,String Lastname,String Jobtitle)
    {   
    	//elementaction.waitElementTobeClickable(createContactFirstBtn);
    	elementaction.ElementClick(createContactFirstBtn);
    	
    	//elementAction.waitForElementPresent(email);
    	elementaction.ElementSendKeys(email, EmailVal);
    	
    //	elementAction.waitForElementPresent(firstname);
    	elementaction.ElementSendKeys(firstname, Firstname);
    	
    	//elementAction.waitForElementPresent(lastname);
    	elementaction.ElementSendKeys(lastname, Lastname);
    	
    	//elementAction.waitForElementPresent(jobtitle);
    	elementaction.ElementSendKeys(jobtitle, Jobtitle);
    	
    	
    	elementaction.ElementClick(createContactSecondBtn);
    }
    
    
}
