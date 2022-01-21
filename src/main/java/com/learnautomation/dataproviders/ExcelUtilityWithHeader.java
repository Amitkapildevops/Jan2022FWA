package com.learnautomation.dataproviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityWithHeader {
static XSSFWorkbook wb;
	
	public static Object[][] getDataFromSheet(String sheetName)
	{
		Object arr[][] = null;
		try {
			wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/OrangeHRMdata.xlsx")));
			int row= getRows(sheetName);
			int column=getColumn(sheetName);
			
			arr=new Object[row-1][column];
			
			for(int i=1;i<row;i++)
			{
				for (int j=0;j<column;j++)
					
				{
					arr[i-1][j]=getData(sheetName, i, j);
				}
				
			}
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		
		
		
		return arr;
		
		
	}
	
	public static int getRows(String sheetName)
	{
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}
	
	public static  int getColumn(String sheetName)
	{
		return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	}
		
	public static String getData(String sheetName, int row, int column)
	{
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(column);
		String data=" " ;
		//CellType c=cell.getCellType();Cell Type is enum
		
		if(cell.getCellType()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		} 
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			//data=cell.getNumericCellValue(); get numric value in double
			
			data=String.valueOf(cell.getNumericCellValue());
		}
	
		else if(cell.getCellType()==CellType.BLANK)
		{
			data=" ";
		}
		return data;
	}
	

}

