package question2.PageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class SearchPage {
	WebDriver ldriver;

			//Constructor
			
			public SearchPage(WebDriver rdriver)
			{
				ldriver=rdriver;
				PageFactory.initElements(rdriver, this);
			}

			// Clicking on Buy option
			@FindBy(id=("location-search"))
			@CacheLookup
			WebElement typesearch;
			
			@FindBy(id=("location-search-cta"))
			@CacheLookup
			WebElement clksearch;
			
			@FindBy(xpath=("//a[contains(text(),'WW Studio Flatiron')]"))
			@CacheLookup
			WebElement clkresult;
			
			@FindBy(xpath=("//span[contains(text(),'0.49 mi')]"))
			@CacheLookup
			WebElement clkdistance;
		
			
			@FindBy(className=("//div[contains(@class,'day')]/span[text()='MON']/../div/span[2]"))
			@CacheLookup
			List<WebElement> allNameElements;

			public void search(String text)	{
				WebDriverWait wait = new WebDriverWait(ldriver, 20);
				wait.until(ExpectedConditions.visibilityOf(typesearch));	
				wait.until(ExpectedConditions.elementToBeClickable(typesearch));
				typesearch.sendKeys(text);
			}
			public void Clicksearch()	{
				WebDriverWait wait = new WebDriverWait(ldriver, 20);
				wait.until(ExpectedConditions.visibilityOf(clksearch));	
				wait.until(ExpectedConditions.elementToBeClickable(clksearch));
				clksearch.click();
			}
			public void ClickResult()	{
				WebDriverWait wait = new WebDriverWait(ldriver, 20);
				  Actions action = new Actions(ldriver);
				  try {
				  
		  		wait.until(ExpectedConditions.elementToBeClickable(clkresult));
		  		clkresult.click();  
				  }catch(StaleElementReferenceException e) {
					  try {
						  wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(clkresult)));
						  clkresult.click();
					  		}catch(TimeoutException e2) {
					  			action.click(clkresult).perform();
					  		}
				  }	catch(org.openqa.selenium.ElementClickInterceptedException e3) {
					  ldriver.navigate().refresh();
					  	try
					  	{
					  		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(clkresult)));
					  		clkresult.click();
					  		}catch(TimeoutException e2) {
					  			action.click(clkresult).perform();
					  			}
				
				  		
				}
				
			}
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
			
			//print the number of meeting the each person(under the scheduled time) has a particular day of the week
			public void printMeetings(String day)	{
				
				String appointments_xPath = "//div[contains(@class,'day')]/span[text()='***']/../div/span[2]";
				int len = ldriver.findElements(By.xpath(appointments_xPath.replace("***", day))).size();
				List<WebElement> appointmentsForDay = ldriver.findElements(By.xpath(appointments_xPath.replace("***", day)));
						Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
						for (WebElement e:  appointmentsForDay) {
							
							Integer count = frequencyMap.get(e.getText());
							if (count == null)
								count = 0;

							frequencyMap.put(e.getText(), count + 1);
						}

						for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
							//System.out.println("The persons with the no. of appointments :");
							System.out.println(entry.getKey()+ ": " + entry.getValue());
						}
							
				
			}
		
}
