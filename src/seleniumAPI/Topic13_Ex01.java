package seleniumAPI;

import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Topic13_Ex01 {
	public static void main(String[] arg) {
		System.setProperty("webdriver.chrome.driver","/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		WebElement txtbox = driver.findElement(By.xpath("//input[@id='age']"));
		String tooltip = txtbox.getAttribute("title");
		System.out.println("Tooltip is = "+tooltip);
		
		Actions action = new Actions(driver);
		action.moveToElement(txtbox).perform();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		String expectMsg = "We ask for your age only for statistical purposes.";
		try 
			{
				AssertJUnit.assertEquals(expectMsg, tooltip);
		 		}catch(AssertionError e)
		 		{
		 		String msgerr = e.getMessage();
		 		System.out.println(msgerr);
		 	}
		driver.close();driver.quit();

		
	}
}
