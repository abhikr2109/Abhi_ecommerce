package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class HomePage extends Testbase {
	
	
	@FindBy(xpath="//div[@class='_1jA3uo'][1]/div/div/div/div")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[text()='Cart']")
	WebElement cart;
	
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	WebElement searchProduct;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	 
	
	public HomePage ()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle()
	{
		return driver.getTitle();
	}
	
	public SearchResult searchProduct(String product) throws InterruptedException
	{
		searchProduct.sendKeys(product);
		Thread.sleep(8000);
		submitButton.submit();
		
		return new SearchResult() ;
		
	}
	
	public AddToCartPage moveToCart()
	{
		cart.click();
		
		return new AddToCartPage();
	}
	

}
