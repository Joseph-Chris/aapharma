package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UtilFindElement {
	
	
	public static WebElement findElement(WebDriver driver, String attribute, String value){
		
		attribute = attribute.toLowerCase();
		
		if(attribute.equals("id")){
			return driver.findElement(By.id(value));	
		}
		else if(attribute.equals("xpath")){
			return driver.findElement(By.xpath(value));
		}
		else if(attribute.equals("linktext")){
			return driver.findElement(By.linkText(value));
		}
		else{
			return null;
		}
		
	}
	
	public static void dropDown(WebElement element, String dropdownText){
		Select selectDropdown = new Select(element);
		selectDropdown.selectByVisibleText(dropdownText);
	}

}
