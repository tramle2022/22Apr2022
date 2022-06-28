package seleniumAPI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Topic11_Ex01 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		//driver.findElement(By.xpath("//input[@id='eq6']")).click();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='eq6']"));
		checkbox.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("The checkbox is selection state is - " + checkbox.isSelected());

		//driver.findElement(By.xpath("//input[@id='eq6']")).click();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		checkbox.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("The checkbox is selection state is - " + checkbox.isSelected());
		
		driver.close();driver.quit();

	}
}
