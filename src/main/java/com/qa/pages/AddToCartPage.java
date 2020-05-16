package com.qa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class AddToCartPage extends Testbase {
	

	@FindBy(xpath = "//div[text()=\"Save for later\"]//following-sibling::div")
	List<WebElement> removeCartButton;

	@FindBy(xpath = "//div[text()='Are you sure you want to remove this item?']//parent::div/div[3]/div/div[2]")
	WebElement removeButton;
	
	@FindBy(xpath="//img[@title='Flipkart']")
	WebElement homeIcon;

	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void removeAllItems() throws InterruptedException
	{
		int count = removeCartButton.size();
		//Iterator itr = removeCartButton.iterator();
		System.out.println("size of cart:"+count);
		
		if(count==0)
		{
			clickOnHomeIcon();
		}
		else
		{
			for(int i=0;i<count ; )
			{
				removeCartButton.get(i).click();
				Thread.sleep(2000);
				removeButton.click();
				Thread.sleep(5000);
				count--;
				//i = i-1;
			}
		}
		clickOnHomeIcon();

	}
		
	
	public HomePage clickOnHomeIcon()
	{
		homeIcon.click();
		return new HomePage();
	}
	
	

	public String verifyCartPageTitle() {
		return driver.getTitle();
	}

}
