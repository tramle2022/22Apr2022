package seleniumAPI;

import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Topic13_Ex02 {
	public static void main(String[] arg) {
		System.setProperty("webdriver.chrome.driver","/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://flywheel:mecoxclone@mecoxcloud.flywheelstaging.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//find About
		WebElement ele = driver
				.findElement(By.xpath("//div[@class='horizontal']//descendant::a//span[(text()='ABOUT')]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		//find Mecox in the media
		driver.findElement(By.xpath("//div[@class='horizontal']//span[(text()='MECOX IN THE MEDIA')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//verify page
		String exp_msg = "Category: Mecox in The Media";
		WebElement text = driver.findElement(By.xpath("//h1[@class='page-title']"));
		String act_msg = text.getText();
		try {
			AssertJUnit.assertEquals(exp_msg, act_msg);

		}catch(AssertionError e)
		{
			System.out.println(e);
		}
		System.out.println(text.getText());
		driver.close();driver.quit();
	}

}
