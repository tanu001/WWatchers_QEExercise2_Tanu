package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class Homepage {
	WebDriver ldriver;

			//Constructor
			
			public Homepage(WebDriver rdriver)
			{
				ldriver=rdriver;
				PageFactory.initElements(rdriver, this);
			}

			// Clicking on Buy option
			@FindBy(xpath=("//span[@class='MenuItem_menu-item__inner-wrapper__1trJ0 MenuItem_menu-item__inner-wrapper--with-icon__2l1uq']//span[contains(text(),'Find a Workshop')]"))
			@CacheLookup
			WebElement clklocation;
			
			public void findLocation()	{
				WebDriverWait wait = new WebDriverWait(ldriver, 20);
				wait.until(ExpectedConditions.visibilityOf(clklocation));	
				wait.until(ExpectedConditions.elementToBeClickable(clklocation));
				clklocation.click();
			}
			
}
