package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.qa.hubspot.util.TimeUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage
{
	public WebDriver driver;
	public Properties prop;
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	
	public WebDriver initialize_driver(Properties prop)
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver()
			tldriver.set(new ChromeDriver());
		}
		else
		if(browsername.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			tldriver.set(new FirefoxDriver());
		}
		else
		if(browsername.equals("Opera"))
		{
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}else

		{
			System.out.println(browsername+" "+"not defined in properties file, please give correct browser name");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		TimeUtil.longWait();
		return getDriver();
		
	}
	public static synchronized WebDriver getDriver()
	{
		return tldriver.get();
	}
	
	public Properties initialize_properties()
	{
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\mailp\\eclipse-workspace\\POM_Project\\src\\main\\java\\com\\qa\\hubspot\\configuration\\config.properties");
		   try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return prop;
		
	}
	
	/**
	 * take screenshot
	 */
	  public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}

	
	

}
