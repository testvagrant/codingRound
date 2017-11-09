package com.testvagrant.codinground.pageObjects;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.testvagrant.codinground.utilities.ConfigFileReader;
import com.testvagrant.codinground.utilities.SeleniumUtilities;

import net.bytebuddy.matcher.ElementMatchers;

public class BasePage {


	WebDriver driver;
	private JavascriptExecutor js;
	SeleniumUtilities wait;
	

	public BasePage(WebDriver driver){
		
		AjaxElementLocatorFactory ajax = new AjaxElementLocatorFactory(driver, 30);
		
		PageFactory.initElements(ajax, this);
		
		this.driver = driver;
		wait = new SeleniumUtilities(driver);
		js = (JavascriptExecutor) driver;
		
	}
	
	public void launchApplication(String url){
		System.out.println("Launching the URL :- "+url);
		driver.get(url);
	}
	
	public void closeBrowser(){
		driver.quit();
	}
	
	public boolean isDisplayed(WebElement element){
		boolean flag= false;
		try{
			flag = element.isDisplayed();
		}catch(NoSuchElementException ex ){
			System.out.println(element+ " :- " + "Element not found on the page");
		}
		return flag;
	}
	
	
	public void selectByText(WebElement element, String text){
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void switchToFrame(WebElement frame){
		driver.switchTo().frame(frame);
	}
	
	
}
