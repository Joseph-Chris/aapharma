package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.UtilWaitType;

public class HomePage {
	
	public static WebElement element = null;
	private static final Logger log = LogManager.getLogger(HomePage.class.getName());

	public static WebElement logoutButton(WebDriver driver) {
		element = driver.findElement(By.id("logout"));
		log.info("Logout button Element found");
		return element;	
		
	}
	
	public static void clickOntheLogOutButton(WebDriver driver){
		element = logoutButton(driver);
		element.click();
	}

	public static WebElement logANewReportButton(WebDriver driver){
		element = driver.findElement(By.linkText("Log a new Report"));
		return element;
	}
	
	public static void clickOnLogANewReportButton(WebDriver driver){
		UtilWaitType.getWhenElementClickable(driver, By.linkText("Log a new Report"), 30).click();
		log.info("Clicked on Log a new report button");
	}

}
