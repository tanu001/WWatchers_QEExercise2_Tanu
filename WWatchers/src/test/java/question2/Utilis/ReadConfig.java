package question2.Utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
			// Creating File object
		

		// Open FileInputStream and Read data 
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);// Load config.properties file
		}
		 catch (IOException e) {
			// If config.properties file is not available it will throw an exception
				System.out.println("Exception is " + e.getMessage());// TODO Auto-generated catch block

		} 
	}
	public String getURL() {
		String url =pro.getProperty("baseUrl");
		return url;
	

	}
	public String getChropath() {
		String url =pro.getProperty("chromepath");
		return url;
	

	}
	public String getFirefoxpath() {
		String url =pro.getProperty("firefoxpath");
		return url;
	

	}
	
}
