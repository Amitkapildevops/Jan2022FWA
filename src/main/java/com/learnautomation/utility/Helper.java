package com.learnautomation.utility;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	

	//, dropdown,,
	/*dynamic waits
	 * Action class
	 * dropdown
	 * screenshots
	 * JS executor
	 * SwitchToCommands
	 * WebElements
	 * broken links
	 * broken images
	 * which is repetable 
	 * 
	*/
	
	public static void wait(int seconds)
	{
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static WebElement waitForWebElement(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(locator));//should visible and enable
		return ele;
		
	}
	
	public static String captureScreenshot (WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String image= ts.getScreenshotAs(OutputType.BASE64);
		System.out.println("Base64 data is " +image);
		return image;
		
	}
	
	public static String getCurrentDateTime()
	{
		Date d=new Date();
		SimpleDateFormat dateformat=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		
		return dateformat.format(d);
	}
	
	
	
	
	
	
	
	
	

}
