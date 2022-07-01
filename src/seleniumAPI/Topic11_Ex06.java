package seleniumAPI;

import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Topic11_Ex06 {
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
	WebDriver driver = new ChromeDriver();
	 //get url
	 driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm3");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 
	 //click button Try it
	 driver.switchTo().frame("iframeResult");
	 driver.findElement(By.xpath("//button[normalize-space()='Try it']")).click();
	
	 //click cancel popup
	 Alert alert = driver.switchTo().alert(); 
	 String msg = alert.getText(); 
	 System.out.println(msg);
	 alert.dismiss();
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 
	 //get result 
	 String result = driver.findElement(By.xpath("//p[@id='demo']")).getText();
	 System.out.println(result);
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	 //navigate to other url
	 driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 
	 //click button Try it
	 driver.switchTo().frame("iframeResult");
	 driver.findElement(By.xpath("//button[normalize-space()='Try it']")).click();
	 
	//Wait for the alert to be displayed and store it in a variable, then compare with result
	 Alert alert1 = driver.switchTo().alert(); 
	 String abc1 = "Harry Porter";
	 alert1.sendKeys(abc1);
	 alert1.accept();
	 driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	 String result1 = driver.findElement(By.xpath("//p[@id='demo']")).getText();
	
	 try {
		 AssertJUnit.assertEquals(abc1, result1);
	 }catch(AssertionError e)
	 {
		 String msgerr = e.getMessage();
		 System.out.println(msgerr);
	 }
	driver.close();
	driver.quit();
	}
}
