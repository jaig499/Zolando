package org.zalan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jai\\eclipse-workspace\\ZalandoAuto\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://en.zalando.de/men-home/");
		Thread.sleep(5000);
	}
	
	public static String dataDriven(int row,int cell) throws IOException {
		
		File file=new File("C:\\Users\\Jai\\eclipse-workspace\\ZalandoAuto\\file\\Zalando.xlsx");
		FileInputStream finput=new FileInputStream(file);
		Workbook book=new XSSFWorkbook(finput);
		Sheet sheet = book.getSheet("Sheet1");
		Row row2 = sheet.getRow(row);
		Cell cell2 = row2.getCell(cell);
		String value = cell2.getStringCellValue();
	
		return value;
		
	}
	
	public static void fill(WebElement ele,String text) {
		ele.sendKeys(text);
	}
	
	public static void click(WebElement ele) {
		ele.click();
	}
	
	
	
	
}
