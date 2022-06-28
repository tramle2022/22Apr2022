package seleniumAPI;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Topic11_Ex03 {
	public static void main(String[] arg) {
		System.setProperty("webdriver.chrome.driver","/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://material.angular.io/components/radio/examples");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-button mat-button-base mat-primary']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		WebElement radio = driver.findElement(By.xpath("//label[@for='mat-radio-5-input']"));
		radio.click();
		
		boolean selectState = radio.isSelected();
		//performing click operation only if element is not selected
		if(selectState == false) {
			radio.click();
		}
		String abc = driver.findElement(By.xpath("//label[@for='mat-radio-5-input']//span[@class='mat-radio-label-content']")).getText();
		String xyz = driver.findElement(By.xpath("div[contains(text(),'Your favorite season is')]")).getText();
		assertTrue(abc.contains(xyz));
		driver.close();driver.quit();
	}
	
}

