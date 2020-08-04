package question2.Baseclass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import question2.Utilis.ReadConfig;



public class baseclass {

	ReadConfig  readconfig = new ReadConfig(); // Creating object
	
						// Integrating data from ReadConfig
	public String baseURL=readconfig.getURL(); 
	
	public static WebDriver driver;
	
	
   @Parameters("browser") // browser value
	@BeforeClass()

	public void setup(String browser)
	
	{		
		// Initialization 
		
	   if(browser.equalsIgnoreCase("chrome"))
		{
										//Path from ReadConfig
		System.setProperty("webdriver.chrome.driver",readconfig.getChropath());
		driver=new ChromeDriver();		//getting Chrome path from readcong and configProperties
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		
		}
		
		else if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
			driver=new FirefoxDriver();
			driver.get(baseURL);
			driver.manage().window().maximize();
			
		}
		
		// Global implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
			
	}
	
	@AfterClass
	public void tearDown()
	{
		
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}
