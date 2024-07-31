/**
 * 
 */

/**
 * @author Jasdeep
 *
 */
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {

WebDriver driver;
	
	@Test(priority=1)
	 void openBrowser() throws IOException 
	 {
	
		 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jasdeep\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		//WebDriverManager.firefoxdriver().setup();
		driver=new ChromeDriver();
		
	    driver.get("http://localhost/addressbook/index.php");
	    driver.manage().window().maximize();
	    
		 
		//edge browser
		//WebDriverManager.edgedriver().setup();
		//WebDriver driver=new EdgeDriver();
		 
		//open brwoser
		//	WebDriverManager.chromedriver().setup();
		//	WebDriver driver=new ChromeDriver();
		 
	 // Full Page screenshot
		
	 			TakesScreenshot ts=(TakesScreenshot)driver;
	 			File src=ts.getScreenshotAs(OutputType.FILE);
	 			File trg=new File(".\\screenshots\\HomePage.png");
	 			FileUtils.copyFile(src,trg);
	 			
	 }

	@Test(priority=2)
	void ExpectedResult()
	{
		String expectedResult = "Address Book Main Menu";
		String actualResult = "Address Book Main Menu";
		if(actualResult.contentEquals(expectedResult)) {
			System.out.println("Test is pass!");
		}
			else {
				System.out.println("Test is Fail!");
			}
		}
	
	
	
	@Test(priority=3)
	void closeBrowser()
	{
		driver.close();
	}
}

