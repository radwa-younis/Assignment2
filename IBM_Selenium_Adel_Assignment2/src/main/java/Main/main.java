package Main;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Base;

public class main {

	static WebDriver driver=null;

	public   static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver","Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//...........................
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;  

		//Poplarprice............................................................
		List<WebElement> List_name_elements=driver.findElements(By.xpath(
				"//ul[@id='homefeatured']/li/div/div[2]/h5"));

		List<WebElement> PoplarpriceList=driver.findElements(By.xpath(
				"//ul[@id='homefeatured']/li/div/div[2]/div[1]/span[1]"));

		Base.DisplayList(List_name_elements,"Poplar List Dresses");
		GetLessPrice(PoplarpriceList);

		//BestSellers............................................................

		WebElement BestsellersButton=driver.findElement(By.cssSelector("a.blockbestsellers"));
		BestsellersButton.click();

		System.out.println(); 
		List<WebElement>BestsalerNameList=driver.findElements(By.xpath("//ul[@id='blockbestsellers']/li/div/div[2]/h5/a"));
		List<WebElement>BestsalerpriceList=driver.findElements(By.xpath("//ul[@id='blockbestsellers']/li/div/div[2]/div[1]/span[1]"));

		Base.DisplayList(BestsalerNameList,"Best sellers Dresses");
		GetMaxPrice(BestsalerpriceList);

		//Women............................................................
		WebElement WomenButton=	driver.findElement(By.cssSelector("a[title=Women]"));


		Base.ScrolltoElement(WomenButton,driver);


		WebElement DresssesButton=	driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/a"));


		Base.MouseOver(WomenButton,driver);
		DresssesButton.click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;  

		List<WebElement> WomenDressesList=driver.findElements(By.cssSelector("a.product-name"));
		Base.DisplayList(WomenDressesList,"Women Dresses");
//......................
		List<WebElement> Discoundlist=driver.findElements(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[1]/span[3]"));

		GetdiscountDresses(Discoundlist);
		
		//Card............................................................

		WebElement CardButton=	driver.findElement(By.xpath("//div[@class='shopping_cart']/a"));
		Base.ScrolltoElement(CardButton,driver);
		CardButton.click();

		WebElement ProceedCheckOut1=	driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']/a[1]"));
		Base.ScrolltoElement(ProceedCheckOut1,driver);
		ProceedCheckOut1.click();

		WebElement EmailCreate=	driver.findElement(By.id("email_create"));
		Base.ScrolltoElement(EmailCreate,driver);

		
		
		Random rand = new Random(); 

		// Generate random integers in range 0 to 999 
		int rand_int1 = rand.nextInt(1000);
		String RandNum = String.valueOf(rand_int1);

		EmailCreate.sendKeys("Radwa@task.com"+RandNum);

		WebElement SubmitCreate=	driver.findElement(By.id("SubmitCreate"));
		SubmitCreate.click();

		WebElement MrsRadio=	driver.findElement(By.id("uniform-id_gender2"));
		Base.ScrolltoElement(MrsRadio,driver);
		MrsRadio.click();		

		WebElement Firstname=	driver.findElement(By.id("customer_firstname"));
		Firstname.sendKeys("Radwa");

		WebElement Lastname=	driver.findElement(By.id("customer_lastname"));
		Lastname.sendKeys("Radwa");

		WebElement Password=	driver.findElement(By.id("passwd"));
		Password.sendKeys("12345");


		Select Day =  new Select(driver.findElement(By.id("days")));
		Day.selectByIndex(13);

		Select Month =  new Select(driver.findElement(By.id("months")));
		Month.selectByIndex(5);

		Select Years =  new Select(driver.findElement(By.id("years")));
		Years.selectByIndex(19);
		//...........................
		WebElement Address=	driver.findElement(By.id("address1"));
		Base.ScrolltoElement(Address,driver);
		Address.sendKeys("IBM-Training");

		WebElement City=	driver.findElement(By.id("city"));
		City.sendKeys("Cairo");

		Select State =  new Select(driver.findElement(By.id("id_state")));
		State.selectByIndex(4);

		WebElement PostCode=	driver.findElement(By.id("postcode"));
		PostCode.sendKeys("11311");

		WebElement PhoneMobile=	driver.findElement(By.id("phone_mobile"));
		PhoneMobile.sendKeys("0100000000000");

		WebElement Alias=	driver.findElement(By.id("alias"));
		Base.ScrolltoElement(Alias,driver);
		Alias.sendKeys("street1 block 4");

		WebElement Register=	driver.findElement(By.id("submitAccount"));
		Register.click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;  
	
		//...........................

		WebElement ProceedCheckOut2=	driver.findElement(By.xpath("//button[@name='processAddress']"));
		Base.ScrolltoElement(ProceedCheckOut2,driver);
		ProceedCheckOut2.click();

	
		//..................
		WebElement Agreement=	driver.findElement(By.id("cgv"));
		Agreement.click();
		WebElement ProceedCheckOut3=	driver.findElement(By.xpath("//button[@name='processCarrier']"));
		Base.ScrolltoElement(ProceedCheckOut3,driver);
		ProceedCheckOut3.click();
		
		//..................
		WebElement PayByCheck=	driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a"));
		Base.ScrolltoElement(PayByCheck,driver);
		PayByCheck.click();

		WebElement Confirm=	driver.findElement(By.xpath("//*[@id='cart_navigation']/button"));
		Base.ScrolltoElement(Confirm,driver);
		Confirm.click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;  

		WebElement OrderCompleleted=	driver.findElement(By.xpath("//div[@id='center_column']/p[1]"));

		Assert.assertEquals("Your order on My Store is complete.",OrderCompleleted.getText());
		
	}



