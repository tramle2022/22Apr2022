package seleniumAPI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class Topic13_Ex03 {
	public static void main(String[] arg) {
		System.setProperty("webdriver.chrome.driver","/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//switch iframe
		driver.switchTo().frame(0);
		WebElement txt_box1 = driver.findElement(By.xpath("//li[(text()='Item 2')]"));
		WebElement txt_box7 = driver.findElement(By.xpath("//li[(text()='Item 7')]"));
		//click&hold item 2-7
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.clickAndHold(txt_box1).build().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		action.clickAndHold(txt_box7).build().perform();
		action.release(txt_box7).perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//show items which selected at previous step
		 List<WebElement> m = driver.findElements(By.xpath("//li[contains(@class, 'ui-selected')]"));
		 // iterate over list
	      for(int i = 0; i< m.size(); i++) {
	         //obtain text
	         String s = m.get(i).getText();
	         System.out.println("Item was selected is: " + s);
	      }
		
		driver.close();
		driver.quit();
}
}
