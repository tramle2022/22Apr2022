package seleniumAPI;

import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class mecoXHANDLE_TBTA {
	public static void main(String[] args) {

		// initialize browser
		System.setProperty("webdriver.chrome.driver",
				"/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://flywheel:mecoxclone@mecoxcloud.flywheelstaging.com/");
		driver.manage().window().maximize();

		// add 1st item
		WebElement ele = driver
				.findElement(By.xpath("//div[@class='horizontal']//descendant::a//span[(text()='FURNITURE')]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath("//div[@class='horizontal']//span[contains(text(),'DRESSERS AND CHESTS')]"))
				.click();
		// select item
		driver.findElement(By.xpath("//h2[contains(normalize-space(), \"Turner Veneer Dresser\")]")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// add item
		driver.findElement(By.xpath("//button[@name='add-to-cart']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// add 2nd item
		driver.findElement(By.xpath("//div[@class='horizontal']//descendant::a//span[(text()='MECOX COLLECTION')]"))
				.click(); // select Dressers & chest
		// select item
		driver.findElement(By.xpath("//h2[normalize-space()='Colby Teak and Woven Desk']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// input quantity
		driver.findElement(By.xpath(" //span[@class='yc-advance-icon quantity-plus noselect']")).click();
		// add item
		driver.findElement(By.xpath("//button[@name='add-to-cart']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.navigate().refresh();

		// view & check cart
		driver.findElement(By.xpath("//a[normalize-space()='View cart']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(normalize-space(),'Proceed to checkout')]")).click();

		String fname = "Tram Test", lname = "Pls ignore", company = "CES Corp", country = "US",
				add = "34 Nguyen ba hoc", city = "San Jose", state = "California", postcode = "96024",
				phone = "123456789", email = "tram.le+123@codeenginestudio.com", color = "white";

		// billing details
		driver.findElement(By.xpath("//input[@id='billing_first_name']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@id='billing_last_name']")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@id='billing_company']")).sendKeys(company);
		// select country
		Select countryddl = new Select(driver.findElement(By.xpath("//select[@id='billing_country']")));
		countryddl.selectByValue(country);
		driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys(add);
		driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys(city);
		// select state
		Select stateddl = new Select(driver.findElement(By.xpath("//select[@id='billing_state']")));
		stateddl.selectByVisibleText(state);
		driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys(postcode);
		driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys(email);
		driver.findElement(By.xpath("//textarea[@id='order_comments']")).sendKeys(color);

		// back to previous page
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// input over allow quantity
		driver.findElement(
				By.xpath("//input[@type='number' and @aria-labelledby='Colby Teak and Woven Desk quantity']")).clear();
		driver.findElement(
				By.xpath("//input[@type='number' and @aria-labelledby='Colby Teak and Woven Desk quantity']"))
				.sendKeys("20");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@name='update_cart']")).click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		/*
		 * Actions actions = new Actions (driver); WebElement element =
		 * driver.findElement(By.xpath("//button[@name='update_cart']"));
		 * actions.click(element).perform();
		 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); WebElement
		 * toolTips = driver.findElement(By.xpath("//input[@type='number']"));
		 * System.out.println("Tool tip :"+toolTips.getText());
		 */
		// Get error message
		String expectedValMsg = "Value must be less than or equal to 18.";

		WebElement elen = driver.findElement(
				By.xpath("//input[@type='number' and @aria-labelledby='Colby Teak and Woven Desk quantity']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Boolean isValidInput = (Boolean) js.executeScript("return arguments[0].checkValidity();", elen);
		System.out.println(isValidInput);
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", elen);
		System.out.println(validationMessage);

		AssertJUnit.assertEquals(expectedValMsg, validationMessage);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// update right value
		
		  driver.findElement(By.
		  xpath("//input[@type='number' and @aria-labelledby='Colby Teak and Woven Desk quantity']")).clear(); driver.findElement(By.
		  xpath("//input[@type='number' and @aria-labelledby='Colby Teak and Woven Desk quantity']")).sendKeys("3");
		  driver.findElement(By.xpath("//button[@name='update_cart']")).click();
		  driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		 

		// checkout again
		driver.findElement(By.xpath("//a[contains(normalize-space(),'Proceed to checkout')]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// clear old value billing
		driver.findElement(By.xpath("//input[@id='billing_first_name']")).clear();
		driver.findElement(By.xpath("//input[@id='billing_last_name']")).clear();
		driver.findElement(By.xpath("//input[@id='billing_company']")).clear();
		driver.findElement(By.xpath("//*[@id='select2-billing_country-container']")).clear();
		driver.findElement(By.xpath("//input[@id='billing_address_1']")).clear();
		driver.findElement(By.xpath("//input[@id='billing_city']")).clear();
		driver.findElement(By.xpath("//*[@id='select2-billing_state-container']")).clear();
		driver.findElement(By.xpath("//select[@id='billing_state']")).clear();
		driver.findElement(By.xpath("//input[@id='billing_postcode']")).clear();
		driver.findElement(By.xpath("//input[@id='billing_phone']")).clear();
		driver.findElement(By.xpath("//input[@id='billing_email']")).clear();
		driver.findElement(By.xpath("//textarea[@id='order_comments']")).clear();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.quit();
		driver.close();

	}
}
