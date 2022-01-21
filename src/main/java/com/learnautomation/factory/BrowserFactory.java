package com.learnautomation.factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.learnautomation.dataproviders.ConfigUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	
	public static WebDriver startBrowser(String browserName)
	{
		WebDriver driver=null;
		
		if(browserName.equalsIgnoreCase("Chrome")||browserName.equalsIgnoreCase("Google Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("Firefox")||browserName.equalsIgnoreCase("FF"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("Edge")||browserName.equalsIgnoreCase("Microsoft Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("ChromeHeadless")||browserName.equalsIgnoreCase("Google Chrome Headless"))
		{
			System.out.println("Running inChromeHeadless");
			ChromeOptions opt=new ChromeOptions();
			opt.setHeadless(true);
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(opt);
		}
			
			
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		return driver;
	}
		
	public static WebDriver startBrowser(String osName, String osVersion,String browserName,String browserVersion)
		{
		WebDriver driver=null;
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("os", "osName");
		caps.setCapability("os_version", "osVersion");
		caps.setCapability("browser", "browserName");
		caps.setCapability("browser_version", "browserVersion");
		
		
		 String finalURL = "https://" + ConfigUtility.getValue("USERNAME") + ":" + ConfigUtility.getValue("AUTOMATE_KEY") + "@hub-cloud.browserstack.com/wd/hub";
		
		
	    URL hubURL = null;
		try {
			hubURL = new URL(finalURL);
		} catch (MalformedURLException e) {
			System.out.println(" URL is not formetted properly" +e.getMessage());
			
		}   
	    driver =new RemoteWebDriver(hubURL, caps);
			
			return driver;
		}
	
	public static WebDriver startBrowser(String osVersion,String deviceName, String realDevice)
	{
		
		WebDriver driver=null;
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os_version", osVersion);
		caps.setCapability("device", deviceName);
		caps.setCapability("real_mobile", realDevice);
String finalURL = "https://" + ConfigUtility.getValue("USERNAME") + ":" + ConfigUtility.getValue("AUTOMATE_KEY") + "@hub-cloud.browserstack.com/wd/hub";
		
		
	    URL hubURL = null;
		try {
			hubURL = new URL(finalURL);
		} catch (MalformedURLException e) {
			System.out.println(" URL is not formetted properly" +e.getMessage());
			
		}   
	    driver =new RemoteWebDriver(hubURL, caps);
			
			return driver;
	}
	}


