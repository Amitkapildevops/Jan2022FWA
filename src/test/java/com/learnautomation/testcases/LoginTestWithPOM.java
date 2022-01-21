package com.learnautomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataproviders.CustomDataProvider;
import com.learnautomation.dataproviders.ExcelUtilityWithHeader;
import com.learnautomation.pages.LoginPage;

public class LoginTestWithPOM extends BaseClass {
	
		
	@Test(dataProvider="Login",dataProviderClass= CustomDataProvider.class)
	public void login(String uname, String pass)
	{
	
		LoginPage login=new LoginPage(driver);
		/*login.enterUserName(uname);
		login.enterPassword(pass);
		login.clickOnLoginButton();*/
		
		login.loginAsAdmin(uname, pass);
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "URL pattern not match");
		
				
	}
	
	
	
	

}
