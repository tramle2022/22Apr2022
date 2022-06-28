package seleniumAPI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Topic11_Ex02 {
	public static void main (String[] args) {
		System.setProperty("webdriver.chrome.driver","/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement radio1 = driver.findElement(By.xpath("//input[@id='engine3']"));
		WebElement radio2 = driver.findElement(By.xpath("//input[@id='engine5']"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		radio1.click();
		System.out.println("The radio is selection state is - " + radio1.isSelected());
		radio2.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("The radio is selection state is - " + radio1.isSelected());
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.close();	driver.quit();




		
	}
}
