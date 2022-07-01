package seleniumAPI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Topic11_Ex04 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://material.angular.io/components/checkbox/examples");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-button mat-button-base mat-primary']")).click(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//checked
		String Checkbox1_name = driver.findElement(By.xpath("//label[@for='mat-checkbox-1-input']//span[@class='mat-checkbox-label']")).getText();
		WebElement Checkbox1 = driver.findElement(By.xpath("//input[@id='mat-checkbox-1-input']//parent::span[@class='mat-checkbox-inner-container']"));
		boolean bl1=Checkbox1.isSelected();
		System.out.println(bl1);
		if (bl1==false) {
		Checkbox1.click();
		System.out.println("Check box "+Checkbox1_name+" selected Successfully");
		}
		else {
		System.out.println("Check box "+Checkbox1_name +" is not enable ");
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String Checkbox2_name = driver.findElement(By.xpath("//label[@for='mat-checkbox-2-input']//span[@class='mat-checkbox-label']")).getText();
		WebElement Checkbox2 = driver.findElement(By.xpath("//input[@id='mat-checkbox-2-input']//parent::span[@class='mat-checkbox-inner-container']"));
		boolean bl2=Checkbox2.isSelected();
		System.out.println(bl2);
		if (bl2==false) {
		Checkbox2.click();
		System.out.println("Check box "+Checkbox2_name+" selected Successfully");
		}
		else {
		System.out.println("Check box "+Checkbox2_name +" is not enable ");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//unchecked 
		boolean bl3=Checkbox1.isSelected();
		System.out.println(bl3);
		if (bl3==false) 
		{ 	Checkbox1.click();
			System.out.println("Check box "+Checkbox1_name+" deselected Successfully"); 
			}
			else 
			{ 
			System.out.println("Check box "+Checkbox1_name +" is still enable "); 
			}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		boolean bl4=Checkbox2.isSelected();
		System.out.println(bl4);
		if (bl4==false) 
		{ 	Checkbox2.click();
			System.out.println("Check box "+Checkbox2_name+" deselected Successfully"); 
			}
			else 
			{ 
			System.out.println("Check box "+Checkbox2_name +" is still enable "); 
			}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
		driver.close();driver.quit();
		
		
	}
}
