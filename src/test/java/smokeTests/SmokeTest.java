package smokeTests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AdverseEventPage;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import pages.LogNewReportPage;


public class SmokeTest{
	
	private WebDriver driver;
	private String adminURL;
	private static final Logger log = LogManager.getLogger(SmokeTest.class.getName());
	//private String publicURL;//This will be implemented later
	private String contactCentreUserName = "automation.operative@m3test.com";
	public static String siteUserName = "";
	private String contactCentrePassword = "Test12345";
	private String reporterFirstName = "Tester F";
	private String reporterSurname = "Tester S";
	private String reporterType_RelationshipToPatient = "Medical Doctor";
	private String reporterCompanyAwareDate = "01 Sep 2014";
	private String reporterPatientId = "DCA-5003025-XCV";
	private String reporterOtherReference = "SST001SMOKE";
	private String productComplaint = "This is the Contact Centre smoke test to test the product complaint export generation.";
	private String Product1 = "Mymedaject";
	private String Product2 = "Lithium";
	private String changeOfCountry = "Malaysia";
	private String diagnosisAdverseEvent1 = "Headache";

	
	@Parameters("browserType")
  @BeforeClass
  public void beforeClass(String browserType) {
	  
	if(browserType.equals("chrome")){
		log.info("~~~~~~~~~~~~~~~~~~~~~~~~~Test in Chrome Browser~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.setProperty("webdriver.chrome.driver", "C:\\AutoTest\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	else if(browserType.equals("firefox")){
		log.info("~~~~~~~~~~~~~~~~~~~~~~~~~Test in Firefox Browser~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.setProperty("webdriver.gecko.driver", "C:\\Automation\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	adminURL = "https://aapharma-val.mymedsandme.net/admin";		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(adminURL);
  }
  
  @Test
  public void loginAsContactCentreUserTest(){
	  log.info("======================Test Started======================");
	  log.info("Test for Log in as Contact Centre User Test");
	  LoginPage.typeUserName(driver, contactCentreUserName);
	  LoginPage.typePassword(driver, contactCentrePassword);
	  LoginPage.clickOnLogInButton(driver);
	  Assert.assertEquals(HomePage.logoutButton(driver).isDisplayed(), true);
	  log.info("Assert if Logout Button is present");
	  log.info("======================Test Ended======================");
  }
 
  @Test (dependsOnMethods={"loginAsContactCentreUserTest"})
  public void navigateToLogOnReportPageTest(){
	  log.info("======================Test Started======================");
	  log.info("Test to Navigate to Log on Report Page");
	  //LoginPage.signInAsAContactCentreUser(driver, contactCentreUserName, contactCentrePassword);
	  
	  HomePage.clickOnLogANewReportButton(driver);
	  Assert.assertEquals(driver.getTitle(), "Log a new report - SafeTrack");  
	  log.info("Assert if Title is - Log a new report - SafeTrack");
	  log.info("======================Test Ended======================");
  }
  
  @Test (dependsOnMethods={"navigateToLogOnReportPageTest"})
  public void fillLogANewReportPageTest() {
	  log.info("======================Test Started======================");
	  log.info("Test to Fill Log a New Report Page");
	  //LoginPage.signInAsAContactCentreUser(driver, contactCentreUserName, contactCentrePassword);
	  //HomePage.clickOnLogANewReportButton(driver);
	  
	  LogNewReportPage.clickOnReportingOptionRadioButton(driver);
	  LogNewReportPage.enterReporterFirstName(driver, reporterFirstName);
	  LogNewReportPage.enterReporterSurname(driver, reporterSurname);
	  LogNewReportPage.selectReporterType(driver, reporterType_RelationshipToPatient);
	  LogNewReportPage.verifyTypeOfReportIsChecked(driver);
	  LogNewReportPage.enterCompanyAwareDate(driver, reporterCompanyAwareDate);
	  LogNewReportPage.enterPatientId(driver, reporterPatientId);
	  LogNewReportPage.enterOtherReference(driver, reporterOtherReference);
	  LogNewReportPage.checkProductComplaintReport(driver);
	  LogNewReportPage.enterProductComplaint(driver, productComplaint);
	  LogNewReportPage.clickOnNextButtonOnLogNewReportPage(driver);
	  // Assert.assertEquals(driver.getTitle(), "Adverse Events - SafeTrack");
 
	  log.info("Assert if Title is - Adverse Events - Safe Track");
	  log.info("======================Test Ended======================");	  
  }
  
  @Test (dependsOnMethods={"fillLogANewReportPageTest"})
  public void fillAdverseEventPage() throws InterruptedException {
	  
	  AdverseEventPage.confirmAge(driver);
	  Assert.assertEquals(driver.getTitle(), "Adverse Events - SafeTrack");
	  log.info("Assert if Title is - Adverse Events - Safe Track");
	 
	AdverseEventPage.enterSuspectProduct1(driver, Product1);
	AdverseEventPage.enterSuspectProduct2(driver, Product2);
	AdverseEventPage.clickOnAddAnotherProductButton(driver);	
	AdverseEventPage.clickChangeCountry(driver);
	
	boolean elementPresent = driver.findElement(By.cssSelector("span[class='product_country_dropdown m-field']")).isDisplayed();
	//System.out.println(elementPresent);
			
	AdverseEventPage.selectChangeCountry(driver, changeOfCountry);
	AdverseEventPage.clickSaveButton(driver);
	AdverseEventPage.enterDiagnosisAdverseEvent1(driver,diagnosisAdverseEvent1);
	System.out.println("clicked");
	AdverseEventPage.addAnotherAEButton1(driver);
	
	
	//Assert
	String eventValue = driver.findElement(By.xpath("//span[@class='m-field m-field-readonly']/input")).getText();
	System.out.println(eventValue);
	
	  log.info("======================Test Ended======================");  
  }
  
  @AfterMethod
  public void afterClass() {
	  //driver.quit();
  }
  

}
