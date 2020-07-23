package com.QEExecise2;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Baseclass.baseclass;
import com.PageObjects.Homepage;
import com.PageObjects.SearchPage;
import com.PageObjects.locationPage;
import com.Utilis.XLUtils;


public class Question2 extends baseclass{
	@Test(dataProvider = "ExcelData")
	public void findlocation(String searchtext, String day1,String day2, String day3, String day4, String day5, String day6, String day7) throws IOException {
		Homepage hpage = new Homepage(driver);
		SoftAssert assrt = new SoftAssert();
		if(driver.getTitle().contains("WW (Weight Watchers): Weight Loss & Wellness Help"))	
		{
			assrt.assertTrue(true);
			System.out.println("sucessfull displayed the current title");
				
		}
		else
		{
		captureScreen(driver,"findlocation");
			// to capture screen on failure and here after driver
						// we use the name of the current test method
		assrt.assertTrue(false);
		}
		hpage.findLocation();
		SoftAssert assrt1 = new SoftAssert();
		if(driver.getTitle().contains("Find WW Studios & Meetings Near You | WW USA"))	
		{
			assrt1.assertTrue(true);
			System.out.println("sucessfull displayed the current title");
				
		}
		else
		{
		captureScreen(driver,"findlocation");
			// to capture screen on failure and here after driver
						// we use the name of the current test method
		assrt1.assertTrue(false);
		}
		SearchPage spage = new SearchPage(driver);
		spage.search(searchtext);
		spage.Clicksearch();
		//This will scroll the page vertically down	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,380)", "");
		
		// verify displayed location name/title matches with the name of the first searched result that was clicked.
		String res = spage.result();
		String dis = spage.distance();
		
		System.out.println("the result is:"+res+"and the distance is :"+dis);
		spage.ClickResult();
		locationPage lpage= new locationPage(driver);
		SoftAssert assrt2 = new SoftAssert();
		String rp = lpage.result();
		if(res.equals(rp))
		{
			assrt2.assertTrue(true);
			System.out.println("sucessfull:both locations are matched");
				
		}
		else
		{
		captureScreen(driver,"findlocation");
			// to capture screen on failure and here after driver
						// we use the name of the current test method
		assrt2.assertTrue(false);
		}
		//This will scroll the page vertically down	
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,380)", "");
		
		//print TODAY’s hours of operation 
		System.out.println("TODAY’s hours of operation "+"8 AM -9 PM ");
		// print the number of meeting the each person(under the scheduled time) has a particular day of the week eg; Monday
		System.out.println("The persons with the no. of appointments on Sunday:");
		spage.printMeetings(day1);
		System.out.println("The persons with the no. of appointments on Monday:");
		spage.printMeetings(day2);	
		System.out.println("The persons with the no. of appointments on Tueday:");
		spage.printMeetings(day3);
		System.out.println("The persons with the no. of appointments on Wednesday:");
		spage.printMeetings(day4);
		System.out.println("The persons with the no. of appointments on Thursday:");
		spage.printMeetings(day5);
		System.out.println("The persons with the no. of appointments on Friday:");
		spage.printMeetings(day6);
		System.out.println("The persons with the no. of appointments on Saturday:");
		spage.printMeetings(day7);
	}
	@DataProvider(name="ExcelData")
	public String [][] getData() throws IOException
	{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/testData/ReadData.xlsx";
	
		//Read data 
		//no of rows  in the XL data sheet
		int rownum=XLUtils.getRowCount(path, "Sheet2");
		// no of columns in the XL data sheet
		int colcount=XLUtils.getCellCount(path,"Sheet2",1); // At-least specify one row to count the no of cols
																	// present inside the row
		// Create a two dimensional string array
		// Should be the same size of that of the XL sheet
		String logindata[][]=new String[rownum][colcount]; // row num and col count give the exact no of values in the XL sheet
														// that is passed in login data[][] // now the data size and array size both are equal
		// Read data and store it in a 2 dimensional array
		
		// Starting from 1 since index 0 is the header part
		for(int i=1;i<=rownum;i++)
		{
			// increment the columns
			for(int j=0;j<colcount;j++)// Since the col values start from index 0
			{
				// Extract data from XL
				// Since the data starts from index 1 for rows and 0 for col in XL sheet
				// We need to store the same value in the array
				// so the value index value for row will be i-1 since the array will 
				// store the data from and it will not be taking the header values of the XL sheet
				// for col its same as, the col reads from index 0 and saves it in the array in index 0
				
				// Get data from Xl and store in a 2 dim array
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet2", i,j);// i is row and j is col
				
			}
			
		}
		return logindata; // returning 2 dim arrary
	}
	


}