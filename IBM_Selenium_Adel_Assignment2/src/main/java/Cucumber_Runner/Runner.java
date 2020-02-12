package Cucumber_Runner;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import Pages.CardAction;
import Pages.CardPage;
import Utilities.Base;
import Utilities.ExcelUtil;
import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions(

		
		features = 
		
		//	{"CheapestPoplar.feature", "ExpensiveSaller.feature","WomenDresses.feature","Card.feature"}
		/*
		 * 
		 * { "src\\main\\java\\Features\\CheapestPoplar.feature",
		 * "src\\main\\java\\Features\\ExpensiveSaller.feature",
		 * "src\\main\\java\\Features\\WomenDresses.feature",
		 * "src\\main\\java\\Features\\Card.feature",
		 * 
		 * // "WomenDresses.feature","Card.feature"
		 * 
		 * } //
		 */					 		
		"src\\main\\java\\Features"
		
	//	"C:\\Users\\younisR\\eclipse-workspace\\Itsm\\src\\test\\java\\Feastures"
				,	glue={"TesTCases"}
		)

public class Runner extends AbstractTestNGCucumberTests
{

	
	  
	  
	  

	
	
}