	public static void GetMaxPrice( List<WebElement> e) 
	{
		double max = Double.MIN_VALUE;

		int location = 0;
		double price;		

		for(int i=0; i<e.size(); i++){
			price=Double.parseDouble(e.get(i).getText().replaceAll("[$]", "")) ;
			if(price> max){
				max = price;
				location=i;	
			}

		}
		System.out.println("....................................................");
		System.out.println("Most expensive one "+max);
		System.out.println("***************************************************");

		Actions action = new Actions(driver);
		action.moveToElement(e.get(location)).perform();

		WebElement x=	e.get(location).findElement(By.xpath("../../div[2]/a[1]"));
		x.click();

		WebElement Continue_shopping = (new WebDriverWait(driver, 10))			
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[title='Continue shopping']")));
		Continue_shopping.click();



	}


	public static void GetLessPrice( List<WebElement> e) 
	{
		double min = Double.MAX_VALUE;
		double price ;
		int location=0;
		for(int i=0; i<e.size(); i++){
			price=Double.parseDouble(e.get(i).getText().replaceAll("[$]", "")) ;
			if(price< min){
				min = price;
				location=i;

			}

		}
		System.out.println("....................................................");
		System.out.println("The cheapest one "+ min);

		System.out.println("***************************************************");

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,800)");
		 * 
		 */
		Actions action = new Actions(driver);
		action.moveToElement(e.get(location)).perform();

		WebElement x=	e.get(location).findElement(By.xpath("../../div[2]/a[1]"));
		x.click();

		WebElement Continue_shopping = (new WebDriverWait(driver, 10))			
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[title='Continue shopping']")));
		Continue_shopping.click();



	}

	public static void GetdiscountDresses (List<WebElement> listDiscound)
	{
		WebElement AddtoCardButton;
		WebElement Continue_shopping ;
		System.out.println("***************************************************");

		System.out.println(listDiscound.size());			

		for(int i=0; i<listDiscound.size(); i++){

			Base.ScrolltoElement(listDiscound.get(i),driver);

			System.out.println(listDiscound.get(i).findElement(By.xpath("../../h5")).getText());			
			System.out.println("Old Price :"+listDiscound.get(i).findElement(By.xpath("../span[2]")).getText());
			System.out.println("Discound Percentage  :"+listDiscound.get(i).getText());
			System.out.println("New Price :"+listDiscound.get(i).findElement(By.xpath("../span[1]")).getText());
			System.out.println("....................................................");
			Base.MouseOver(listDiscound.get(i),driver);


			AddtoCardButton=listDiscound.get(i).findElement(By.xpath("../../div[@class='button-container']/a[1]"));

			AddtoCardButton.click();

			Continue_shopping = (new WebDriverWait(driver, 10))			
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[title='Continue shopping']")));
			Continue_shopping.click();

		}

		System.out.println("***************************************************");

	}


}