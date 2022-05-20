package seleniumAPI;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class juggleFish {

	public static void main (String[] arg) {
	//get url
	System.setProperty("webdriver.chrome.driver", "/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.get("http://juggle:Juggl3F1sh@dev.juggle.codeenginestudio.com/login");
	driver.getCurrentUrl();
	driver.manage().window().maximize();
	
	String Url = driver.getCurrentUrl();
	if (Url.equals("http://juggle:Juggl3F1sh@dev.juggle.codeenginestudio.com/login")) 
		{
		System.out.println("Right URL Login ");
			} else {
				System.out.println("Wrong URL Login");
			}

	
	//login
	//driver.findElement(By.xpath(""));
	String uid = "tram.le@codeenginestudio.com", pw = "123456" ;
	driver.findElement(By.xpath("//input[@type='email']")).sendKeys(uid);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pw);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	//find profile setting
	driver.findElement(By.xpath("//button[@data-testid='profile-button']")).click();
	driver.findElement(By.xpath("//li[@data-testid='Workspace Settings']")).click();	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	String Url2 = driver.getCurrentUrl();
	if (Url2.equals("http://juggle:Juggl3F1sh@dev.juggle.codeenginestudio.com/admin-setting")) 
//	if (Url2.equals("http://dev.juggle.codeenginestudio.com/admin-setting")) 
		{
		System.out.println("Right URL of Work Space");
			} else {
				System.out.println("Wrong URL of Work Space");
			}
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	//find People
	driver.findElement(By.xpath("//a[@title='Users']")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	String Url3 = driver.getCurrentUrl();
	//http://juggle:Juggl3F1sh@dev.juggle.codeenginestudio.com/resources
	if (Url3.equals("http://juggle:Juggl3F1sh@dev.juggle.codeenginestudio.com/resources")) 
			{
			System.out.println("Right URL of People");
				} else {
					System.out.println("Wrong URL of People");
				}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.quit();
		

	}
	
}
