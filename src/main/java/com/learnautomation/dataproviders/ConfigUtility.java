package com.learnautomation.dataproviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {
	
	static Properties pro;
	
	public static String getValue(String key)
	{
		createInstanse();	
		return pro.getProperty(key);
	}
	
	public static void createInstanse()
	{
	
		if(pro==null)
		{
			System.out.println("Creating new session for property file");
			pro=new Properties();
			try {
				pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Config/Config.properties")));
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		else 
		{
			System.out.println("Existing properties object found resung the same");
		}
		
	}

}
