package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.AddToCartPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends Testbase{
	
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addTocart;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		addTocart = new AddToCartPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTest()
	{
		String title = homePage.verifyPageTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!","Title not matches");
	}
	
	@Test(priority=2)
	public void clickOnCartTest()
	{
		addTocart = homePage.moveToCart();
	}
	
	@Test(priority=3) 
	public void searchProduct() throws InterruptedException
	{
		homePage.searchProduct(prop.getProperty("searchProduct"));
	}
	
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
		System.out.println("done");
		Thread.sleep(5000);
		driver.quit();
	}
}
