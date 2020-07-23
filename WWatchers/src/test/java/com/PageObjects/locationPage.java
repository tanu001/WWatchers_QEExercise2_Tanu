package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class locationPage {
	WebDriver ldriver;

			//Constructor
			
			public locationPage(WebDriver rdriver)
			{
				ldriver=rdriver;
				PageFactory.initElements(rdriver, this);
			}

	
			@FindBy(className=("locationName-1jro_"))
			@CacheLookup
			WebElement clkresult;
			
			@FindBy(xpath=("//span[contains(text(),'0.49 mi')]"))
			@CacheLookup
			WebElement clkdistance;
			

		
			public String result()	{
				WebDriverWait wait = new WebDriverWait(ldriver, 20);
				wait.until(ExpectedConditions.visibilityOf(clkresult));	
				wait.until(ExpectedConditions.elementToBeClickable(clkresult));
				return clkresult.getText();
			
			}
			public String distance()	{
				WebDriverWait wait = new WebDriverWait(ldriver, 20);
				wait.until(ExpectedConditions.visibilityOf(clkresult));	
				wait.until(ExpectedConditions.elementToBeClickable(clkresult));
				return clkdistance.getText();
			}
}
