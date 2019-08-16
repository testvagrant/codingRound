package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.CommonMethods;

public class FlightBookingPage {

	WebDriver driver;
	CommonMethods cm;
	boolean flag;

	public FlightBookingPage(WebDriver driver) {
		this.driver = driver;
		cm = new CommonMethods(driver);
	}
	
	By oneWay = By.id("OneWay");
	By fromTag = By.id("FromTag");
	By toTag = By.id("toTag");
	By originOption = By.id("ui-id-1");
	
	
	public void clickonFrom() {
		driver.findElement((oneWay)).click();
	}
	
	public void typeStartingplace() {
		driver.findElement(fromTag).sendKeys("Bangalore");
	}
	
	public void clickonTo() {
		driver.findElement(By.id("toTag")).click();
	}
	
	public void typeEndDestination() {
		driver.findElement(By.id("toTag")).sendKeys("Delhi");
	}
	
	public void searchButton() {
		driver.findElement(By.id("SearchBtn")).click();
	}
	
	//public void dateSelection() {
		//driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();
	//}
	public void searchforFlights() {
		try {
		List<WebElement> originOptionsFrom = null;
		List<WebElement> originOptionsTo = null;
	
		
		driver.findElement(oneWay).click();
		driver.findElement(fromTag).click();
        driver.findElement(toTag).sendKeys("Bangalore");

        //wait for the auto complete options to appear for the origin
        cm.waitFor(2000);
        originOptionsFrom = driver.findElement(originOption).findElements(By.tagName("li"));
        for(WebElement ele : originOptionsFrom) {
        	if(ele.getText().trim().contains("Bangalore")) {
        		ele.click();
        		
        	}
        }
        driver.findElement(By.id("toTag")).clear();
        driver.findElement(By.id("toTag")).sendKeys("Delhi");
        originOptionsFrom = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        for(WebElement ele : originOptionsTo) {
        	if(ele.getText().trim().contains("Delhi")) {
        		ele.click();
        		
        	}
        }
		}
		
        	catch(Exception e) {
        		System.out.println("Flightbooking Failed"+e.getMessage());
        	}
        	
        }
     public void clickonSearchButton() {
    	 //dateSelection();
    	 searchButton();
    	 
    	 
     }
     
     public boolean isSummaryPresent() {
 		flag = false;
 		try {
 			flag = cm.isElementPresent(By.className("searchSummary"));
 		} catch (Exception wde) {
 		}
 		return flag;
 	}

	}