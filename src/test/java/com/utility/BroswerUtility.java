package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.constants.Browser;

public abstract class BroswerUtility {
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	public BroswerUtility(WebDriver driver)
	{
		super();
		this.driver=driver; //create instance of driver variable
	}
	public BroswerUtility(Browser browserName)
	{
		if(browserName==Browser.CHROME)
		{
			driver=new ChromeDriver();
		}
		else if(browserName==Browser.EDGE)
		{
			driver=new EdgeDriver();
		}
		else if(browserName==Browser.FIREFOX)
		{
			driver=new ChromeDriver();
		}
	}
	
	public void goToWebSite(String Url)
	{
		driver.get(Url);
	}
	public void maximizeWindow()
	{
		driver.manage().window().maximize();
	}
	public void clickOn(By locator)
	{
		WebElement element=driver.findElement(locator);
		element.click();
	}
	public void enterText(By locator,String email)
	{
		WebElement element=driver.findElement(locator);
		element.sendKeys(email);
	}
	public String getVisibilityText(By locator)
	{
		WebElement element=driver.findElement(locator);
		return element.getText();
		
	}
	

}
