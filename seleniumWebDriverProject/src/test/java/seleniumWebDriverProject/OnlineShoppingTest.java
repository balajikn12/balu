package seleniumWebDriverProject;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testmeapp.utility.Drivers;

public class OnlineShoppingTest
{
     WebDriver driver;
     ExtentHtmlReporter htmlReporter;
     ExtentReports reports;
     ExtentTest logger;
     
     
     
     ;
     @BeforeTest
 	public void StartReportBeforeTest() 
 	{
    	 
    	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms");
    		String path=System.getProperty("user.dir")+"/extent-reports/"+sdf.format(new Date())+".html";
    		htmlReporter=new ExtentHtmlReporter(path);
    		reports=new ExtentReports();
    		reports.attachReporter(htmlReporter);
    		reports.setSystemInfo("username", "balaaji");
    		reports.setSystemInfo("host", "localhost");
    		reports.setSystemInfo("Environment", "Test Environment");
    		
    		htmlReporter.config().setReportName("Test Me App Report");
    		htmlReporter.config().setTheme(Theme.DARK);
 	        driver=Drivers.getDriver("chrome");
 		    driver.get("http://10.232.237.143:443/TestMeApp/");
 		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	}

     
     @Test(priority=1)
        public void testRegistration() throws InterruptedException
	{
    	 driver.findElement(By.partialLinkText("SignUp")).click();
		
		 driver.findElement(By.id("userName")).sendKeys("balji115875");
		  driver.findElement(By.id("firstName")).sendKeys("balajiiii");
		  driver.findElement(By.id("lastName")).sendKeys("KNn");
		  driver.findElement(By.id("password")).sendKeys("password123");
		  driver.findElement(By.id("pass_confirmation")).sendKeys("password123");
		  driver.findElement(By.cssSelector("input[value='Male']")).click();
		  driver.findElement(By.id("emailAddress")).sendKeys("ask@gmail.com");
		  driver.findElement(By.id("mobileNumber")).sendKeys("8545884554");
		  driver.findElement(By.id("dob")).sendKeys("05/25/1996");
		  driver.findElement(By.id("address")).sendKeys("hebbal,benagluru");
		   WebElement li = driver.findElement(By.id("securityQuestion"));
		  Select sa=new Select(li);
		   sa.selectByValue("411011");
		  driver.findElement(By.id("answer")).sendKeys("Red");
		  driver.findElement(By.name("Submit")).click();
		  logger=reports.createTest("Registration");
			logger.log(Status.PASS, "Registration successful passed");
			
		 
	}
		  @Test(priority=2)
		 public void Login()
     {
			 // driver.findElement(By.partialLinkText("SignIn")).click();
			  driver.findElement(By.id("userName")).sendKeys("balji115875");    
			  driver.findElement(By.id("password")).sendKeys("password123");
			 driver.findElement(By.name("Login")).click();
	
			 logger=reports.createTest("Login");
				logger.log(Status.PASS, "The test is passed");
				
			 
     }
		  
		  

        
		  
		  @Test(priority=3)
		  public void Cart() 
		  {
			  
			  Actions action =new Actions(driver);
			  action.moveToElement(driver.findElement(By.partialLinkText("All Categories"))).perform();
			  action.moveToElement(driver.findElement(By.partialLinkText("Electronics"))).click().perform();
			  action.moveToElement(driver.findElement(By.partialLinkText("Head Phone"))).click().perform();
			  action.moveToElement(driver.findElement(By.partialLinkText("Add to cart"))).click().perform();
			  logger=reports.createTest("Cart");
				logger.log(Status.FAIL, "The test is failed");
				
			   action.moveToElement(driver.findElement(By.partialLinkText("Cart"))).click().perform();
			 driver.findElement(By.partialLinkText("Checkout")).click(); 
			  driver.findElement(By.cssSelector("input[value='Proceed to Pay']")).click();
			
			  
			  
		  }
		  
		  
		  @Test(priority=4)
		 public void Payment()
		  {
			  
			 driver.findElement(By.xpath("//div[@id=\"swit\"]/div[1]/div/label/i")).click();
			driver.findElement(By.id("btn")).click(); 
			
			
			driver.findElement(By.name("username")).sendKeys("123456"); 
			driver.findElement(By.name("password")).sendKeys("Pass@456");
			
			 driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
			 
			 driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
			driver.findElement(By.cssSelector("input[value='PayNow']")).click();
			String text = driver.findElement(By.xpath("/html/body/b/section/div/div/div/div[2]/p")).getText();
			System.out.println(text);
			Assert.assertTrue(text.contains("confirmed"));
			
			logger=reports.createTest("payment");
			logger.log(Status.PASS, "The test is Passed");
			
		  }
		  
		  
		  
		  @AfterMethod
		  
		  public void getResultAfterMethod(ITestResult result)
		  {
			  if(result.getStatus()==ITestResult.FAILURE)
			  {
				  logger.log(Status.FAIL, "The Test is Failed");
				  
			  }
			  if(result.getStatus()==ITestResult.SUCCESS)
				  
			  {
				  logger.log(Status.FAIL, "The Test is Passed");
			  }
			  
			  
                if(result.getStatus()==ITestResult.SUCCESS)
				  
			  {
				  logger.log(Status.SKIP, "The Test is skipped");
			  }
			  
			  
		  }
		  
		  
		  
		  @AfterTest
		  public void endReportAfterTest()
		  {
			  reports.flush();
			  driver.close();
			  
		  }
		  
}
		  
		  
		  
		  
		  
		  
		  

		
	
	  
			 
			 
    	 
			 

			 
			 
			 
			 

			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 






