package TesTCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.WomenAction;
import Pages.Womenpage;
import Utilities.Base;
import Utilities.ExcelUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WomenDresses {
	
	
	// Test(priority ... ) will work if you use Testng suit and enable before suite in OnlineShop Class
	@Test(priority = 1)

	// Cucumber anotaion will work if you use runner class and enable before in OnlineShop Class
	@When("^Women Dresses Displayed$")
	public void women_Dresses_Displayed() throws Throwable {

		WomenAction.GetWomenDresses();


	}

	// Test(priority ... ) will work if you use Testng suit and enable before suite in OnlineShop Class
	@Test(priority = 2)
	
	// Cucumber anotaion will work if you use runner class and enable before in OnlineShop Class
	@Then("^Get Discound Price$")
	public void get_Discound_Price() throws Throwable {
	//	List<WebElement> Discoundlist=Base.driver.findElements(By.xpath(ExcelUtil.ReadExcel(0,13, 1)));

		WomenAction.GetdiscountDresses(Womenpage.DiscoundLabel(Base.driver));
		System.out.println(Base.ItemNum);

	}

}

