package seleniumAPI;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Topic13_Ex04 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//switch iframe
		driver.switchTo().frame(0);
		WebElement txt_box1 = driver.findElement(By.xpath("//li[(text()='Item 1')]"));
		WebElement txt_box3 = driver.findElement(By.xpath("//li[(text()='Item 3')]"));
		WebElement txt_box5 = driver.findElement(By.xpath("//li[(text()='Item 5')]"));
		WebElement txt_box7 = driver.findElement(By.xpath("//li[(text()='Item 7')]"));
		//Click and hold 1, 3, 5, 7
		Actions action = new Actions(driver);
		action.moveToElement(txt_box1).click().build().perform();
		action.keyDown(Keys.CONTROL).build().perform();
		action.moveToElement(txt_box3).click().build().perform();
		action.moveToElement(txt_box5).click().build().perform();
		action.moveToElement(txt_box7).click().build().perform();
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
