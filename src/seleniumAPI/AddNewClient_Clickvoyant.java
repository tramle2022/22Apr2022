package seleniumAPI;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewClient_Clickvoyant {
	public static void main (String[] args) {
		
			System.setProperty("webdriver.chrome.driver","/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");

		  //turn off security google 
			ChromeOptions options = new ChromeOptions();
		//	my_options.add_argument( '--disable-blink-features=AutomationControlled' )
			options.addArguments("disable-blink-features=Automation Controlled");
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			
			// disable the save password popup in Google Chrome 
			options.addArguments("--lang=en-us");
			options.addArguments("--start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--no-proxy-server");
		//	options.addArguments("--user-data-dir");
			options.addArguments("--allow-running-insecure-content");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			
			WebDriver driver =  new ChromeDriver(options);
		
			String currentURL = "https://development.clickvoyant.com/login";
			//Navigate to web page
			driver.get(currentURL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			String email = "tram2022@mailinator.com", pw="Abc@1234";
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pw);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
			
			driver.findElement(By.xpath("//span[text()='Add New Client']")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			//step1
			String clientName = "tram'sclient1", reportName = "report1";
			driver.findElement(By.xpath("//input[@name='clientName']")).sendKeys(clientName);
			driver.findElement(By.xpath("//div[@class='active']//child::button[normalize-space()='Add']")).click();
			driver.findElement(By.xpath("//input[@name='performanceReportName']")).sendKeys(reportName);
			driver.findElement(By.xpath("//div[@class='active']//child::button[normalize-space()='Add']")).click();
			driver.findElement(By.xpath("//button[text()='Next']")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			//step2
			driver.findElement(By.xpath("//div[@class='modal-body']//div[1]//button[1]")).click();
		
		 	String parentWindow = driver.getWindowHandle();     
		 	System.out.println("Parent Window ID is : " + parentWindow);
		    //click button login with google
		    //function wait
		    WebDriverWait wait = new WebDriverWait(driver,5);
		    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		    
		     //get list window
		    Set<String> s1 = driver.getWindowHandles();
		    Iterator<String> i1 = s1.iterator();
		    while(i1.hasNext())
		    {
		        String next_tab = i1.next();
		        if (!parentWindow.equalsIgnoreCase(next_tab))
		        {
		            driver.switchTo().window(next_tab);
		            System.out.println("Working on Google Login Box");
		            WebDriverWait wait2 = new WebDriverWait(driver, 20);
		            wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']"))).sendKeys("tram.le@codeenginestudio.com");
		        }
		    }
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//div[@class='qhFLie']//child::button[@type='button']")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			WebElement usname_btn = driver.findElement(By.xpath("//input[@name='password']"));
			usname_btn.sendKeys("Tram@2022");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			/*
			 * WebElement pw_btn = driver.findElement(By.xpath(
			 * "//div[@class='qhFLie']//child::button[@type='button']"));
			 * if(pw_btn.isDisplayed()==true) { System.out.println("co button roi nghe");
			 * }else { System.out.println("khogn co cai gi ca"); } pw_btn.click();
			 */

			/*
			 * try { WebElement pw_btn = driver.findElement(By.xpath(
			 * "//div[@class='qhFLie']//child::button[@type='button']")); pw_btn.click();
			 * if(pw_btn.isDisplayed()==true) { System.out.println("co button roi nghe");
			 * }else { System.out.println("khogn co cai gi ca"); } }
			 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
			 * System.out.println("Error = "+ ex); }
			 */
			  WebDriverWait w1 = new WebDriverWait(driver, 100);
			  WebElement element = w1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='qhFLie']//child::button[@type='button']"))); 
			  ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
			
			
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			driver.switchTo().window(parentWindow);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@id='data-source-name']")).sendKeys("gga");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			 WebDriverWait w2 = new WebDriverWait(driver, 100);
			  WebElement element2 = w2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='eCommerce']"))); 
			  ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element2);
			
		//	driver.findElement(By.xpath("//button[text()='eCommerce']")).click();
			driver.findElement(By.xpath("//button[text()='Next Step']")).click();
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//span[text()='Demo Account']")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//span[text()='UA - Google Merchandise Store']")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			driver.findElement(By.xpath("//span[text()='1 Master View']")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//span[text()='Transactions']")).click();
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			
			WebDriverWait wait3 = new WebDriverWait(driver,60);
			WebElement aboutMe;
			aboutMe= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Engaged Users']")));     
			aboutMe.click();
			//driver.findElement(By.xpath("//span[text()='Engaged Users']")).click();
			
			WebDriverWait w3 = new WebDriverWait(driver, 100);
			WebElement element3 = w3.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Next Step']"))); 
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element3);
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//button[text()='Confirm and Analyze']")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//driver.switchTo().window(next_tab);
			driver.findElement(By.xpath("//button[text()='Skip']")).click();
			driver.findElement(By.xpath("//button[text()='Confirm']")).click();
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		//	driver.switchTo().window(next_tab);

			driver.findElement(By.xpath("//div[@class='action-group']//button[text()='Skip']")).click();
			driver.findElement(By.xpath("//div[@class='action-group']//button[text()='Confirm']")).click();

	}
}


