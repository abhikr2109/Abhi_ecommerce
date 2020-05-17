package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.AddToCartPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class AddToCarPageTest extends Testbase{
	
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addTocart;
	
	public AddToCarPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		initialization();
		
		loginPage = new LoginPage();
		homePage = new HomePage();
		addTocart = new AddToCartPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		addTocart = homePage.moveToCart();
		Thread.sleep(3000);
		/testing purpose
		
	}
	
	/*@Test(priority=1)
	public void verifyCartPageTitleTest()
	{
		String title = addTocart.verifyCartPageTitle();
		Assert.assertEquals(title,"Shopping Cart | Flipkart.com", "Title for Cart is not matched");
	}*/
	
	@Test(priority=2)
	public void deleteAllCart() throws InterruptedException
	{
		Thread.sleep(3000);
		addTocart.removeAllItems();
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
		System.out.println("done");
		Thread.sleep(5000);
		driver.quit();
	}

}
