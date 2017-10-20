package com.ebfs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ebfs.utilities.Log;

public class Home_Page extends BaseClass{
	
	private static WebElement element = null;
    
    public Home_Page(WebDriver driver){
        	super(driver);
    }    
    
    public static WebElement lnk_Sale() throws Exception{
        try{ 
        	 element = driver.findElement(By.xpath("//*[@id='header']/div[1]/div/div/a/img"));
             Log.info("Sale Banner link is found on the Home Page");
        }catch (Exception e){
       		Log.error("Sale Banner link is not found on the Home Page");
       		throw(e);
       		}
       	return element;
    }
    
//    public static WebElement lnk_MyAccount() throws Exception{
//        try{ 
//        	 element = driver.findElement(By.xpath(".//*[@id='account']/a"));
//             Log.info("My Account link is found on the Home Page");
//        }catch (Exception e){
//       		Log.error("My Account link is not found on the Home Page");
//       		throw(e);
//       		}
//       	return element;
//    }

}
