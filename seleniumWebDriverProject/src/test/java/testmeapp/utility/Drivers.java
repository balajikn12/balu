package testmeapp.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Drivers {
	 static public WebDriver getDriver(String browser) {
			
			if(browser.equals("chrome"))
			{
				
				 System.setProperty("webdriver.chrome.driver","C:\\Users\\balaji.k.n\\Downloads\\chromedriver_win32\\chromedriver.exe"); 
			
			return new ChromeDriver();
			
			}
			
			else if (browser.equals("ie"))
			{
				 System.setProperty("webdriver.ie.driver","C:\\Users\\balaji.k.n\\Downloads\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
				
					return new InternetExplorerDriver();
			
			}
			else if(browser.equals("geckodriver"))
			{
				System.setProperty("webdriver.gecko.driver","C:\\Users\\balaji.k.n\\Downloads\\geckodriver-v0.24.0-win32\\geckodriver.exe");
				return new FirefoxDriver();
			}
			
			else
			{
				return null;
				
			}
		}

}
