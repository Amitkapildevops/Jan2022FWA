package com.learnautomation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.learnautomation.dataproviders.ConfigUtility;
import com.learnautomation.factory.BrowserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseClass {
	
	public WebDriver driver;
	
	public WebDriver getDriver()
	{
		return driver;
	}
	@BeforeClass
	public void setup()
	
	{
		//driver=BrowserFactory.startBrowser("Chrome");		
		
		driver=BrowserFactory.startBrowser(ConfigUtility.getValue("browser"));
		//driver.get("https://opensource-demo.orangehrmlive.com");
		driver.get(ConfigUtility.getValue("url"));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
