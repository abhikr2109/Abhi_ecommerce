package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class LoginPage extends Testbase {
	
	//Page factory
	
	@FindBy(xpath="//div[@class='_39M2dM JB4AMj']//input")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	@FindBy(xpath="//button[@type='submit']//span[text()='Login']")
	WebElement loginBtn;
	
	//Initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateLoginPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public HomePage login(String un, String pwd) 
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	

}
