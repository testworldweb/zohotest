package com.testworldweb.zohotest;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ZohoFeatures {
	
	 
	public static String postByUser(String userUniqueName) throws InterruptedException {
	
		HashMap<String,UserDetails> hm=new HashMap<String,UserDetails>();
		
		hm=populateUserData(hm);	
 
				
		WebDriver driver = new FirefoxDriver();

	        driver.get(UrlConstants.FEEDS_PAGE);

	        WebElement signInLink = driver.findElement(By.xpath(XpathConstants.signInLink));
	       if(signInLink.isDisplayed()&&signInLink.isEnabled())
	       {
	    	   signInLink.click();
	    	   Thread.sleep(10000);
	    	   driver.switchTo().frame(driver.findElement(By.id("zohoiam")));
	    	   Thread.sleep(10000);
	    	  WebElement userName = driver.findElement(By.name("lid"));
	    	  //userName.sendKeys("amya0414@gmail.com"); 
	    	  userName.sendKeys(hm.get(userUniqueName).getUserEmailId());
	    	  WebElement userPassword = driver.findElement(By.name("pwd"));
	    	  //userPassword.sendKeys("amya12345");
	    	  userPassword.sendKeys(hm.get(userUniqueName).getUserPassword());
		    	
	    	  WebElement submitButton=driver.findElement(By.id("submit_but"));
	    	  
	    	  
	    	   submitButton.click();
	    	   Thread.sleep(7000);
	    	   
	       }
	       driver.get(UrlConstants.FEEDS_PAGE);
	       Thread.sleep(10000);
	        WebElement feed_status = driver.findElement(By.id("feed_status"));
	        feed_status.click();
	       
	        String postContent=" Post by "+ userUniqueName+" through script at "+currentTimeStamp();
	        feed_status.sendKeys(postContent);

	       Thread.sleep(3000);
	       WebElement save_status = driver.findElement(By.id("save_status"));
		      
	       save_status.click();
	       Thread.sleep(7000);
	       
	        Thread.sleep(8000);
	        driver.quit();
	        return postContent;
	    }
	
  public static String currentTimeStamp()
  {
	  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  Date date = new Date();
	  return (dateFormat.format(date).toString()); 
  }
  public static boolean textfoundOnUserFeed(String userUniqueName,String textToSearch) throws InterruptedException
  {
	HashMap<String,UserDetails> hm=new HashMap<String,UserDetails>();
		
		hm=populateUserData(hm);	
 
				
		WebDriver driver = new FirefoxDriver();

	        driver.get(UrlConstants.FEEDS_PAGE);

	        WebElement signInLink = driver.findElement(By.xpath(XpathConstants.signInLink));
	       if(signInLink.isDisplayed()&&signInLink.isEnabled())
	       {
	    	   signInLink.click();
	    	   Thread.sleep(10000);
	    	   driver.switchTo().frame(driver.findElement(By.id("zohoiam")));
	    	   Thread.sleep(10000);
	    	  WebElement userName = driver.findElement(By.name("lid"));
	    	  //userName.sendKeys("amya0414@gmail.com"); 
	    	  userName.sendKeys(hm.get(userUniqueName).getUserEmailId());
	    	  WebElement userPassword = driver.findElement(By.name("pwd"));
	    	  //userPassword.sendKeys("amya12345");
	    	  userPassword.sendKeys(hm.get(userUniqueName).getUserPassword());
		    	
	    	  WebElement submitButton=driver.findElement(By.id("submit_but"));
	    	  
	    	  
	    	   submitButton.click();
	    	   Thread.sleep(7000);
	    	   
	       }
	       driver.get(UrlConstants.FEEDS_PAGE);
	       Thread.sleep(10000);
	       String bodyText = driver.getPageSource();
	       System.out.println("-------------");
	      // System.out.println(bodyText);
	       System.out.println("-------------");
	       
	      return  bodyText.contains(textToSearch);

	  
  }
  public static HashMap<String,UserDetails> populateUserData(HashMap<String,UserDetails> hm)
  {
	  Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("user.properties");

			prop.load(input);

			
			 Set<Object> keys = prop.keySet();
			        for(Object k:keys){
			            String key = (String)k;
			            String keyVal=prop.getProperty(key);
			            String split[]=keyVal.split(",");
			            String userEmail=split[0];
			            String userPassword=split[1];
			            
			            UserDetails ud=new UserDetails(userEmail,userPassword);
			            hm.put(key, ud);
			            
			        }

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return hm;
		
  }
}
