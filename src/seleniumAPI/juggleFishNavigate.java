package seleniumAPI;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class juggleFishNavigate {
	public static void main (String args[]) {
		System.setProperty("webdriver.chrome.driver", "/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://juggle:Juggl3F1sh@dev.juggle.codeenginestudio.com");
		driver.manage().window().maximize();
		//login page
		String text1 = driver.findElement(By.xpath("//div[@class='Authentication__Title-m0mmlm-2 hJmCmu']")).getText();
		System.out.println("you are at: "+text1+" page");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		//signup page
		driver.findElement(By.xpath("//a[contains(normalize-space(),'sign up')]")).click();
		String text2 = driver.findElement(By.xpath("//div[@class='SignupForm__Title-ux6vfh-2 dtDYVx']")).getText();
		System.out.println("you are at: "+text2+" page");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//navigate back login page
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String text3 = driver.findElement(By.xpath("//div[@class='Authentication__Title-m0mmlm-2 hJmCmu']")).getText();
		System.out.println("you are at: "+text3+" page, again!");
		driver.close();
	}

}
