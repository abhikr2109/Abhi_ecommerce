package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;



public class LoginPageTest extends Testbase {
	
	LoginPage login;
	HomePage homePage;
	
	 public LoginPageTest() {
		super(); 
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
	    login = new LoginPage();
	}
	
	@Test(priority=1)
	public void GetLoginPageTitle()
	{
		String title = login.validateLoginPageTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Test(priority=2)
	public void loginTest() 

	{
		homePage = login.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
		System.out.println("done");
		Thread.sleep(5000);
		driver.quit();
	}
	

}
