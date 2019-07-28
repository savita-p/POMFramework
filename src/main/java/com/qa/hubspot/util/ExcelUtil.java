package com.qa.hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.SheetUtil;

public class ExcelUtil 
{
	public static Workbook book;
	public static org.apache.poi.ss.usermodel.Sheet Sheet;
	
	public static String TestData_Sheet_Path="C:\\Users\\mailp\\eclipse-workspace\\POM_Project\\src\\main\\java\\com\\qa\\hubspot\\testdata\\TestData.xlsx";
	
	public static Object[][] getTestData(String Sheetname)
	{
		FileInputStream file=null;
		
		try {
			file=new FileInputStream(TestData_Sheet_Path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		try {
			book=WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Sheet=book.getSheet(Sheetname);
		
		System.out.println(Sheet.getLastRowNum());
		System.out.println(Sheet.getRow(0).getLastCellNum());
	
		Object data[][]=new Object[Sheet.getLastRowNum()][Sheet.getRow(0).getLastCellNum()];
		
		
		for(int i=0;i<Sheet.getLastRowNum();i++) {
			for(int k=0;k<Sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]= Sheet.getRow(i+1).getCell(k).toString();
				
			}
			
			
			
			
	  }
		return data;
			
			
		
		
	}
	
}
