package Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utilities.Base;
import Utilities.ExcelUtil;

public class CardAction {

	public static void MoveClick( WebElement Card) throws IOException 
	{

		Base.ScrolltoElement(Card,Base.driver);
		Card.click();

	}


	public static List<String>  ItemName(List<WebElement> list) 

	{		

		List<String> CartItemName = new ArrayList<String>();

		for (WebElement element : list)
		{

			CartItemName.add(element.getText());

		}




		return CartItemName;
	}





	//	public static double  GetPrice( WebElement Pricefield) throws IOException
	public static double  GetPrice(WebElement Pricefield) throws IOException

	{

		String PriceS =Pricefield.getText();
		double Price =Double.parseDouble(PriceS.replaceAll("[$]", ""));


		return Price;
	}



	/*
	 * public static void Countinue( WebElement ProceedCheckOut) throws IOException
	 * {
	 * 
	 * // WebElement ProceedCheckOut1=
	 * Base.driver.findElement(By.xpath(ExcelUtil.ReadExcel(0,19, 1)));
	 * Base.ScrolltoElement(ProceedCheckOut,Base.driver); ProceedCheckOut.click();
	 * 
	 * }
	 */

	public static void CreateAccount() throws IOException {


		//WebElement EmailCreate=	driver.findElement(By.id("email_create"));

		Base.ScrolltoElement(CardPage.EmailCreate(Base.driver),Base.driver);


		Random rand = new Random(); 

		// Generate random integers in range 0 to 999 
		int rand_int1 = rand.nextInt(1000);
		String RandNum = String.valueOf(rand_int1);

		CardPage.EmailCreate(Base.driver).sendKeys("Radwa@task.com"+RandNum);

		WebElement SubmitCreate=	Base.driver.findElement(By.id("SubmitCreate"));
		SubmitCreate.click();

		WebElement MrsRadio=	Base.driver.findElement(By.id("uniform-id_gender2"));
		Base.ScrolltoElement(MrsRadio,Base.driver);
		MrsRadio.click();		

		WebElement Firstname=	Base.driver.findElement(By.id("customer_firstname"));
		Firstname.sendKeys("Radwa");

		WebElement Lastname=	Base.driver.findElement(By.id("customer_lastname"));
		Lastname.sendKeys("Radwa");

		WebElement Password=	Base.driver.findElement(By.id("passwd"));
		Password.sendKeys("12345");


		Select Day =  new Select(Base.driver.findElement(By.id("days")));
		Day.selectByIndex(13);

		Select Month =  new Select(Base.driver.findElement(By.id("months")));
		Month.selectByIndex(5);

		Select Years =  new Select(Base.driver.findElement(By.id("years")));
		Years.selectByIndex(19);
		//...........................
		WebElement Address=	Base.driver.findElement(By.id("address1"));
		Base.ScrolltoElement(Address,Base.driver);
		Address.sendKeys("IBM-Training");

		WebElement City=	Base.driver.findElement(By.id("city"));
		City.sendKeys("Cairo");

		Select State =  new Select(Base.driver.findElement(By.id("id_state")));
		State.selectByIndex(4);

		WebElement PostCode=	Base.driver.findElement(By.id("postcode"));
		PostCode.sendKeys("11311");

		WebElement PhoneMobile=	Base.driver.findElement(By.id("phone_mobile"));
		PhoneMobile.sendKeys("0100000000000");

		WebElement Alias=	Base.driver.findElement(By.id("alias"));
		Base.ScrolltoElement(Alias,Base.driver);
		Alias.sendKeys("street1 block 4");

		WebElement Register=	Base.driver.findElement(By.id("submitAccount"));
		Register.click();
		Base.driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;  

		WebElement ProceedCheckOut2=	Base.driver.findElement(By.xpath("//button[@name='processAddress']"));
		Base.ScrolltoElement(ProceedCheckOut2,Base.driver);
		ProceedCheckOut2.click();

		WebElement Agreement=	Base.driver.findElement(By.id("cgv"));
		Agreement.click();
		WebElement ProceedCheckOut3=	Base.driver.findElement(By.xpath("//button[@name='processCarrier']"));
		Base.ScrolltoElement(ProceedCheckOut3,Base.driver);
		ProceedCheckOut3.click();
	}


	public static void CheckPay() throws IOException 
	{

		WebElement PayByCheck=	Base.driver.findElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[2]/div/p/a"));
		Base.ScrolltoElement(PayByCheck,Base.driver);
		PayByCheck.click();


	}
	public static void Confirm() throws IOException 
	{

		WebElement Confirm=	Base.driver.findElement(By.xpath("//*[@id='cart_navigation']/button"));


		MoveClick(Confirm);

		Base.driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;  

		WebElement OrderCompleleted=	Base.driver.findElement(By.xpath("//div[@id='center_column']/p[1]"));

		Assert.assertEquals("Your order on My Store is complete.",OrderCompleleted.getText());
		Base.ItemNum = 0;
		Base.TotalPrice =0.0;
		Base.ItemAdd.clear();



	}





}
