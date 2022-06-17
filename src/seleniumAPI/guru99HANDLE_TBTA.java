package seleniumAPI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;

public class guru99HANDLE_TBTA {
	public static void main (String[] args) {
		System.setProperty("webdriver.chrome.driver","/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		//Navigate to web page
		driver.get("https://www.demo.guru99.com/v4/");
				
		//Maximizing window
		driver.manage().window().maximize();
				
		//Putting implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	   	//login 
		String uid = "mngr416587", password = "aretAbu" ;
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(uid);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
				
		//Putting implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Navigate to New Customer
		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

		//create new customer
		String username ="tram", dob = "12121992", add="32 Nguyen Ba Hoc", city="Danang", 
			   state ="Alahabama", pin="123456", phone="123456789", 
			   email="tram_test10@yopmail.com", pw = "123456";
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@value='f']")).click();
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(dob);
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(add);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(pin);
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pw);
		
	//	driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("011191");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='sub']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		/*
		 * Alert alert = driver.switchTo().alert(); // switch to alert
		 * driver.switchTo().alert().dismiss();
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 */

		String cusId = driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]")).getText();
		driver.findElement(By.xpath("//a[contains(text(),'Edit Customer')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(cusId);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//textarea[@name='addr']")).clear();
		String l_add = driver.findElement(By.xpath("//label[@id='message3']")).getText();
		AssertJUnit.assertEquals("Address Field must not be blank", l_add);
		
		driver.findElement(By.xpath("//input[@name='city']")).clear();
		String l_city = driver.findElement(By.xpath("//label[@id='message4']")).getText();
		AssertJUnit.assertEquals("City Field must not be blank", l_city);
		
		driver.findElement(By.xpath("//input[@name='state']")).clear();
		String l_state = driver.findElement(By.xpath("//label[@id='message5']")).getText();
		AssertJUnit.assertEquals("State must not be blank", l_state);
		
		driver.findElement(By.xpath("//input[@name='pinno']")).clear();
		String l_pin = driver.findElement(By.xpath("//label[@id='message6']")).getText();
		AssertJUnit.assertEquals("PIN Code must not be blank", l_pin);
		
		driver.findElement(By.xpath("//input[@name='telephoneno']")).clear();
		String l_phone = driver.findElement(By.xpath("//label[@id='message7']")).getText();
		AssertJUnit.assertEquals("Mobile no must not be blank", l_phone);
		
		driver.findElement(By.xpath("//input[@name='emailid']")).clear();
		String l_email = driver.findElement(By.xpath("//label[@id='message9']")).getText();
		AssertJUnit.assertEquals("Email-ID must not be blank", l_email);
		
		driver.quit();

	}
}
