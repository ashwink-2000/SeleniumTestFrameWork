package org.ash.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ash.exceptions.FrameworkException;
import com.ash.exceptions.InvalidPathForExcelFileException;

public final class ExcelUtility {

	private ExcelUtility()
	{
		
	}
	
	static Workbook workbook;
	static Sheet sheet;
	public static  List<Map<String,String>> getData(String excelFileName,String SheetName)
	{
		List<Map<String,String>> list= null;
		try(FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/TestDetails.xlsx")){
			workbook = new XSSFWorkbook(fis);
			sheet= workbook.getSheet(SheetName);
			int noOfRow=sheet.getLastRowNum();
			int noOfCol=sheet.getRow(0).getLastCellNum();
			
			list = new ArrayList<Map<String,String>>();
			Map<String,String> map=null;
			
			for(int i=1;i<=noOfRow;i++)
			{
				map= new HashMap<>();
				for(int j=0;j<noOfCol;j++)
				{
					map.put(sheet.getRow(0).getCell(j).getStringCellValue(),sheet.getRow(i).getCell(j).getStringCellValue());
				}
				list.add(map);
			}
		}catch (FileNotFoundException e) {
			throw new InvalidPathForExcelFileException("File is not found on the specified path");
		}
		catch (IOException e) {
			throw new FrameworkException("Unable to read Excel file");
		}
		
		return list;
	}
}
