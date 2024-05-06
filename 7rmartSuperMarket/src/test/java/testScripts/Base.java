package testScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class Base {
	
	WebDriver driver;

	@BeforeMethod
	public void initilizeBrowser() {
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		

	}

	@AfterMethod
	public void browserQuit() {
		// driver.close();
		//driver.quit();

	}

	

}
