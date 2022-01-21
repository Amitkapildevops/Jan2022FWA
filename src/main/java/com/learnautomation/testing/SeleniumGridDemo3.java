package com.learnautomation.testing;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridDemo3 {

		// TODO Auto-generated method stub
		
		
		@Test
		public void testOnWin11ChromeLatest() throws MalformedURLException
		{
			
			
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os_version", "14");
			caps.setCapability("device", "iPhone 12");
			caps.setCapability("real_mobile", "true");
			// caps.setCapability("browserstack.local", "false"); if application need proxy
			
			 String USERNAME = "amitsharma_F5VhYk";
			 String AUTOMATE_KEY = "K71xe5wx7jhFMCGE7va8";
			 String finalURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
			
			
		    URL hubURL =new URL(finalURL);   
		    
			
			WebDriver driver =new RemoteWebDriver(hubURL, caps);
           driver.get("https://www.google.com");
           driver.findElement(By.name("q")).sendKeys("Selenium Grid");
			driver.quit();
			
			
		}

	}

	

