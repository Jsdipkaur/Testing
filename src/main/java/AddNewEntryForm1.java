import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

/**
 * 
 */

/**
 * @author Jasdeep
 *
 */
public class AddNewEntryForm1 {

WebDriver driver;
	
	@Test(priority=1)
	 void openBrowser() 
	 {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jasdeep\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		//WebDriverManager.firefoxdriver().setup();
		driver=new ChromeDriver();
		
	    driver.get("http://localhost/addressbook/index.php");
	    driver.manage().window().maximize();
	    
	    
	    
	 }
	
	@Test(priority=2)
	void AddNewEntry() throws IOException
	{
			driver.findElement(By.linkText("Add New Entry")).click();
			
			driver.findElement(By.id("addr_type")).sendKeys("Friend");;
			driver.findElement(By.id("addr_region")).sendKeys("Ontario");
			driver.findElement(By.id("addr_country")).sendKeys("Canada");
			driver.findElement(By.id("addr_post_code")).sendKeys("L5R 2A7");
			driver.findElement(By.id("addr_phone_1_type")).sendKeys("Home");
			driver.findElement(By.id("addr_web_url_1")).sendKeys("www.gov.ca");
			
			driver.findElement(By.id("submit_button")).click();
			
			String expectedErrorMessage = "An person's name or business name must be specified.";
			String actualErrorMessage = "An person's name or business name must be specified.";
			if(actualErrorMessage.contentEquals(expectedErrorMessage)) {
				System.out.println("Test is pass!");
			}
				else {
					System.out.println("Test is Fail!");
				}	
			
			// Full Page screenshot
			
						TakesScreenshot ts=(TakesScreenshot)driver;
						File src=ts.getScreenshotAs(OutputType.FILE);
						File trg=new File(".\\screenshots\\AddNewEntryForm1.png");
						FileUtils.copyFile(src,trg);
						
}
	
	@Test(priority=3)
	void closeBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
}
