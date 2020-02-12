package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class ExcelUtil {

	public static String ExcelPath =Base.currentDir + "\\src\\main\\java\\Utilities\\"+Base.testDataExcelFileName;

	//@Test
	public static String ReadExcel(int Sheet, int Row ,int cell) throws IOException 
	{  
		String Data= null;
		try  
		{  
			File file = new File(ExcelPath);   //creating a new file instance  
			FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
			//creating Workbook instance that refers to .xlsx file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			Iterator<Row> itr = sheet.iterator();    //iterating over excel file  


			Data = wb.getSheetAt(Sheet).getRow(Row).getCell(cell).toString();  

		}  
		catch(Exception e)  
		{  
			e.printStackTrace();  
		} 
		return Data;

	}


}
