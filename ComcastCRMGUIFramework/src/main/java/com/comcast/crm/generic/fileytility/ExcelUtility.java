package com.comcast.crm.generic.fileytility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String Sheetname,int Rownum, int cellnum) throws EncryptedDocumentException, IOException
	
	{
		FileInputStream fis= new FileInputStream("./TestData/testScriptData.xlsx");
		Workbook wb=  WorkbookFactory.create(fis);
		String data = wb.getSheet(Sheetname).getRow(Rownum).getCell(cellnum).getStringCellValue().toString();
		wb.close();
		return data;
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream("./TestData/testScriptData.xlsx");
		Workbook wb=  WorkbookFactory.create(fis);
		int rowNum= wb.getSheet(sheetName).getLastRowNum();

		wb.close();
		return rowNum;
	
		
		
	}
	
	public void setDataIntoExcel(String Sheetname,int Rownum, int cellnum, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream("./TestData/testScriptData.xlsx");
		Workbook wb=  WorkbookFactory.create(fis);
		wb.getSheet(Sheetname).getRow(Rownum).createCell(cellnum).setCellValue(data);
		
		FileOutputStream fos= new FileOutputStream("./TestData/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
		
		
	}
	{
		
	}

	

}
