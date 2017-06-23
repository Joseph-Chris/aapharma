package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.UtilWaitType;
import utils.UtilFindElement;

public class LoginPage {
	
	public static WebElement element = null;
	private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

	public static WebElement usernameTextBox(WebDriver driver){
		//element	= driver.findElement(By.id("user_email"));
		element = UtilFindElement.findElement(driver, "id", "user_email");
		log.info("Locating the User Name Text Box");
		return element;
	}
	
	public static void typeUserName(WebDriver driver, String userName) {
		element = usernameTextBox(driver);
		element.clear();
		element.sendKeys(userName);
		log.info("Type User Name as " + userName);
	}
	
	public static WebElement passwordTextBox(WebDriver driver){
		element = driver.findElement(By.id("user_password"));
		log.info("Locating the Password text box");
		return element;
	}

	public static void typePassword(WebDriver driver, String password) {
		element = passwordTextBox(driver);
		element.clear();
		element.sendKeys(password);
		log.info("Type Password as " + password);
	}

	public static void clickOnLogInButton(WebDriver driver){
		element = UtilWaitType.getWhenElementVisible(driver, By.id("login_button"), 30);
		element.click();
		log.info("Click on the Login Button");
	}

	public static void signInAsAContactCentreUser(WebDriver driver, String userName, String password){
		usernameTextBox(driver).sendKeys(userName);
		passwordTextBox(driver).sendKeys(password);
		clickOnLogInButton(driver);
		log.info("Sign is a Contact Centre user - " + userName);
	}
}
