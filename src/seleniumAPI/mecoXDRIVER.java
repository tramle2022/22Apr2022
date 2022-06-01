package seleniumAPI;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class mecoXDRIVER {
	public static void main (String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mecoxcloud.flywheelstaging.com/");
		driver.manage().window().maximize();
			
		//Get the title of home page.
		String url1 = driver.getCurrentUrl();
		if(url1.equals("https://mecoxcloud.flywheelstaging.com/")) 
			{
				System.out.println("Right url, page's name: "+ driver.getTitle());
				}
				else {
					System.out.println("Wrong url");
						}
		//Get the title of Mecox Collection.
		driver.findElement(By.xpath("//div[@class='horizontal']//descendant::a//span[(text()='MECOX COLLECTION')]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String url2 = driver.getCurrentUrl();
		if(url2.equals("https://mecoxcloud.flywheelstaging.com/product-tag/mecox-collection/")) 
			{
				System.out.println("Right url, page's name: "+ driver.getTitle());
				}
				else {
					System.out.println("Wrong url");
						}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
		//Get the title of TUCKER ROPE CONSOLE WITH ARCHED BASE 
		driver.findElement(By.xpath("//h2[contains(normalize-space(),'Tucker Rope Console with Arched Base')]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@name='add-to-cart']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//get page name
		String url3 = driver.getCurrentUrl();			
		  if(url3.equals("https://mecoxcloud.flywheelstaging.com/shop/living/consoles/tucker-rope-console-with-arched-base/")) 
		  	{ 
			  System.out.println("Right url, page's name: "+ driver.getTitle());
		  	} 
		  		else { 
		  				System.out.println("Wrong url"); 
		  				}

		//Get the title of Cart Page
		driver.findElement(By.xpath("//a[normalize-space()='View cart']")).click();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		String url4 = driver.getCurrentUrl();
		if(url4.equals("https://mecoxcloud.flywheelstaging.com/cart/")) 
			{
				System.out.println("Right url, page's name: "+ driver.getTitle());
				}
				else {
					System.out.println("Wrong url");
						}
		driver.quit();
	}
}
