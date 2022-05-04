package seleniumAPI;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class practice_Axes {
	
	public static void main(String[] args) {
		//Setting the driver path
				System.setProperty("webdriver.chrome.driver", "/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
						
				//Creating WebDriver instance
				WebDriver driver = new ChromeDriver();
						
				//Navigate to web page
				driver.get("https://tiki.vn/nha-sach-tiki/");
				//Maximizing window
				driver.manage().window().maximize();
						
				//Putting implicit wait
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
				//select item
				driver.findElement(By.xpath("//p[contains(text(),\"Peppa Pig: Going Swimming\")]//ancestor::div[3]")).click();	
	
				Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),\"Peppa Pig: Going Swimming\")]")).isDisplayed());
				driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);

				//Closing browser session
				driver.quit();
				driver.close();
	}
	
}
