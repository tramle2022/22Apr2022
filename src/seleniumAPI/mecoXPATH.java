package seleniumAPI;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class mecoXPATH {
	
	public static void main(String[] args) {
		//settings driver
	System.setProperty("webdriver.chrome.driver", "/home/ces-user/Downloads/soft/chromedriver_linux64/chromedriver");

	//create web driver instance
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://flywheel:mecoxclone@mecoxcloud.flywheelstaging.com/");
	driver.manage().window().maximize();
	
	/*
	 * //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 * //driver.findElement(By.xpath("")) //hover menu //WebElement ele =
	 * driver.findElement(By.
	 * xpath("//body/div[@id='page']/header[@id='masthead']/div[contains(@class,'site-branding')]/div[contains(@class,'yc-header-builder-content header-fixed')]/section[@id='desktop-section']/div[@id='mecox-desktop-menu']/div[contains(@class,'wpb_column vc_column_container vc_col-sm-5')]/div[contains(@class,'vc_column-inner')]/div[contains(@class,'wpb_wrapper')]/div[contains(@class,'mega-items-column-equal')]/div[@class='horizontal']/ul[@id='menu-header-menu-left']/li[@id='menu-item-191397']/a[@class='item-has-icon icon-position-left']/span[1]"
	 * )); //div[@class='horizontal']//descendant::a//span[(text()='FURNITURE')]
	 * //WebElement ele = driver.findElement(By.
	 * xpath("//body/div[@id='page']/header[@id='masthead']/div[contains(@class,'site-branding')]/div[contains(@class,'yc-header-builder-content header-fixed')]/section[@id='desktop-section']/div[@id='mecox-desktop-menu']/div[contains(@class,'wpb_column vc_column_container vc_col-sm-5')]/div[contains(@class,'vc_column-inner')]/div[contains(@class,'wpb_wrapper')]/div[contains(@class,'mega-items-column-equal')]/div[@class='horizontal']/ul[@id='menu-header-menu-left']/li[@id='menu-item-191397']/a[@class='item-has-icon icon-position-left']/span[1]"
	 * ));
	 */	
	
	WebElement ele = driver.findElement(By.xpath("//div[@class='horizontal']//descendant::a//span[(text()='FURNITURE')]"));
	Actions action = new Actions(driver);
	action.moveToElement(ele).perform();
	/*
	 * //Creating object of an Actions class //Actions action = new Actions(driver);
	 * //Performing the mouse hover action on the target element.
	 * //action.moveToElement(ele).perform();
	 */	
	
	
	//select Dressers & chest
	driver.findElement(By.xpath("//div[@class='horizontal']//span[contains(text(),'DRESSERS AND CHESTS')]")).click();
	
	//select item
	driver.findElement(By.xpath("//h2[contains(normalize-space(), \"Turner Veneer Dresser\")]")).click();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	//add item
	driver.findElement(By.xpath("//button[@name='add-to-cart']")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//driver.navigate().refresh();
	
	//view & check cart
	driver.findElement(By.xpath("//a[normalize-space()='View cart']")).click();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	/*
	 * WebElement getsubTotal = driver.findElement(By.xpath(
	 * "//tr[@class='cart-subtotal']//following-siblling::td/bdi"));
	 * getsubTotal.getText(); System.out.println("Subtotal: "+ getsubTotal);
	 */
	
	// Cart total: Subtotal, Shipping, Total
	System.out.println("Subtotal: "+driver.findElement(By.xpath("//tr[@class='cart-subtotal']//following-sibling::td//bdi")).getText());
	System.out.println("Shipping:" +driver.findElement(By.xpath("//p[contains(text(),'Estimated shipping costs will be shown in checkout')]")).getText());
	System.out.println("Total:" + driver.findElement(By.xpath("//tr[@class='order-total']//following-sibling::td//bdi")).getText());

	driver.close();
	driver.quit();
	}

}
