package TesTCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.HomeAction;
import Pages.HomePage;
import Utilities.Base;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExpensiveSaller {



	// Test(priority ... ) will work if you use Testng suit and enable before suite in OnlineShop Class
	@Test(priority = 1)

	// Cucumber anotaion will work if you use runner class and enable before in OnlineShop Class
	@When("^Saller Dresses$")
	public void saller_Dresses() throws Throwable {
		HomePage.BestSaller(Base.driver).click();

		Base.DisplayList(HomePage.SallerListName(Base.driver),"Poplar List Dresses");
	}
	// Test(priority ... ) will work if you use Testng suit and enable before suite in OnlineShop Class
	@Test(priority = 2)

	// Cucumber anotaion will work if you use runner class and enable before in OnlineShop Class
	@Then("^Get Max Price$")
	public void get_Max_Price() throws Throwable {
		HomeAction.GetMaxPrice(HomePage.SallerListPrice(Base.driver));

	}





}
