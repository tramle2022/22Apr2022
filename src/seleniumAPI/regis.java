package seleniumAPI; 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class regis {

	public static void main(String[] args) {
		//Setting the driver path
		System.setProperty("webdriver.chrome.driver", "/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
				
		//Creating WebDriver instance
		WebDriver driver = new ChromeDriver();
				
		//Navigate to web page
		driver.get("https://www.demo.guru99.com/v4/");
				
		//Maximizing window
		driver.manage().window().maximize();
				
		//Putting implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	   	//login 
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr403042");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("saqUvEs");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
				
		//Putting implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Navigate to New Customer
		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

		//create new customer
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Tram Le");
		driver.findElement(By.xpath("//input[@value='f']")).click();
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("011191");
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("34 nguyen ba hoc");;
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Da nang");;
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("danang");;
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys("123456");;
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys("0901000007");;
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("abc01@yopmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abc123");;
		driver.findElement(By.xpath("//input[@name='sub']")).click();
				
		//Continue checking the xpath of element in New Customer after here
		//Assert.assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
	//	Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),\"Customer Registered Successfully!!!\")]")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.quit();
		driver.close();
		}	

}




