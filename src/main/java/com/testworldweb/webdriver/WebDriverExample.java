package com.testworldweb.webdriver;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
/**
 * Using WebDriver to test google search page 
 * @author testworldweb
 *
 */
public class WebDriverExample {
	/**
	 * Open google search page 
	 * Type the search query, and verify that the page title  contains the search term 
	 * @throws InterruptedException
	 */
	 @Test
	 public void testGoogleSearch() throws InterruptedException
	 {
		   WebDriver driver = new FirefoxDriver();

	        driver.get("http://www.google.com");

	        WebElement element = driver.findElement(By.name("q"));

	        

	        System.out.println("Page title is: " + driver.getTitle());
	        
	        element.sendKeys("3qi labs");
	        element.submit();
	        Thread.sleep(3000);
	        String pageTitle= driver.getTitle();
	        Assert.assertTrue(pageTitle.contains("Google"));
	        Assert.assertFalse(pageTitle.contains("3qilabs"));
	        Assert.assertTrue(driver.getPageSource().contains("3qilabs"));
	        
	       
	        Thread.sleep(3000);
	        driver.quit();
	    }


}
