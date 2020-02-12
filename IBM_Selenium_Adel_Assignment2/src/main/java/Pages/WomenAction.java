package Pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Base;
import Utilities.ExcelUtil;

public class WomenAction {



	public static void GetWomenDresses()  throws IOException
	{
		Base.ScrolltoElement(Womenpage.WomenTap(Base.driver),Base.driver);
		Base.MouseOver(Womenpage.WomenTap(Base.driver),Base.driver);
		Womenpage.DressesButton(Base.driver).click();
		Base.driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;  

		Base.DisplayList(Womenpage.WomenDressesList(Base.driver),"Women Dresses");
		Womenpage.elementlist=null;


	}

	
	
	public static void GetdiscountDresses( List<WebElement> listDiscound) throws IOException 
	{
	
		WebElement AddtoCardButton;
		WebElement Continue_shopping ;
		System.out.println("***************************************************");


		for(int i=0; i<listDiscound.size(); i++){

			Base.ScrolltoElement(listDiscound.get(i),Base.driver);

			System.out.println(listDiscound.get(i).findElement(By.xpath("../../h5")).getText());			
			System.out.println("Old Price :"+listDiscound.get(i).findElement(By.xpath("../span[2]")).getText());
			System.out.println("Discound Percentage  :"+listDiscound.get(i).getText());
			System.out.println("New Price :"+listDiscound.get(i).findElement(By.xpath("../span[1]")).getText());
			System.out.println("....................................................");
			
			Base.ItemAdd.add(listDiscound.get(i).findElement(By.xpath("../../h5")).getText());
			
			double newPrice = CardAction.GetPrice(listDiscound.get(i).findElement(By.xpath("../span[1]"))) ;
			Base.TotalPrice = Base.TotalPrice + newPrice;
			Base.MouseOver(listDiscound.get(i),Base.driver);


			AddtoCardButton=listDiscound.get(i).findElement(By.xpath("../../div[@class='button-container']/a[1]"));

			AddtoCardButton.click();

			Continue_shopping = (new WebDriverWait(Base.driver, 10))			
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[title='Continue shopping']")));
			Continue_shopping.click();
			Base.ItemNum++;
		}

		System.out.println("***************************************************");

	}	



}
