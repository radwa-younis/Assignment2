package TesTCases;

import static org.testng.Assert.assertEquals;

import java.text.DecimalFormat;

import org.apache.commons.math3.util.Precision;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.CardAction;
import Pages.CardPage;
import Utilities.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Card {


	// Test(priority ... ) will work if you use Testng suit and enable before suite in OnlineShop Class
	@Test(priority = 1)

	// Cucumber anotaion will work if you use runner class and enable before in OnlineShop Class
	@Then ("^Move to Card$")
	public void move_to_Card() throws Throwable {

		CardAction.MoveClick(CardPage.AddCardButton(Base.driver));

		///.......assert on Item Name on list........................

		//		CardAction.ItemName(CardPage.CardListName(Base.driver));

		for (int i = 0; i < Base.ItemAdd.size(); i++) {
			
			assertEquals(CardAction.ItemName(CardPage.CardListName(Base.driver)).get(i).replaceAll("\\s", "")
					,Base.ItemAdd.get(i).replaceAll("\\s", ""));
		
			System.out.println(CardAction.ItemName(CardPage.CardListName(Base.driver)).get(i).replaceAll("\\s", ""));
			System.out.println(Base.ItemAdd.get(i).replaceAll("\\s", ""));

		}		

		//.......assert on Total Price....................
		
		double ExpectPrice= Base.TotalPrice	+CardAction.GetPrice(CardPage.TotalShipping(Base.driver)) ;

		double ActualPrice=CardAction.GetPrice(CardPage.CardTotalPrice(Base.driver));



		
		

	//	Precision.round(ExpectPrice,2);

		
	
		
		 DecimalFormat df = new DecimalFormat("0.00");
	    String x= df.format(ExpectPrice);

	    
	    String c= Double.toString(ExpectPrice);

	    System.out.println("This is Assertion on Total Price actual Price = "
				+x+"/ expected Price "+c);
	//assertEquals(x,c);

	//	assertEquals(x,c);
		//........................
		CardAction.MoveClick(CardPage.ProceedCheckOut1(Base.driver));

	}

	// Test(priority ... ) will work if you use Testng suit and enable before suite in OnlineShop Class
	@Test(priority = 2)

	// Cucumber anotaion will work if you use runner class and enable before in OnlineShop Class
	@Then ("^Register$")
	public void Register() throws Throwable {

		CardAction.CreateAccount();
	}

	// Test(priority ... ) will work if you use Testng suit and enable before suite in OnlineShop Class
	@Test(priority = 3)

	// Cucumber anotaion will work if you use runner class and enable before in OnlineShop Class
	@Then ("^Check Pay$")
	public void Check() throws Throwable {

		CardAction.CheckPay();
	}

	// Test(priority ... ) will work if you use Testng suit and enable before suite in OnlineShop Class
	@Test(priority = 4 )

	// Cucumber anotaion will work if you use runner class and enable before in OnlineShop Class
	@Then("^Confirm$")
	public void Confirm() throws Throwable {

		CardAction.Confirm();
	}

}
