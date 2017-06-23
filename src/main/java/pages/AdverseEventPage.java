package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.UtilFindElement;
import utils.UtilWaitType;

public class AdverseEventPage {
	
	public static WebElement element = null;
	private static final Logger log = LogManager.getLogger(AdverseEventPage.class.getName());

	public static void confirmAge(WebDriver driver) {
		UtilFindElement.findElement(driver, "xPath","//span[@class='m-button']").click();
		UtilFindElement.findElement(driver, "xPath", "//button[@class='m-button-theme m-button-next']").click();
		
		//Customised xpath :- //tagname[@attribute='value']
		//span[@class='m-button']
		//Customised cssSelector :- tagname[attribute='value']
	}
	
	public static WebElement suspectProduct1(WebDriver driver){
		element = UtilFindElement.findElement(driver, "id", "report_data_medications_primary_term_name");
		return element;
	}

	public static void enterSuspectProduct1(WebDriver driver, String suspectProduct1) throws InterruptedException {
		element = suspectProduct1(driver);
		element.clear();
		element.sendKeys(suspectProduct1);
		Thread.sleep(10000);
		//UtilFindElement.findElement(driver, "cssSelector", ".ui-autocomplete.ui-menu.ui-widget.ui-widget-content.ui-corner-all li:nth-child(1)").click();
		
       driver.findElement(By.cssSelector(".ui-autocomplete.ui-menu.ui-widget.ui-widget-content.ui-corner-all li:nth-child(1)")).click();
       Thread.sleep(10000);
       
 //      Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Add suspect product"));
//       String bodyText = driver.findElement(By.tagName("body")).getText();
//       Assert.assertTrue(bodyText, bodyText.contains("Add suspect product"));
		
		
	//	Thread.sleep(10000);
		
//		WebElement dropdownBox = driver.findElement(By.xpath("//ul[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']"));
//		
//		Thread.sleep(10000);
//		List<WebElement> results = dropdownBox.findElements(By.tagName("a"));
//		
//		int size = results.size();
//		
//		System.out.println("size = "+size);
//		
//		for(int i=0; i<size; i++){
//			System.out.println(results.get(i).getText());
		}

	public static WebElement suspectProduct2 (WebDriver driver) {
		//return element = UtilFindElement.findElement(driver, "id", "report_data_medications_additional_15689702635_term_name");
		//return element = UtilFindElement.findElement(driver, "className", "m-autosuggest ui-autocomplete-input");
		return element = UtilFindElement.findElement(driver, "Xpath", "html/body/div[3]/div[2]/form/div/main/div[1]/fieldset/div/div/div[1]/div[1]/fieldset/span/input");
		
	}
	
	public static void  enterSuspectProduct2(WebDriver driver, String suspectProduct2) throws InterruptedException{
		element = suspectProduct2(driver);
		element.clear();
		element.sendKeys(suspectProduct2);
		Thread.sleep(10000);
		//UtilFindElement.findElement(driver, "cssSelector", ".ui-autocomplete.ui-menu.ui-widget.ui-widget-content.ui-corner-all li:nth-child(1)").click();
		driver.findElement(By.cssSelector(".ui-autocomplete.ui-menu.ui-widget.ui-widget-content.ui-corner-all li:nth-child(1)")).click();
    }

	public static void clickOnAddAnotherProductButton(WebDriver driver) {
		element = UtilWaitType.getWhenElementVisible(driver, By.xpath("//button[@class='m-updater-add m-button-theme-light']"), 5);
		//By.xPath("//button[@class='"m-updater-add m-button-theme-light']")
		element.click();
			
	}

	public static void clickChangeCountry(WebDriver driver) {
		
		//element = UtilFindElement.findElement(driver, "linkText", "(Change Country)");
		//element = UtilFindElement.findElement(driver, "xPath", "(//a[@class='change_product_country'])[3]");
		//element = driver.findElement(By.xpath("(//a[@class='change_product_country'])[3]"));
		element = UtilWaitType.getWhenElementClickable(driver, By.xpath("(//a[@class='change_product_country'])[3]"), 10);
		element.click();
	}
	
	public static void selectChangeCountry(WebDriver driver, String countryName) {
		//element = UtilFindElement.findElement(driver, "cssSelector", "span[class='ui-selectmenu-icon ui-icon ui-icon-triangle-1-s']");
		element = UtilWaitType.getWhenElementVisible(driver, By.xpath("//span[@class='product_country_dropdown m-field']"), 10);
		element.click();
		element = driver.findElement(By.linkText(countryName));
		element.click();
		//element = driver.findElement(By.xpath("//span[@class='product_country_dropdown m-field']/select"));
		//Select dropDown = new Select(element);
		//dropDown.selectByVisibleText("Malaysia");
	}

	public static void clickSaveButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='m-button m-button-theme-light save_product_country']"));
		element.click();		
	}

	public static void enterDiagnosisAdverseEvent1(WebDriver driver, String diagnosisAdverseEvent1) throws InterruptedException {
		//element = driver.findElement(By.xpath("(//span[@class='m-field'])[4]"));
		element = driver.findElement(By.xpath("html/body/div[3]/div[2]/form/div/main/fieldset[3]/div/div[1]/div[1]/fieldset/span/input"));
		element.click();
		element.clear();
		element.sendKeys(diagnosisAdverseEvent1);
		Thread.sleep(10000);		
		driver.findElement(By.cssSelector(".ui-autocomplete.ui-menu.ui-widget.ui-widget-content.ui-corner-all li:nth-child(1)")).click();
		Thread.sleep(10000);
		
	}

	public static void addAnotherAEButton1(WebDriver driver) {
		//ement =UtilWaitType.getWhenElementClickable(driver,By.cssSelector("m-button-theme-light m-updater-add"), 10);
		//html/body/div[3]/div[2]/form/div/main/fieldset[3]/div/div[1]/div[2]/button[2]
		element = UtilWaitType.getWhenElementClickable(driver, By.xpath("html/body/div[3]/div[2]/form/div/main/fieldset[3]/div/div[1]/div[2]/button[2]"), 10);
		element.click();


	}
	
	
	
	
		//UtilFindElement.findElement(driver, "cssSelector", ".ui-autocomplete.ui-menu.ui-widget.ui-widget-content.ui-corner-all li:nth-child(1)").click();
		//Assert.assertTrue(isDisplayed(),"Add suspect product");
		//log.info("Suspect Product 1 entered");
		
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Add suspect product"));
		//Assert.assertTrue(UtilFindElement.findElement(driver, "tagName", "body")).getText().contains(" Add suspect product")); - How to verify Tagname?
		//why do you want to return something?
		
	}
	
//	public static WebElement product1EditButton(){
//		return element = UtilFindElement.findElement(driver, attribute, value);
//	}





