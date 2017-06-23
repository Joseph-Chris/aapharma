package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import smokeTests.SmokeTest;
import utils.UtilFindElement;
import utils.UtilWaitType;

public class LogNewReportPage {
	


	public static WebElement element = null;
	private static final Logger log = LogManager.getLogger(LogNewReportPage.class.getName());
		
	
	public static void clickOnReportingOptionRadioButton(WebDriver driver) {
		element = UtilWaitType.getWhenElementVisible(driver,By.xpath("html/body/div/main/form/div[1]/fieldset/div/div[1]/label/i"), 30);
	    element.click();
	    log.info("Selected on Reporting Option");
	}
	
	public static WebElement reporterFirstName(WebDriver driver) {
		element = driver.findElement(By.id("first_name"));
		return element;
	}

	public static void enterReporterFirstName(WebDriver driver, String firstName) {
		element = reporterFirstName(driver);
		element.clear();
		element.sendKeys(firstName);
		log.info("Reporter First Name entered " + firstName);
	}
	
	public static WebElement reporterSurname (WebDriver driver){
		element = driver.findElement(By.id("surname"));
		return element;
	}
	
	public static void enterReporterSurname(WebDriver driver, String surname ){
		element = reporterSurname(driver);
		element.clear();
		element.sendKeys(surname);
		log.info("Reporter Surname entered " + surname);
	}
	
	public static void selectReporterType(WebDriver driver, String reporterType){	
		//element = driver.findElement(By.id("relationship_to_patient"));
		element = UtilFindElement.findElement(driver, "id", "relationship_to_patient");
//		Select reporterTypeDropdown = new Select(element);
//		reporterTypeDropdown.selectByVisibleText(reporterType);
		UtilFindElement.dropDown(element, reporterType);
		log.info("Selected Reporter Type - " + reporterType + " from the Dropdown");
	}

	public static void verifyTypeOfReportIsChecked(WebDriver driver) {
		element = UtilFindElement.findElement(driver, "id", "customer_category_initial");
		element.isSelected();
		log.info("Initial Report is selected by default");
	}
	
	public static WebElement companyAwareDate (WebDriver driver){
	element = UtilFindElement.findElement(driver, "id", "company_aware_date");
	return element;
	}

	public static void enterCompanyAwareDate(WebDriver driver,String awareDate) {
		element = companyAwareDate(driver);
		element.clear();
		element.sendKeys(awareDate);
		log.info("Company Aware Date entered");		
	}
	
	public static WebElement patientId(WebDriver driver){
	 return element = UtilFindElement.findElement(driver, "id", "enrolment_number");
	}

	public static void enterPatientId(WebDriver driver, String idOfPatient) {
		element = patientId(driver);
		element.clear();
		element.sendKeys(idOfPatient);
		log.info("Patient ID entered");
	}
		
	public static WebElement otherReference (WebDriver driver){
	return element = UtilFindElement.findElement(driver, "id", "other_reference");
	}

	public static void enterOtherReference(WebDriver driver, String otrReference) {
	element = otherReference(driver);
	element.clear();
	element.sendKeys(otrReference);
	log.info("Other Reference entered");
	}
	
	public static WebElement productComplaintToReport(WebDriver driver){
	return element = UtilFindElement.findElement(driver, "id", "product_complaint_toggle_yes");
	}

	public static void checkProductComplaintReport(WebDriver driver) {
		//element = UtilFindElement.findElement(driver, "id", "product_complaint_toggle_yes");
		element = UtilWaitType.getWhenElementClickable(driver, By.xpath("html/body/div[1]/main/form/div[3]/div[3]/fieldset/div/label[1]/i"), 30);
		element.click();
		log.info("Product complaint to report checked");
	}
	
	public static WebElement describeProductComplaint(WebDriver driver){
		return element = UtilFindElement.findElement(driver, "id", "product_complaint");
		
	}

	public static void enterProductComplaint(WebDriver driver, String complaintDescription) {
		element = describeProductComplaint(driver);
		element.clear();
		element.sendKeys(complaintDescription);
		log.info("Complaint description entered");
		}

	public static void clickOnNextButtonOnLogNewReportPage (WebDriver driver){
	     //element = UtilFindElement.findElement(driver, "cssSelector", "btn btn-primary pull-right");
	   // element = UtilFindElement.findElement(driver, "xpath", "html/body/div[1]/main/form/div[4]/input");
	    UtilWaitType.getWhenElementClickable(driver, By.xpath("html/body/div[1]/main/form/div[4]/input"), 30).submit();
		//UtilWaitType.getWhenElementClickable(driver, By.cssSelector("input[type='submit']"), 30).submit();
		//element.click()
		//Thread.sleep(10000);
		
		log.info("Next button on the Log a New Report Page clicked");
		}
	
	
	
				
		
	
		

	

}
