package testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyHomePage 
{
	
	WebDriver driver;
	
	@BeforeMethod	
	public void setUp()
	{
		
		driver = BrowserFactory.getBrowser("chrome");		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	
	@Test
	public void testHomePage()
	{
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getApplicationTitle();
		System.out.println("my Apllication title is:"+ title);
		
		Assert.assertTrue(title.contains("Demo Store"));
		BrowserFactory.closeBrowser(driver);
		
	}
	
	@AfterMethod	
	public void tearDown()
	{
		
		BrowserFactory.closeBrowser(driver);
	}

}
