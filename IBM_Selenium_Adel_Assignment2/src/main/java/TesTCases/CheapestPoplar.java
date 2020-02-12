package TesTCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.HomeAction;
import Pages.HomePage;
import Utilities.Base;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheapestPoplar {

	// Test(priority ... ) will work if you use Testng suit and enable before suite in OnlineShop Class
	@Test(priority = 1)
	
	// Cucumber anotaion will work if you use runner class and enable before in OnlineShop Class
	@When("^Poplar Dresses$")
	public void poplar_Dresses() throws Throwable {
		Base.DisplayList(HomePage.PopularListName(Base.driver),"Poplar List Dresses");
	}
	// Test(priority ... ) will work if you use Testng suit and enable before suite in OnlineShop Class
	@Test(priority = 2)

	// Cucumber anotaion will work if you use runner class and enable before in OnlineShop Class
	@Then("^Get Less Price$")
	public void get_Less_Price() throws Throwable {
		HomeAction.GetLessPrice(HomePage.PopularListPrice(Base.driver));
	}

}

