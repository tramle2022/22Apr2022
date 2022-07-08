package seleniumAPI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Topic13_Ex06 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		 //get url
		driver.get("https://material.angular.io/cdk/drag-drop/examples");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='Ok, Got it']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		WebElement dd1 = driver.findElement(By.xpath("//div[@cdkdraglockaxis='y']"));
		//WebElement dd2 = driver.findElement(By.xpath("//div[contains(text(), 'up/down')]"));
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(dd1).click().build().perform();
		System.out.println(dd1.getText());
		
		Thread.sleep(300);
		driver.close();driver.quit();
		
	}
}
