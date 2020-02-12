package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Base;
import Utilities.ExcelUtil;

public class CardPage {
	 private static WebElement element = null;
	 private static List<WebElement> elementlist=null;

	
	
	
		public static WebElement AddCardButton (WebDriver driver) throws IOException{
			return element = driver.findElement(By.xpath(ExcelUtil.ReadExcel(0,19, 1)));
		}
		public static WebElement ProceedCheckOut1 (WebDriver driver) throws IOException{
			return element = driver.findElement(By.xpath(ExcelUtil.ReadExcel(0,20, 1)));
		}
	
		
		public static WebElement EmailCreate (WebDriver driver) throws IOException{
			return element = driver.findElement(By.id(ExcelUtil.ReadExcel(0,21, 1)));
		}
		
		
		public static WebElement CardTotalPrice (WebDriver driver) throws IOException{
			return element = Base.driver.findElement(By.id("total_price"));
		}
	
		public static WebElement TotalShipping (WebDriver driver) throws IOException{
			return element = Base.driver.findElement(By.id("total_shipping"));
		}
		
		

		public static List<WebElement> CardListName(WebDriver driver) throws IOException{
			 return elementlist = driver.findElements(By.xpath("//td/p[@class='product-name']/a"));
				}		
	
		
	/*
	 * public static WebElement EmailCreate (WebDriver driver) throws IOException{
	 * return element = driver.findElement(By.id(ExcelUtil.ReadExcel(0,21, 1))); }
	 */
		
}
