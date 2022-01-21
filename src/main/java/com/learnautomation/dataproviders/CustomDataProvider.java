package com.learnautomation.dataproviders;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
	
	@DataProvider(name="Login")
	public static Object[][] getLoginData()
	{
		return ExcelUtilityWithHeader.getDataFromSheet("User");
	}
	
	@DataProvider(name="UserSheet")
	public static Object[][] getUserData()
	{
		
		return ExcelUtilityWithHeader.getDataFromSheet("UserSheet");
		 
		
	}

}
