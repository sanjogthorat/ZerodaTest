package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

public class Utility {
	private  WebDriver driver ;

	public static void  captureScreenshot(WebDriver driver , int testId) throws IOException
	{
		SimpleDateFormat date = new SimpleDateFormat("MM-dd-yy_hh-mm-ss");
		Date systemdate = new Date();
		String m = date.format(systemdate);
		TakesScreenshot take = (TakesScreenshot)driver;
		File source = take.getScreenshotAs(OutputType.FILE);
		File destination = new File("test-output\\Failed Screenshots\\Test"+testId+" "+m+".jpg");
		FileHandler.copy(source, destination);
	}
	
	public static String fetchDataFromExcelSheet(String Sheet , int Row , int Cell) throws IOException 
	{
		FileInputStream file = new FileInputStream("src\\test\\resources\\Excel Sheet\\Test.xlsx");
		Cell cell = WorkbookFactory.create(file).getSheet("Sanjog Info").getRow(Row).getCell(Cell);
		try {
		String value = cell.getStringCellValue();
		return value;
		}
		catch(IllegalStateException e) {
		long value1 = (long)cell.getNumericCellValue();
		String str = String.valueOf(value1);
		System.out.println(str);
		return str;
			
		}
	}
}
