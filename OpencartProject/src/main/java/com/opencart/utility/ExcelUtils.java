package com.opencart.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	String path = "D:\\Workspace\\16Decworkspace\\OpencartProject16Dec\\resources\\TestData.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	
	public ExcelUtils() throws IOException
	{
		file = new File(path);		
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
	}
	
	public String readData(String sheet_name, int row_num, int cell_num)
	{	
		XSSFSheet sheet = wb.getSheet(sheet_name);
		XSSFCell cell = sheet.getRow(row_num).getCell(cell_num);
		
		DataFormatter df = new DataFormatter();
		String data = df.formatCellValue(cell);
		return data;
	}
	
	public void writeData(String sheet_name,int row_num,int cell_num,String data) throws IOException
	{
		XSSFSheet sheet = wb.getSheet(sheet_name);
		sheet.getRow(row_num).createCell(cell_num).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
	}
	
	public int getRowCount(String sheet_name) throws IOException
	{
		XSSFSheet sheet = wb.getSheet(sheet_name);
		int row_count = sheet.getLastRowNum();
		return row_count;
	}
	
	public int getCellCount(String sheet_name,int row_num) throws IOException
	{
		XSSFSheet sheet = wb.getSheet(sheet_name);
		int cell_count = sheet.getRow(row_num).getLastCellNum();
		return cell_count;
	}
}
