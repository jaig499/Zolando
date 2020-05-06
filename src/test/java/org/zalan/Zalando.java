package org.zalan;

import java.util.List;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.DateUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Zalando extends BaseClass {
	
	public static WebDriver driver;
	
	@BeforeClass
	private void open() throws InterruptedException {
		openBrowser();
	}
	
	@Test
	public void getNewLook() throws InterruptedException {
		
		Actions a=new Actions(driver);
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("uc-btn-accept-banner")).click();
		driver.findElement(By.xpath("//body[@class=' is-uc ']")).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("(//a[@href='/get-the-look-men/'])[2]"));
		a.moveToElement(ele).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Wide Fit Trousers ']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//img[@alt='CLOVER PANT LANE - Trousers - ruby pink rinsed']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//span[@class='A95iT1 pDVUjz nmA88J NNECXo AHAcbe x--xNS BQJRnm uijqg- _1-FnuQ HWFFx9 U7GfHW g9NA38'])[1]")).click();
		List<WebElement> listOfSize = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		System.out.println(listOfSize.size());
		String sizeIs = "true";
		for(WebElement eachVal : listOfSize) {
			System.out.println(eachVal.getText());
			String eVal = eachVal.getText();
			if(eachVal.getText().equals("XL")) {
				eachVal.click();
				SoftAssert sa=new SoftAssert();
				sa.assertEquals(eVal.equals("XL"), sizeIs, "Size Assert is passed");
				sa.assertAll();
				
			}
	}
 }
	
	@Test
	public void serch() throws IOException {
		
		POMClass obj=new POMClass();
		
		fill(obj.getTextInput(),dataDriven(0,0));
		driver.navigate().refresh();
		
		fill(obj.getTextInput(), dataDriven(1, 0));
		driver.navigate().refresh();
		
		fill(obj.getTextInput(), dataDriven(2, 0));
		driver.navigate().refresh();

	}
	
	@AfterClass
	public void close() {
		
		driver.close();
		
	}
	
}
