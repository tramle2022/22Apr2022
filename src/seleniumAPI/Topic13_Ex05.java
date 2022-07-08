package seleniumAPI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Topic13_Ex05 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//right click
		WebElement btn = driver.findElement(By.xpath("//span[text()='right click me']"));
		WebElement sub_quit = driver.findElement(By.xpath("//span[text()='Quit']"));
		Actions action = new Actions(driver);
		action.contextClick(btn).build().perform();
		//move to submenu & click
		action.moveToElement(sub_quit).build().perform();
		sub_quit.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//get text & close alert
		Alert alert = driver.switchTo().alert(); String msg = alert.getText();
		System.out.println("Text of alert = "+msg); alert.accept();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
		driver.close();driver.quit();
	}
}
