package seleniumAPI;

import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Topic11_Ex07 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		 //get url
		 driver.get("http://juggle:Juggl3F1sh@dev.juggle.codeenginestudio.com");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
		 WebElement sub_btn = driver.findElement(By.xpath("//button[@type='submit']"));
		 if(sub_btn.isEnabled()==false)
		 {
			System.out.println("Button is disable"); 
		 }
		 else
		 {
			System.out.println("Button is enable"); 
		 }
		 
			String uid = "tram.le@codeenginestudio.com", pw = "123456" ;
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys(uid);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pw);
			if(sub_btn.isEnabled()==false)
			 {
				System.out.println("Button is disable"); 
			 }
			 else
			 {
				System.out.println("Button is enable"); 
			 }
			//driver.findElement(By.xpath("//button[@type='submit']"))
			 String buttonColor = sub_btn.getCssValue("background-color");
		     System.out.println("Button color: " + buttonColor);

			 //String buttonTextColor = driver.findElement(By.name("submit")).getCssValue("color");
		     //System.out.println("Text color " + buttonTextColor);
		    sub_btn.click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			String actualUrl="http://juggle:Juggl3F1sh@dev.juggle.codeenginestudio.com/";
			String expectedUrl= driver.getCurrentUrl();
			try {
				AssertJUnit.assertEquals(expectedUrl,actualUrl);
			 }catch(AssertionError e)
			 {
				 String msgerr = e.getMessage();
				 System.out.println(msgerr);
			 }
			
			
			driver.close();
			driver.quit();
	}
}
