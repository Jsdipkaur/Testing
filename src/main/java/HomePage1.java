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
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage1 {
	
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
void ListAllEntries() throws IOException
{
		driver.findElement(By.linkText("List All Entries")).click();
		
		String expectedTitle = "Address Book - All Entries";
		String actualTitle = "Address Book - All Entries";
		if(actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test is pass!");
		}
			else {
				System.out.println("Test is Fail!");
			}	
		// Full Page screenshot
		
					TakesScreenshot ts=(TakesScreenshot)driver;
					File src=ts.getScreenshotAs(OutputType.FILE);
					File trg=new File(".\\screenshots\\HomePage1.png");
					FileUtils.copyFile(src,trg);
					
	}
	
	@Test(priority=3)
	void closeBrowser()
	{
		driver.close();
	}
}